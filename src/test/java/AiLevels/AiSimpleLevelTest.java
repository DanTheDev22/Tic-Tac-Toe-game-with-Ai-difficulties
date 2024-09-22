package AiLevels;

import org.example.AiLevels.AiSimpleLevel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AiSimpleLevelTest {
    @Test
    public void aiSimpleTest1 () {
        char[] game = {
                '_', '_', '_',
                '_', '_', '_',
                '_', '_', '_'
        };
        AiSimpleLevel ai = new AiSimpleLevel();
        int move = ai.getMove(game, 'X');
        assertTrue(move >= 0 && move <= 8);
    }
    @Test
    public void aiSimpleTest2 () {
        char[] game = {
                'X', 'O', 'X',
                'X', 'X', 'O',
                'O', 'O', 'X'
        };
        AiSimpleLevel ai = new AiSimpleLevel();
        int move = ai.getMove(game,'O');
        assertEquals(-1,move);
    }
}
