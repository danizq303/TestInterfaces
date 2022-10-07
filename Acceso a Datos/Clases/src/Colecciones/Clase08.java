package Colecciones;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Clase08 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\prueba\\fichero.txt");

        System.out.println(f.getName());

        FileWriter fw = new FileWriter(f);

        fw.write('c');
        fw.close();
    }
}
