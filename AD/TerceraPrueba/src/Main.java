import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //TODO Con el fichero de texto dado, crear otro fichero quijote_codificado.txt, cada vocal será la siguiente (a,e,i,o,u)
        // las tildes no se tienen en cuenta, mayusculas y minusculas se respetan

        File f1 = new File("quijote.txt");
        File f2 = new File("quijote_cifrado.txt");

        BufferedReader bR = new BufferedReader(new FileReader(f1));
        BufferedWriter bW = new BufferedWriter(new FileWriter(f2,false));

        char[] vocalesMinus = {'a', 'e', 'i', 'o', 'u'};
        char[] vocalesMayus = {'A', 'E', 'I', 'O', 'U'};
        byte tam = (byte) vocalesMayus.length;

        String str;
        String aux = "";
        while ((str = bR.readLine()) != null) {
            aux = "";
            for (int i = 0; i < str.length(); i++) {
                char vocal = ' ';

                for (int j = 0; j < tam; j++) {
                    if (str.charAt(i) == vocalesMayus[j])
                        if (j + 1 >= tam)
                            vocal = vocalesMayus[j-1];
                        else
                            vocal = vocalesMayus[j+1];

                    else if (str.charAt(i) == vocalesMinus[j])
                        if (j + 1 >= tam)
                            vocal = vocalesMinus[j-1];
                        else
                            vocal = vocalesMinus[j+1];
                }

                if (vocal == ' ')
                    aux += str.charAt(i);
                else
                    aux += vocal;
            }
            bW.write(aux);
            bW.newLine();
        }

        bR.close();
        bW.close();

        //Leer el fichero cifrado y mostrarlo por pantalla
        BufferedReader bR2 = new BufferedReader(new FileReader(f2));
        String str2;
        while ((str2 = bR2.readLine()) != null) {
            System.out.println(str2);
        }
    }
}