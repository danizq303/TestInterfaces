package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Clase16 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File f = new File("C:\\prueba\\fichEmpleados.xml");

        Element element = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(f);
        NodeList empleados = document.getElementsByTagName("empleado");

        System.out.println(empleados.getLength());

        /*for (int i = 0; i < empleados.getLength(); i++) {
            Node empleado = empleados.item(i);
            NodeList datosEmpleado = empleado.getChildNodes();

            for (int j = 0; j < datosEmpleado.getLength(); j++) {
                Node dato = datosEmpleado.item(j);
                if (dato.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(dato.getNodeName() + ": " + dato.getTextContent());
                }
            }
        }*/

        for (int i = 0; i < empleados.getLength(); i++) {
            Node empleado = empleados.item(i);
            element = (Element) empleado;
            System.out.println(element.getElementsByTagName("id").item(i).getTextContent());
            System.out.println(element.getElementsByTagName("apellido").item(i).getTextContent());
        }
    }
}
