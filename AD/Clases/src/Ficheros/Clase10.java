package Ficheros;

import java.io.*;

public class Clase10 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\prueba\\fichero.bin");

        FileOutputStream fileOutputStream = new FileOutputStream(f,false);

        fileOutputStream.write('c');
        fileOutputStream.write('x');
        fileOutputStream.write(1);
        fileOutputStream.write(2);

        fileOutputStream.close();


        FileInputStream fileInputStream = new FileInputStream(f);

        int car;
        while ((car = fileInputStream.read()) != -1)
            System.out.println((char)car);

        fileInputStream.close();
    }
}
