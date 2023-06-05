package org.example;

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

        return response;
    }

    private void validateLength(String words) {
        if (words == null || words.length() != LENGTH) {
            throw new RuntimeException("The word should contain only " + LENGTH + " chars");
        }
    }
}