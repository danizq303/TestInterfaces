package Colecciones;

import java.util.*;

public class Clase06 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(2, "Juanito");
        hashMap.put(1, "Pepe");
        hashMap.put(7, "Pepe");
        hashMap.put(3,"Jacinto");
        hashMap.put(4, "Alberto");

        imprimirMapa(hashMap);

        System.out.println();

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(2, "Juanito");
        linkedHashMap.put(1, "Pepe");
        linkedHashMap.put(7, "Pepe");
        linkedHashMap.put(3, "Jacinto");
        linkedHashMap.put(4, "Alberto");

        imprimirMapa(linkedHashMap);

        System.out.println();

        TreeMap<Integer, String> integerStringTreeMap = new TreeMap<>();

        integerStringTreeMap.put(2, "Juanito");
        integerStringTreeMap.put(1, "Pepe");
        integerStringTreeMap.put(7, "Pepe");
        integerStringTreeMap.put(4, "Alberto");
        integerStringTreeMap.put(3, "Jacinto");


        imprimirMapa(integerStringTreeMap);
    }

    public static void imprimirMapa(Map<Integer, String > mapa) {

        if (!mapa.isEmpty()) {
            for (String s: mapa.values()) {
                System.out.println(s);
            }
        } else
            System.out.println("HasMap vacio");
    }
}
