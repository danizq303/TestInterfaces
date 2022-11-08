package XML;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class Clase17 {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();

        MiDefaultHandler handler = new MiDefaultHandler();

        reader.setContentHandler(handler);

        InputSource fileXML = new InputSource("C:\\prueba\\fichEmpleados.xml");

        reader.parse(fileXML);
    }
}

class MiDefaultHandler extends DefaultHandler {
    MiDefaultHandler() {
        super();
    }

    public void startDocument() {
        System.out.println("Comienzo del documento XML");
    }

    public void endDocument() {
        System.out.println("Fin del documento XML");
    }

    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        System.out.printf("\tComienzo elemento: %s %n", nombre);
        for (int i = 0; i < atts.getLength(); i++) {
            System.out.printf("\t\tAtributo: %s=%s %n", atts.getLocalName(i), atts.getValue(i));
        }
    }

    public void endElement(String uri, String nombre, String nombreC) {
        System.out.printf("\tFin elemento: %s %n", nombre);
    }

    public void characters(char[] ch, int inicio, int longitud) {
        String car = new String(ch, inicio, longitud);
        System.out.println("\t\t" + car);
    }
}

