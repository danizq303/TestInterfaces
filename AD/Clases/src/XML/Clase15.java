package XML;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Clase15 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        File f = new File("C:\\prueba\\fichEmpleados.xml");

        Element raiz, elem, elemSub, elemAtr;
        Text texto;
        Attr atributo;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Empleados", null);
        document.setXmlVersion("1.0");

        raiz = document.createElement("empleado");
        document.getDocumentElement().appendChild(raiz);

        elem = document.createElement("id");
        texto = document.createTextNode("1");
        raiz.appendChild(elem);
        elem.appendChild(texto);

        elem = document.createElement("apellidos");
        raiz.appendChild(elem);
        atributo = document.createAttribute("orden");
        atributo.setValue("primero");
        elem.setAttributeNode(atributo);

        elemSub = document.createElement("apellido1");
        texto = document.createTextNode("Sanz");
        elem.appendChild(elemSub);
        elemSub.appendChild(texto);

        elemSub = document.createElement("apellido2");
        texto = document.createTextNode("Ortega");
        elem.appendChild(elemSub);
        elemSub.appendChild(texto);

        elem = document.createElement("departamento");
        texto = document.createTextNode("150");
        raiz.appendChild(elem);
        elem.appendChild(texto);


        raiz = document.createElement("empleado");
        document.getDocumentElement().appendChild(raiz);

        elem = document.createElement("id");
        texto = document.createTextNode("2");
        raiz.appendChild(elem);
        elem.appendChild(texto);

        elem = document.createElement("apellidos");
        raiz.appendChild(elem);
        atributo = document.createAttribute("orden");
        atributo.setValue("primero");
        elem.setAttributeNode(atributo);

        elemSub = document.createElement("apellido1");
        texto = document.createTextNode("Izquierdo");
        elem.appendChild(elemSub);
        elemSub.appendChild(texto);

        elemSub = document.createElement("apellido2");
        texto = document.createTextNode("Bonilla");
        elem.appendChild(elemSub);
        elemSub.appendChild(texto);

        elem = document.createElement("departamento");
        texto = document.createTextNode("777");
        raiz.appendChild(elem);
        elem.appendChild(texto);

        Source source = new DOMSource(document);
        Result result = new StreamResult(f);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
    }
}
