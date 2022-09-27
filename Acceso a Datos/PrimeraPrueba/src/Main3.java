import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        short tam = 1;
        short i = 0, cont = 0;

        String[] array = new String[tam];

        final String ENDLOOPLABEL = "FIN";
        final String GETDATALABEL = "Animal:";


        String animal = getStringFromKeyBoard(GETDATALABEL);
        i++;

        while (!animal.equalsIgnoreCase(ENDLOOPLABEL)) {
            for (String s : array) {
                if (s.equalsIgnoreCase(array[i]))
                    cont++;
            }

            array[i] = animal;

            String[] aux = new String[array.length];
            System.arraycopy(array,0,aux,array.length-1,array.length);

            animal = getStringFromKeyBoard(GETDATALABEL);
        }

        System.out.println("Animales repetidos: " + cont);
    }

    public static String getStringFromKeyBoard(String label) {
        Scanner sc = new Scanner(System.in);

        System.out.println(label);

        return sc.nextLine();
    }
}
