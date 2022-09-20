package Colecciones;

import java.util.LinkedList;

public class Clase02 {
    public static void main(String[] args) {
        LinkedList<Integer> lk = new LinkedList<>();

        lk.add(1);
        lk.add(2);
        lk.add(3);

        System.out.println(lk.getLast());

        lk.addFirst(0);

        System.out.println("Imprimir derecha");
        Clase01.imprimirLista(true, lk);

        System.out.println("Imprimir izquierda");
        Clase01.imprimirLista(false, lk);
    }
}
