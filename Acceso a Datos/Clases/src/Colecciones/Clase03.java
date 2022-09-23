package Colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Clase03 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        al.add(1);
        al.add(4);
        al.add(5);

        HashSet<Integer> hashSet = new HashSet<>(al);

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(1);

        imprimirCollecion(hashSet);

        Persona p1 = new Persona("Pepe", 15);
        Persona p2 = new Persona("Juan", 16);
        Persona p3 = new Persona("Pepe", 15);

        HashSet<Persona> hashSet1 = new HashSet<>();

        hashSet1.add(p1);
        hashSet1.add(p2);
        hashSet1.add(p3);
        hashSet1.add(p2);

        imprimirCollecion(hashSet1);
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
