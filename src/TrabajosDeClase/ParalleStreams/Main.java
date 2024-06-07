package TrabajosDeClase.ParalleStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
    }

    // Ejercicio 1: Usar parallelStream() para imprimir números con nombres de hilos
    private static void ejercicio1() {
        IntStream numbers = IntStream.rangeClosed(1, 100);
        numbers.parallel().forEach(number -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Número: " + number + ", Hilo: " + threadName);
        });
    }

    // Ejercicio 2: Comparar resultados entre parallelStream() y stream()
    private static void ejercicio2() {
        List<Integer> numeros = new Random().ints(200, 1, 1000).boxed().collect(Collectors.toList());

        double sumaParallel = numeros.parallelStream().mapToDouble(Integer::doubleValue).sum();
        double promedioParallel = numeros.parallelStream().mapToDouble(Integer::doubleValue).average().orElse(0);

        double sumaStream = numeros.stream().mapToDouble(Integer::doubleValue).sum();
        double promedioStream = numeros.stream().mapToDouble(Integer::doubleValue).average().orElse(0);

        System.out.println("Usando parallelStream():");
        System.out.println("Suma: " + sumaParallel);
        System.out.println("Promedio: " + promedioParallel);

        System.out.println("\nUsando stream():");
        System.out.println("Suma: " + sumaStream);
        System.out.println("Promedio: " + promedioStream);

        System.out.println("\nComparación:");
        System.out.println("Diferencia en suma: " + (sumaParallel - sumaStream));
        System.out.println("Diferencia en promedio: " + (promedioParallel - promedioStream));
    }

    // Ejercicio 3: Encontrar cualquier número par usando parallelStream() y stream()
    private static void ejercicio3() {
        List<Integer> numeros2 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        Integer numeroParParallel = numeros2.parallelStream()
                .filter(num -> num % 2 == 0)
                .findAny()
                .orElse(null);

        Integer numeroParStream = numeros2.stream()
                .filter(num -> num % 2 == 0)
                .findAny()
                .orElse(null);

        System.out.println("\nUsando parallelStream(): " + numeroParParallel);
        System.out.println("Usando stream(): " + numeroParStream);
        System.out.println("Los resultados son iguales: " + numeroParParallel.equals(numeroParStream));
    }

    // Ejercicio 4: Usar reduce() para sumar las edades de todas las personas
    private static void ejercicio4() {
        List<Persona> personas = Arrays.asList(
                new Persona("Juan", 25),
                new Persona("María", 30),
                new Persona("Carlos", 40),
                new Persona("Luisa", 35)
        );

        int sumaEdades = personas.parallelStream()
                .mapToInt(Persona::getEdad)
                .reduce(0, Integer::sum);

        System.out.println("\nLa suma de las edades de todas las personas es: " + sumaEdades);
    }

    // Ejercicio 5: Usar reduce() para sumar números y concatenar cadenas
    private static void ejercicio5() {
        List<Integer> numerosTest = IntStream.rangeClosed(1, 50)
                .boxed()
                .collect(Collectors.toList());

        int suma = numerosTest.stream()
                .reduce(0, Integer::sum);

        System.out.println("\nLa suma de los números del 1 al 50 es: " + suma);

        List<String> cadenas = List.of("Hola", " ", "mundo", " Java");

        String resultado = cadenas.stream()
                .reduce("", String::concat);

        System.out.println("Las cadenas concatenadas son: " + resultado);
    }
}