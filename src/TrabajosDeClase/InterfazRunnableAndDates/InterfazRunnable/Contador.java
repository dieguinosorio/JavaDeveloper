package TrabajosDeClase.InterfazRunnableAndDates.InterfazRunnable;

public class Contador implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.err.println("El hilo ha sido interrumpido.");
        }
    }

    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread hilo = new Thread(contador);
        hilo.start();
    }
}
