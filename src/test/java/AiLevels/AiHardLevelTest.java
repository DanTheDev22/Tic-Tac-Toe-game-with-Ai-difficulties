package AiLevels;

import org.example.AiLevels.AiHardLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AiHardLevelTest {
    @Test
    public void aiHardTest1() {
        char[] game = {
                'X', '_', 'O',
                '_', '_', 'O',
                'X', '_', '_',
        };
        AiHardLevel ai = new AiHardLevel();
        int move = ai.getMove(game, 'X');
        assertEquals(3, move);
        assertNotEquals(8, move);
    }
    @Test
    public void aiHardTest2() {
        char[] game = {
                'O', '_', '_',
                '_', 'X', 'X',
                '_', '_', '_'
        };
        AiHardLevel ai = new AiHardLevel();
        int move = ai.getMove(game, 'O');
        assertEquals(3, move);
    }
    @Test
    void testGetMoveForFullBoard() {
        AiHardLevel aiHardLevel = new AiHardLevel();
        char[] game = new char[]{'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X'};
        char currentPlayer = 'X';
        int move = aiHardLevel.getMove(game, currentPlayer);
        assertEquals(-1, move);
    }
}
