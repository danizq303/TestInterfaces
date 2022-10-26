package Colecciones;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class Clase05 {
    public static void main(String[] args) {
        TreeSet <Integer> treeSet = new TreeSet<>();

        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(1);

        imprimirCollecion(treeSet);

        TreeSet <String> treeSet1 = new TreeSet<>();

        treeSet1.add("hola");
        treeSet1.add("adios");
        treeSet1.add("hola");
        treeSet1.add("Hola");

        imprimirCollecion(treeSet1);
    }

    public static void imprimirCollecion(Collection array) {
        if (array.isEmpty())
            System.out.println("Coleccion vacia");
        else {
            Iterator lit = array.iterator();
            do {
                System.out.println(lit.next());
            } while (lit.hasNext());
        }
    }
}
