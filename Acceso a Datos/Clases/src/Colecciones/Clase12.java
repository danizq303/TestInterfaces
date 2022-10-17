package Colecciones;

import java.io.*;

public class Clase12 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\prueba\\ficheroObj.bin");

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(f));

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(f));
    }
}
