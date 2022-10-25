import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class LaOca {
    private static final Logger logging = PSPLogger.getLogger(LaOca.class.getName());

    private static class Jugador implements Runnable {
        @Override
        public void run() {
            Random rd = new Random();
            int pos = 0;
            final int OBJETIVO = 100;
            final int RANDOMBOUND = 2000;

            //Se define cada tarea de jugador conforme a las instrucciones.
            while (pos != OBJETIVO)
                try {
                    Thread.sleep(rd.nextInt(RANDOMBOUND));

                    logging.info("\n");

                    int dado = rd.nextInt(6) + 1;
                    logging.info(Thread.currentThread().getName() + " - Has sacado un " + dado);

                    pos += dado;

                    if (pos > OBJETIVO) {
                        pos = OBJETIVO - (pos-OBJETIVO);
                        logging.info(Thread.currentThread().getName() + " - Te has pasado, ahora tu posicion es " + pos);
                    }

                    logging.info(Thread.currentThread().getName() + " - Tu posicion es " + pos);

                } catch (InterruptedException e) {
                    break;
                }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        final int NUMJUGADORES = 10;

        for (int i = 0; i < NUMJUGADORES; i++)
            threads.add(new Thread(new Jugador()));

        //Se lanzan las tareas adecuadamente desde el programa principal.
        logging.fine("Threads iniciados");
        for (Thread t : threads) {
            t.start();
        }

        boolean isAlive = true;

        //El programa principal hace las comprobaciones de estado de las tareas correctamente en el periodo especificado.
        while (isAlive) {
            //El programa principal hace las comprobaciones de estado de las tareas correctamente en el periodo especificado.
            Thread.sleep(20);

            for (Thread thread : threads) {
                if (!thread.isAlive()) {
                    //El programa principal averigua correctamente quién es el vencedor.
                    logging.info(thread.getName() + " HA GANADO");

                    for (Thread j:threads)
                        //El programa principal para correctamente el resto de las tareas.
                        if (!j.equals(thread))
                            j.interrupt();

                    logging.fine("Threads interrumpidos");

                    for (Thread j: threads)
                        //El programa principal espera al final de todas las tareas
                        j.join();

                    logging.fine("Threads finalizados");

                    isAlive = false;
                    break;
                }
            }
        }
    }
}