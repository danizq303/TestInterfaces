package XML;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class Clase19 {
    public static void main(String[] args) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        File f = new File("C:\\prueba\\fichEmpleados.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(f);

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        XPathExpression xPathExpression = xPath.compile("//empleado[id='2']/apellidos/apellido2/text()");
        Object obj = xPathExpression.evaluate(document, XPathConstants.NODESET);
        NodeList nodeList = (NodeList) obj;

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }

        xPathExpression = xPath.compile("count(//empleado)");
        obj = xPathExpression.evaluate(document, XPathConstants.NUMBER);
        System.out.println(obj);
        
        xPathExpression = xPath.compile("//empleado[apellidos/@orden='primero']/apellidos/apellido1/text()");
        obj = xPathExpression.evaluate(document, XPathConstants.NODESET);
        nodeList = (NodeList) obj;

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
    }
}
