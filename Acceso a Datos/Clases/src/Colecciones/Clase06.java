package Colecciones;

import java.util.Collection;
import java.util.HashMap;

public class Clase06 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "Pepe");
        hashMap.put(2, "Juanito");
        hashMap.put(3, "Pepe");

        imprimirMapa(hashMap);
    }

    public static void imprimirMapa(HashMap<Integer, String > mapa) {
        Collection<String> collection = mapa.values();

        for (String s: collection) {
            System.out.println(s);
        }
    }
}
