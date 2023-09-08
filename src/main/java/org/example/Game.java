package org.example;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final String words;

    public static final short LENGTH = 5;

    public Game(String words) {
        validateLength(words);
        this.words = words;
    }

    public Response[] run(String guess) {
        Response[] response = new Response[LENGTH];

        //code here

        // count chars of expected
        Map<Character, Integer> countCharsOfExpected = new HashMap<>();
        for(short i = 0; i< LENGTH; i++){
            Character letter = words.charAt(i);
            if (countCharsOfExpected.putIfAbsent(letter, 1) != null) {
                countCharsOfExpected.compute(letter, (k, v) -> v + 1);
            }
        }

        // count chars of guess
        Map<Character, Integer> countCharsOfGuess = new HashMap<>();
        for(short i = 0; i< LENGTH; i++){
            Character letter = guess.charAt(i);
            if (countCharsOfGuess.putIfAbsent(letter, 1) != null) {
                countCharsOfGuess.compute(letter, (k, v) -> v + 1);
            }
        }

        for(short i=0; i<LENGTH; i++){
            char letter = guess.charAt(i);
            if (letter == words.charAt(i)) {
                response[i] = new Response(i, Response.Color.GREEN);
                //exclude letter from countCharsOfExpected and countCharsOfGuess as they are matched
                countCharsOfExpected.compute(letter, (k, v) -> v - 1);
                countCharsOfGuess.compute(letter, (k, v) -> v - 1);
            } else if(!words.contains(String.valueOf(letter))){
                response[i] = new Response(i, Response.Color.GRAY);
            }
        }

        for(short i=0; i<LENGTH; i++){
            if (response[i] != null) {
                continue;
            }
            Character letter = Character.valueOf(guess.charAt(i));
            // if count of letter in guess == count of letter in expected => YELLOW
            if(countCharsOfGuess.get(letter) == countCharsOfExpected.get(letter)){
                response[i] = new Response(i, Response.Color.YELLOW);
            }
            // if count of letter in guess > count of letter in expected and expected contains enough needed letters => YELLOW and decrease count of letter in expected
            else if(countCharsOfGuess.get(letter) > countCharsOfExpected.get(letter) && countCharsOfExpected.get(letter) > 0){
                response[i] = new Response(i, Response.Color.YELLOW);
                countCharsOfExpected.compute(letter, (k, v) -> v - 1);
            }
            // if count of letter in guess < count of letter in expected or expected doesn't contain enough needed letters => GRAY
            else {
                response[i] = new Response(i, Response.Color.GRAY);
            }
        }

        return response;
    }

    private void validateLength(String words) {
        if (words == null || words.length() != LENGTH) {
            throw new RuntimeException("The word should contain only " + LENGTH + " chars");
        }
    }
}