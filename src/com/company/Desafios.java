package com.company;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Desafios {
    /*
    // Considerando a lista abaixo execute as seguintes operações usando as features do Java 8+
    // não utilize: for/while/if

    List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);

    //1 . imprima todos os itens da lista no console
    //2 . imprima os números distintos em ordem crescente
    //3 . imprima os números impares  e distintos em ordem decrescente
    //4.  imprima a soma dos números ignorando os 3 primeiros
    //5.  imprima cada número da lista multiplicado por 2
    //6.  imprima de forma agrupada os números pares e impares distintos
    //7.  imprima o maior número da lista, se não houver lance uma java.util.NoSuchElementException
    //8.  imprima apenas os 3 primeiros números da lista
    //9.  imprima a média dos números da lista, se não for possível calcular a média imprima Double.NaN
    //10. imprima a quantidade de elementos da lista, a soma de seus elementos, a média e o valor máximo
    //11. imprima a data de hoje, somando a quantidade de dias indicadas por cada elemento distinto da lista em ordem crescente
     */

    public static void main(String[] args) throws java.util.NoSuchElementException {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);

        System.out.println("(1) . imprima todos os itens da lista no console");
        numbers.forEach(System.out::println);
        System.out.println("--------********--------********--------********--------********--------");


        System.out.println("(2) . imprima os números distintos em ordem crescente");
        numbers.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("--------********--------********--------********--------********--------");


        System.out.println("(3) . imprima os números impares e distintos em ordem decrescente");
        numbers.stream()
                .distinct()
                .filter((integer -> integer % 2 != 0))
                .sorted(Collections.reverseOrder()).forEach(System.out::println);
        System.out.println("--------********--------********--------********--------********--------");


        System.out.println("(4).  imprima a soma dos números ignorando os 3 primeiros");
        System.out.println(numbers.stream()
                .skip(3)
                .reduce(Integer::sum));
        System.out.println("--------********--------********--------********--------********--------");


        /*
         AtomicInteger total = new AtomicInteger();
        numbers.stream().skip(3).forEach((inteiro ->{
            total.addAndGet(inteiro);
            System.out.println(total.get());
        }));
        */


        System.out.println("(5).  imprima cada número da lista multiplicado por 2");
        numbers.stream().map(number -> number * 2).forEach(System.out::println);
        System.out.println("--------********--------********--------********--------********--------");


        System.out.println("(6).  imprima de forma agrupada os números pares e impares ( ambos os grupos apenas números distintos)");
        System.out.println(numbers.stream()
                .distinct()
                .collect(Collectors.groupingBy(n -> n % 2)));
        System.out.println("--------********--------********--------********--------********--------");


        System.out.println("(7).  imprima o maior número da lista, se não houver lance uma java.util.NoSuchElementException");
        System.out.println(numbers.stream()
                .mapToInt(numbers::get)
                .max());
        System.out.println("--------********--------********--------********--------********--------");


        System.out.println("(8).  imprima apenas os 3 primeiros números da lista");
        numbers.stream()
                .limit(3)
                .forEach(System.out::println);
        System.out.println("--------********--------********--------********--------********--------");


        System.out.println("(9).  imprima a média dos números da lista, se não for possível calcular a média imprima Double.NaN");
        System.out.println(numbers.stream().mapToInt(numbers::get).average().orElse(Double.NaN));
        System.out.println("--------********--------********--------********--------********--------");

       /* numbers.stream().mapToInt(numbers::get).average().ifPresentOrElse(
                (value) -> {
                    System.out.println("Value is present, its: "+ value);
                },
                ()-> {
                    System.out.println("Double.NaN");
                });
        */

        System.out.println("(10). imprima a quantidade de elementos da lista, a soma de seus elementos, a média e o valor máximp");
        contas(numbers);
        System.out.println("--------********--------********--------********--------********--------");


        System.out.println("(11). imprima a data de hoje, somando a quantidade de dias indicadas por cada elemento distinto da lista em ordem crescente");
        numbers.stream().distinct().forEach(num -> System.out.println(LocalDate.now().plusDays(num)));
        System.out.println("--------********--------********--------********--------********--------");
    }

    private static void contas(List<Integer> numbers) {
        System.out.println(numbers.size());
        System.out.println(numbers.stream().reduce(Integer::sum));
        System.out.println(numbers.stream().mapToInt(numbers::get).average());
        System.out.println(numbers.stream().mapToInt(numbers::get).max());
    }

}
