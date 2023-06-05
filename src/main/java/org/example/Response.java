package org.example;

public class Response {
    private final short position;
    private final Color color;

    public Response(short position, Color color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Response{" + "position=" + position + ", color=" + color + '}';
    }

    public enum Color {
        GREEN, YELLOW, GRAY
    }
}