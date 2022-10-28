package Ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Clase13 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\prueba\\ficheroRandom.bin");

        RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");

        randomAccessFile.writeUTF("AAAAA");
        randomAccessFile.writeInt(1);
        randomAccessFile.writeUTF("BBBBB");
        randomAccessFile.writeInt(2);

        //randomAccessFile.close();
        System.out.println("Lenght: " + randomAccessFile.length());
        System.out.println(randomAccessFile.getFilePointer());
        randomAccessFile.seek(0);
        System.out.println(randomAccessFile.getFilePointer());
        //randomAccessFile = new RandomAccessFile(f,"r");

        try {
            while (true)
                System.out.println(randomAccessFile.readUTF() + ' ' + randomAccessFile.readInt());
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Leer segundo dato
        randomAccessFile.seek(0);
        randomAccessFile.seek(randomAccessFile.getFilePointer() + 15);
        System.out.println(randomAccessFile.readUTF() + ' ' + randomAccessFile.readInt());

        randomAccessFile.close();
    }
}
