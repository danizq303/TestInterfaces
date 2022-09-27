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
        final String GETDATALABEL = "Animal:";


        String animal = getStringFromKeyBoard(GETDATALABEL,sc);

        while (!animal.equalsIgnoreCase(ENDLOOPLABEL)) {
            if (arrayList.contains(animal))
                cont++;

            arrayList.add(animal);

            animal = getStringFromKeyBoard(GETDATALABEL,sc);
        }

        System.out.println("Animales repetidos: " + cont);
    }

    public static void usandoHashSet(Scanner sc) {
        HashSet<String> hashSet = new HashSet<>();

        short cont = 0;

        final String ENDLOOPLABEL = "FIN";
        final String GETDATALABEL = "Animal:";


        String animal = getStringFromKeyBoard(GETDATALABEL,sc);

        while (!animal.equalsIgnoreCase(ENDLOOPLABEL)) {
            if (hashSet.contains(animal))
                cont++;

            hashSet.add(animal);

            animal = getStringFromKeyBoard(GETDATALABEL,sc);
        }

        System.out.println("Animales repetidos: " + cont);
    }

    public static String getStringFromKeyBoard(String label, Scanner sc) {
        System.out.println(label);

        return sc.nextLine();
    }
}

