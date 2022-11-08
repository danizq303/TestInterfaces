package XML;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class Clase18 {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();

        MiDefaultHandler2 handler = new MiDefaultHandler2();

        reader.setContentHandler(handler);

        InputSource fileXML = new InputSource("C:\\prueba\\fichEmpleados.xml");

        reader.parse(fileXML);
    }
}

class MiDefaultHandler2 extends DefaultHandler {
    boolean bId = false;
    MiDefaultHandler2() {
        super();
    }

    public void startDocument() {
        System.out.println("Comienzo del documento XML");
    }

    public void endDocument() {
        System.out.println("Fin del documento XML");
    }

    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        if (nombreC.equals("id"))
            bId = true;
    }

    public void endElement(String uri, String nombre, String nombreC) {
    }

    public void characters(char[] ch, int inicio, int longitud) {
        if (bId) {
            String car = new String(ch, inicio, longitud);
            System.out.println("\t\t" + car);
            bId = false;
        }
    }
}

