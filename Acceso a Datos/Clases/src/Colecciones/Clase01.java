package Colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Clase01 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        al.add(1);
        al.add(2);
        al.add(3);

        ListIterator<Integer> listIterator = al.listIterator();

        System.out.println("Imprimir derecha");
        imprimirLista(true, al);

        System.out.println("Imprimir izquierda");
        //al = new ArrayList<>();
        imprimirLista(false, al);
    }

    public static void imprimirLista(boolean direccionDerecha, List<Integer> array) {
        ListIterator<Integer> lit = array.listIterator();

        if (!lit.hasNext())
            System.out.println("Coleccion vacia");
        else {
            if (direccionDerecha)
                do {
                    System.out.println(lit.next());
                } while (lit.hasNext());
            else {
                lit = array.listIterator(array.size());
                do {
                        System.out.println(lit.previous());
                } while (lit.hasPrevious());
            }
        }
    }


}