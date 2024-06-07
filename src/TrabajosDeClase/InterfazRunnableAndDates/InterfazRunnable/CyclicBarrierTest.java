package TrabajosDeClase.InterfazRunnableAndDates.InterfazRunnable;

import java.util.concurrent.*;

public class CyclicBarrierTest {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("Todos los hilos han completado su tarea."));


        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            executor.submit(() -> {
                try {
                    int duration = ThreadLocalRandom.current().nextInt(1, 4);
                    System.out.println(Thread.currentThread().getName() + " está ejecutando una tarea que tardará " + duration + " segundos.");
                    Thread.sleep(duration * 1000);

                    System.out.println(Thread.currentThread().getName() + " ha llegado a la barrera.");
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
