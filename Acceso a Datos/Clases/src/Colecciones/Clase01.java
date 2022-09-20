package Colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Clase01 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        al.add(1);
        al.add(2);
        al.add(3);

        //al.add("Hola");
        //al.add(true);

        /*for (Object o : al) {
            System.out.println(o);
        }

        Iterator <Integer> it = al.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }*/

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