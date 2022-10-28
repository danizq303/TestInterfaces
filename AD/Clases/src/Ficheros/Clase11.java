package Ficheros;

import java.io.*;

public class Clase11 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\prueba\\fichero.bin");

        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(f));

        dataOutputStream.writeUTF("Hola");

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(f));

        try {
            System.out.println(dataInputStream.readUTF());
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        }


    }
}
