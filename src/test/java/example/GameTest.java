package example;

import org.example.Game;
import org.example.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GameTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void runTetst(String expectedWord, String guess, Response[] expectedResponse){
        var actualResponse = new Game(expectedWord).run(guess);

        System.out.println("Expected word - " + expectedWord);
        System.out.println("Entered word - " + guess);

        Arrays.stream(actualResponse).forEach(System.out::println);
        assertThat(expectedResponse).isEqualTo(actualResponse);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("world", "words", new Response[]{
                        new Response((short) 0, Response.Color.GREEN),
                        new Response((short) 1, Response.Color.GREEN),
                        new Response((short) 2, Response.Color.GREEN),
                        new Response((short) 3, Response.Color.YELLOW),
                        new Response((short) 4, Response.Color.GRAY)
                }),
                Arguments.of("guana", "again", new Response[]{
                        new Response((short) 0, Response.Color.YELLOW),
                        new Response((short) 1, Response.Color.YELLOW),
                        new Response((short) 2, Response.Color.GREEN),
                        new Response((short) 3, Response.Color.GRAY),
                        new Response((short) 4, Response.Color.YELLOW)
                }),
                Arguments.of("bolls", "boots", new Response[]{
                        new Response((short) 0, Response.Color.GREEN),
                        new Response((short) 1, Response.Color.GREEN),
                        new Response((short) 2, Response.Color.GRAY),
                        new Response((short) 3, Response.Color.GRAY),
                        new Response((short) 4, Response.Color.GREEN)
                }),
                Arguments.of("aabbv", "ababa", new Response[]{
                        new Response((short) 0, Response.Color.GREEN),
                        new Response((short) 1, Response.Color.YELLOW),
                        new Response((short) 2, Response.Color.YELLOW),
                        new Response((short) 3, Response.Color.GREEN),
                        new Response((short) 4, Response.Color.GRAY)
                }),
                Arguments.of("train", "gainn", new Response[]{
                        new Response((short) 0, Response.Color.GRAY),
                        new Response((short) 1, Response.Color.YELLOW),
                        new Response((short) 2, Response.Color.YELLOW),
                        new Response((short) 3, Response.Color.GRAY),
                        new Response((short) 4, Response.Color.GREEN)
                }),
                Arguments.of("abcde", "baaae", new Response[]{
                        new Response((short) 0, Response.Color.YELLOW),
                        new Response((short) 1, Response.Color.YELLOW),
                        new Response((short) 2, Response.Color.GRAY),
                        new Response((short) 3, Response.Color.GRAY),
                        new Response((short) 4, Response.Color.GREEN)
                })
        );
    }
}
