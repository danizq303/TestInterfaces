package Colecciones;

import java.util.Iterator;

public class Tests {
    public static void main(String[] args) {
        //Crear un array de 5 string, recorrelo con un for each y muestra por pantalla el contenido.

        String[] array = new String[5];
        array[0] = "Hola";
        array[1] = "que";
        array[2] = "tal";
        array[3] = "estas";
        array[4] = "hoy";

        for (String s : array) {
            System.out.println(s);
        }
    }
}
