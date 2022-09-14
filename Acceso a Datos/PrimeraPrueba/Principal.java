import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce numero de 4 cifras: ");
        String num = sc.nextLine();

        while (num.length() == 4) {
            array.add(Integer.parseInt(num));
            System.out.println("Introduce numero de 4 cifras: ");
            num = sc.nextLine();
        }

        sc.close();

        System.out.println("Fin de peticion de numeros");

        System.out.println("Impresion del array a la derecha:");
        imprimirArrayList(true,array);
        System.out.println("Impresion del array a la izquierda:");
        imprimirArrayList(false,array);
    }

    public static void imprimirArrayList(boolean direccionDerecha, ArrayList<Integer> array) {
        if (direccionDerecha)
            for (Integer num:array)
                System.out.println(num);
        else
            for (int i = array.size() - 1; i >= 0; i--)
                System.out.println(array.get(i));
    }

}