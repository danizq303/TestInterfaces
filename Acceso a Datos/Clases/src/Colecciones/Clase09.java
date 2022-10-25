package Colecciones;

import java.io.*;

public class Clase09 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\prueba\\fichero.txt");

        // System.out.println(f.getName());

        BufferedWriter bW = new BufferedWriter(new FileWriter(f));

        bW.append('g');
        bW.write('x');
        bW.append("Hola");

        bW.close();

        BufferedReader bR = new BufferedReader(new FileReader(f));
        //BufferedReader bR = new BufferedReader(new InputStreamReader(new FileInputStream(f), "ISO-8859-1"));

        String str;
        while ((str = bR.readLine()) != null)
            System.out.println(str);

        bR.close();
    }
}
