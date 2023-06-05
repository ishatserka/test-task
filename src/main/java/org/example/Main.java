package org.example;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        String expectedWord = "words";
        String guess = "works";

        var response = new Game(expectedWord).run(guess);

        System.out.println("Expected word - " + expectedWord);
        System.out.println("Entered word - " + guess);

        Arrays.stream(response).forEach(System.out::println);
    }
}