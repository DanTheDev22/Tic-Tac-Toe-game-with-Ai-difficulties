package AiLevels;

import org.example.AiLevels.AiMediumLevel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AiMediumLevelTest {
    @Test
    public void aiMediumTest1 () {
        AiMediumLevel ai = new AiMediumLevel ();
        char[] game = {
                'X', 'X', '_',
                'X', 'O', 'X',
                'O', '_', 'X'
        };
        int move = ai.getMove(game,'X');
        assertEquals(2, move);
        assertNotEquals(7, move);
    }

    @Test
    public void aiMediumTest2 () {
        char[] game = {
                'X', 'O', 'X',
                'X', 'X', 'O',
                'O', '_', 'X'
        };
        AiMediumLevel ai = new AiMediumLevel();
        int move = ai.getMove(game,'O');
        assertEquals(7, move);
        assertNotEquals(-1, move);
    }

    @Test
    public void aiMediumTest3 () {
        char[] game = {
                'X', 'O', 'X',
                'X', 'X', 'O',
                'O', 'O', 'X'
        };
        AiMediumLevel ai = new AiMediumLevel();
        int move = ai.getMove(game,'O');
        assertEquals(-1,move);
    }
}
