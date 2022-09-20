package Colecciones;

import java.util.*;

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
    }

    public static void imprimirCollecion(Collection<Integer> array) {
        Iterator<Integer> lit = array.iterator();

        do {
            System.out.println(lit.next());
        } while (lit.hasNext());
    }
}
