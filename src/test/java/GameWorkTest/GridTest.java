package GameWorkTest;

import org.example.GameWork.Grid;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class GridTest {
    @Test
    public void gridTest () {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        char[] gamestate = {
                'X','_','X',
                '_','O','_',
                'X','O','_'
        };
        Grid.printGrid(gamestate);
        System.setOut(System.out);
        String expectedOutput =
                """
                        ---------
                        | X _ X |
                        | _ O _ |
                        | X O _ |
                        ---------
                        """;
        String actualOutput = outputStream.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput,actualOutput);
    }
}
