package EjerciciosInterfacesFuncionales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class InterfacesFuncionales {
    public static void main(String[] args) {
        //Predicate
        Predicate<Integer> isPartner = number -> number % 2 == 0;
        System.out.println(isPartner.test(4));
        System.out.println(isPartner.test(5));

        //Consumer
        List<String> listNames = Arrays.asList("Ana", "Juan", "Carlos", "Luisa");
        Consumer<String> printName = name -> System.out.println(name);
        listNames.forEach(printName);


        //Function
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Function<Integer, Integer> square = number -> number * number;
        List<Integer> squares = numbers.stream()
                .map(square)
                .collect(Collectors.toList());

        System.out.println(squares);

        //Supplier
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);

        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomNumbers.add(randomSupplier.get());
        }
        System.out.println(randomNumbers);

        //UnaryOperator
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        List<String> upperCaseNames = listNames.stream()
                .map(toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseNames);
    }
}
