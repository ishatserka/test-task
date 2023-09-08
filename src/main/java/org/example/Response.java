package org.example;

public class Response {
    final short position;
    final Color color;

    public Response(short position, Color color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        if (position != response.position) return false;
        return color == response.color;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Response{" + "position=" + position + ", color=" + color + '}';
    }

    public enum Color {
        GREEN, YELLOW, GRAY
    }
}