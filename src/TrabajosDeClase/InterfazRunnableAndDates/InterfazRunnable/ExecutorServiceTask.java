package TrabajosDeClase.InterfazRunnableAndDates.InterfazRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTask {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Tarea #" + taskNumber + " ejecutada por el hilo " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
