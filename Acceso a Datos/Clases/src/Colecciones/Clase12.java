package Colecciones;
import java.io.*;

class MyObjectOutputStream extends ObjectOutputStream {

    // Constructor of this class
    // 1. Default
    MyObjectOutputStream() throws IOException
    {

        // Super keyword refers to parent class instance
        super();
    }

    // Constructor of this class
    // 1. Parameterized constructor
    MyObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }

    // Method of this class
    public void writeStreamHeader() throws IOException
    {
        return;
    }
}
public class Clase12 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\prueba\\ficheroObj.bin");

        MyObjectOutputStream outputStream = new MyObjectOutputStream(new FileOutputStream(f,true));

        outputStream.writeObject("Primero");
        outputStream.writeObject("Segundo");

        outputStream.close();

        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(f));

            while (true)
                System.out.println(inputStream.readObject());
        } catch (Exception e) {
            System.out.println(e);
        }

        inputStream.close();
    }
}
