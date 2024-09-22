package GameWorkTest;

import org.example.GameWork.GetMove;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class GetMoveTest {
    @Test
    public void testInvalidInputCharacters() {
        char[] game = {
                '_', '_', '_',
                '_', '_', '_',
                '_', '_', '_'
        };
        int result = GetMove.getMove("a b", game);
        assertEquals(-1, result);
    }
        @Test
        public void testInvalidInputTooFewNumbers() {
            char[] game = {
                    '_', '_', '_',
                    '_', '_', '_',
                    '_', '_', '_'
            };
            int result = GetMove.getMove("A",game);
            assertEquals(-1,result);
    }
    @Test
    public void testInvalidInputTooManyNumbers () {
        char[] game = {
                '_', '_', '_',
                '_', '_', '_',
                '_', '_', '_'
        };
        int result = GetMove.getMove("A B C D",game);
        assertEquals(-1,result);
    }
    @Test
    public void testValidInput () {
        char[] game = {
                'X', 'O', 'X',
                '_', '_', '_',
                '_', '_', '_'
        };
        int result = GetMove.getMove("2 1",game);
        assertEquals(3,result);
    }
    @Test
    public void testValidInputEdgeCase () {
        char[] game = {
                'X', 'O', 'X',
                '_', 'O', 'X',
                '_', '_', '_'
        };
        int result = GetMove.getMove("3 3",game);
        assertEquals(8,result);
    }
    @Test
    public void testInvalidOutOfBounds() {
        char[] game = {
                'X', 'O', 'X',
                '_', '_', '_',
                '_', '_', '_'
        };
        int result = GetMove.getMove("4 1",game);
        assertEquals(-1,result);
    }
    @Test
    public void testInvalidOccupiedCell () {
        char[] game = {
                'X', 'O', 'X',
                '_', '_', '_',
                '_', '_', '_'
        };
        int result = GetMove.getMove("1 1",game);
        assertEquals(-1,result);
    }
}
