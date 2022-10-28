package Ficheros;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Clase08 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\prueba\\fichero.txt");

       // System.out.println(f.getName());

        FileWriter fw = new FileWriter(f);

        fw.append('g');
        fw.write('x');
        fw.append("Hola");

        fw.close();

        FileReader fileReader = new FileReader(f);

        int i = 0;
        i = fileReader.read();
        while (i != -1) {
            System.out.println((char) i);
            i = fileReader.read();
        }

        fw.close();
    }
}
