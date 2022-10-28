package Ficheros;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class Clase15 {
    public static void main(String[] args) throws ParserConfigurationException {
        File f = new File("C:\\prueba\\fichEmpleados.xml");

        Element raiz, elem, elemSub, elemAtr;
        Text texto;
        Attr atributo;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        DOMImplementation implementation = builder.getDOMImplementation();

        /*<?xml version="1.0" encoding="UTF-8"?>
        <Empleados>
            <empleado>
                <id>1</id>
                <apellidos orden = "primero">
                    <apellido>Sanz</apellido>
                    <apellido>Ortega</apellido>
                </apellidos>
            </empleado>
        </Empleados>*/

        Document document = implementation.createDocument(null, "Empleados", null);
        document.setXmlVersion("1.0");

        raiz = document.createElement("empleado");
        document.getDocumentElement().appendChild(raiz);

        elem = document.createElement("id");
        texto = document.createTextNode("1");
        raiz.appendChild(elem);
        elem.appendChild(texto);
    }
}
