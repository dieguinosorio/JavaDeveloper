package TrabajosDeClase.InterfazRunnableAndDates.InterfazRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class TareaConcurrencia implements Runnable{
    private final int id;

    public TareaConcurrencia(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        int duration = ThreadLocalRandom.current().nextInt(1, 4);
        System.out.println("Tarea #" + id + " ejecutada por " + Thread.currentThread().getName() + " durará " + duration + " segundos.");

        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Tarea #" + id + " fue interrumpida.");
        }

        System.out.println("Tarea #" + id + " completada por " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            TareaConcurrencia tarea = new TareaConcurrencia(i);
            executor.submit(tarea);
        }

        executor.shutdown();
    }
}
