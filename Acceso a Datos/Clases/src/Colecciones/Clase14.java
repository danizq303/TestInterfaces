package Colecciones;

import java.io.*;
import java.util.Scanner;

public class Clase14 {
    public static void main(String[] args) throws IOException {
        //TODO pedir por pantalla 3 registros 1 str 1 int y 1 char.
        //TODO leerlo y posicionarme en el registro 3 e imprimirlo para ver que, efectivamente nos estamos situando bien.

        File f = new File("C:\\prueba\\ficheroRandomEj.bin");

        RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
        Scanner sc = new Scanner(System.in);

        final int TAMSTRING = 15;
        final int TAMINT = 4;

        String str;
        int num;
        char c;

        //Pedir string por pantalla controlando que no tenga mas de 15 chars, si es menor rellenar el resto de la string con espacios.
        do {
            System.out.println("Introduce una string de maximo 15 caracteres");
            str = sc.nextLine();
            if (str.length() > TAMSTRING) {
                str = str.substring(0, TAMSTRING);
            } else {
                for (int i = str.length(); i < TAMSTRING; i++) {
                    str += " ";
                }
            }
        } while (str.length() > TAMSTRING);


        //Pedir int por pantalla controlando que no tenga más de 4 digitos.
        do {
            System.out.println("Introduce un numero de maximo 4 digitos");
            num = sc.nextInt();
        } while (num > 9999);

        System.out.println("Introduce caracter");
        c = sc.next().charAt(0);

        //Escribir en el fichero

        randomAccessFile.writeUTF(str);
        randomAccessFile.writeInt(num);
        randomAccessFile.writeChar(c);

        randomAccessFile.seek(0);
        try {
            while (true)
                System.out.println(randomAccessFile.readUTF() + ' ' + randomAccessFile.readInt() + ' ' + randomAccessFile.readChar());
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        randomAccessFile.seek(0);
        randomAccessFile.seek((TAMSTRING + TAMINT + 2));

        try {
            while (true)
                System.out.println(randomAccessFile.readUTF() + ' ' + randomAccessFile.readInt() + ' ' + randomAccessFile.readChar());
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        randomAccessFile.close();
    }
}
