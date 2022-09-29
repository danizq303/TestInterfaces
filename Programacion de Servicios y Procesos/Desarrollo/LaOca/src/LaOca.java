import java.util.ArrayList;
import java.util.Random;

public class LaOca {
    private static class Jugador implements Runnable {
        @Override
        public void run() {
            Random rd = new Random();
            int pos = 0;
            final int objetivo = 10;

            while (pos != objetivo)
                try {
                    Thread.sleep(rd.nextInt(2000));

                    System.out.println();

                    int dado = rd.nextInt(6) + 1;
                    System.out.println(Thread.currentThread().getName() + " - Has sacado un " + dado);

                    pos += dado;

                    if (pos > objetivo) {
                        pos = objetivo - dado;
                        System.out.println(Thread.currentThread().getName() + " - Te has pasado, ahora tu posicion es " + pos);
                    }

                    System.out.println(Thread.currentThread().getName() + " - Tu posicion es " + pos);

                    if (pos == objetivo)
                        System.out.println(Thread.currentThread().getName() + " HA GANADO");
                } catch (InterruptedException e) {
                    break;
                }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new Jugador()));
        threads.add(new Thread(new Jugador()));

        System.out.println("Threads Started");
        for (Thread t : threads) {
            t.start();
        }

        boolean flag = false;

        while (!flag) {
            for (Thread thread : threads) {
                if (!thread.isAlive()) {
                    for (Thread j:threads)
                        j.interrupt();
                    flag = true;
                }
            }
        }
    }
}