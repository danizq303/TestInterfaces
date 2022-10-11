import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> vuelos = new HashMap<>();

        //TODO add 6 vuelos nuevos
        agregarVuelo(vuelos,"FX378",95);
        agregarVuelo(vuelos,"FX178",20);
        agregarVuelo(vuelos,"FX278",92);
        agregarVuelo(vuelos,"FX358",123);
        agregarVuelo(vuelos,"FX478",200);
        agregarVuelo(vuelos,"FX328",35);

        //TODO add 1 vuelo ya existente
        agregarVuelo(vuelos,"FX328",35);

        System.out.println();

        //TODO Consultar 1 vuelo existente
        System.out.println(consultarVuelo(vuelos,"FX478"));
        //TODO Consultar 1 vuelo no existente
        System.out.println(consultarVuelo(vuelos,"FX1078"));

        System.out.println();

        //TODO Lista de vuelos ordenado por vuelo
        listaVuelos(vuelos);
    }

    //TODO metodo para add vuelo (tiene que comprobar si el vuelo ya existe) | no tiene que imprimir nada por pantalla salvo error
    public static void agregarVuelo(HashMap<String,Integer> vuelos, String vuelo, int tiempo) {
        if (vuelos.containsKey(vuelo))
            System.out.println("Error: Vuelo ya existente");
        else
            vuelos.put(vuelo,tiempo);
    }

    //TODO metodo para consultar un vuelo (tiene que comprobar si el vuelo existe) | no tiene que imprimir nada por pantalla salvo error
    public static String consultarVuelo(HashMap<String,Integer> vuelos, String vuelo) {
        String output = "";

        if (vuelos.containsKey(vuelo)) {
            output = "Vuelo: " + vuelo + " | Duracion: " + vuelos.get(vuelo);
        } else
            System.out.print("Error: Vuelo no existente");

        return output;
    }

    //TODO metododo para listar los vuelos (num vuelo - minutos)
    public static void listaVuelos(HashMap<String,Integer> vuelos) {
        if (!vuelos.isEmpty()) {
            final int TAM = vuelos.size();

            String[] claves = new String[TAM];
            int[] duracion = new int[TAM];

            ArrayList<String> clavesA = new ArrayList<>(vuelos.keySet());
            ArrayList<Integer> duracionA = new ArrayList<>(vuelos.values());

            for (int i = 0; i < TAM; i++) {
                claves[i] = clavesA.get(i);
            }

            for (int i = 0; i < TAM; i++)
                duracion[i] = vuelos.get(claves[i]);

            for (int i = 0; i < TAM; i++)
                System.out.println(claves[i] + '-' + duracion[i] + "minutos");

            for (int i = 0; i < TAM; i++)
                System.out.println(clavesA.get(i) + '-' + duracionA.get(i) + "minutos");
        } else
            System.out.println("No hay vuelos registrados");
    }
}