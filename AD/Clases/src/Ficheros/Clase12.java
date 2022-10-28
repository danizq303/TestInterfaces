package Ficheros;
import Colecciones.Persona;

import java.io.*;

class MyObjectOutputStream extends ObjectOutputStream {
    MyObjectOutputStream(OutputStream o) throws IOException {
        super(o);
    }

    protected void writeStreamHeader() {}
}
public class Clase12 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\prueba\\ficheroObj.bin");
        ObjectOutputStream outputStream;

        if (f.exists())
            outputStream = new MyObjectOutputStream(new FileOutputStream(f,true));
        else
            outputStream = new ObjectOutputStream(new FileOutputStream(f));

        outputStream.writeObject("Primero");
        outputStream.writeObject("Segundo");
        outputStream.writeObject("Tercero");
        Persona persona = new Persona("Daniel",19);
        outputStream.writeObject(persona);

        outputStream.close();

        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(f));

            while (true)
                System.out.println(inputStream.readObject());
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        inputStream.close();
    }
}
