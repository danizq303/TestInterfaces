package Colecciones;

import java.util.ArrayList;
import java.util.Collections;

public class Clase07 {
    public static void main(String[] args) {
        /*ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(2);
        arrayList.add(100);
        arrayList.add(50);
        arrayList.add(25);

        Clase05.imprimirCollecion(arrayList);
        System.out.println();

        Collections.sort(arrayList);

        Clase05.imprimirCollecion(arrayList);*/

        //Crear ArrayList de personas: nombre y edad
        //Ordenar las personas en base al nombre y ver si contiene un objeto determinado

        ArrayList<Persona> arrayList = new ArrayList<>();
        arrayList.add(new Persona("Daniel",19));
        arrayList.add(new Persona("Rodri",18));
        arrayList.add(new Persona("Javi",21));

        System.out.println(arrayList);

        Collections.sort(arrayList,new Persona().nombre);
    }
}
