import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        usandoArrayList(sc);
        usandoHashSet(sc);

        sc.close();
    }

    public static void usandoArrayList(Scanner sc) {
        ArrayList<String> arrayList = new ArrayList<>();

        short cont = 0;

        final String ENDLOOPLABEL = "FIN";
        final String GETDATALABEL = "Animal";


        String nombre = getStringFromKeyBoard(GETDATALABEL,sc);

        while (!nombre.equalsIgnoreCase(ENDLOOPLABEL)) {
            if (arrayList.contains(nombre))
                cont++;

            arrayList.add(nombre);

            nombre = getStringFromKeyBoard(GETDATALABEL,sc);
        }

        System.out.println(GETDATALABEL + " repetido: " + cont);
    }

    public static void usandoHashSet(Scanner sc) {
        HashSet<String> hashSet = new HashSet<>();

        short cont = 0;

        final String ENDLOOPLABEL = "FIN";
        final String GETDATALABEL = "Animal:";


        String animal = getStringFromKeyBoard(GETDATALABEL,sc);

        while (!animal.equalsIgnoreCase(ENDLOOPLABEL)) {
            cont++;

            hashSet.add(animal);

            animal = getStringFromKeyBoard(GETDATALABEL,sc);
        }

        System.out.println("Animales repetidos: " + (cont - hashSet.size()));
    }

    public static String getStringFromKeyBoard(String label, Scanner sc) {
        System.out.println(label);

        return sc.nextLine();
    }
}