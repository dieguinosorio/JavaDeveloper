package TrabajosDeClase.InterfazRunnableAndDates.InterfazRunnable;

import java.util.concurrent.*;

public class SumaCallable implements Callable<Integer> {
    private final int num1;
    private final int num2;

    public SumaCallable(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public Integer call() {
        return num1 + num2;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        SumaCallable tarea = new SumaCallable(5, 10);

        Future<Integer> resultado = executor.submit(tarea);

        try {
            Integer suma = resultado.get();
            System.out.println("El resultado de la suma es: " + suma);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
