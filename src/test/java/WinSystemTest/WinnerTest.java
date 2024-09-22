package WinSystemTest;

import org.example.WinSystem.Winner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class WinnerTest {
    @Test
    public void playerWonTest1 () {
        char[] gamestate = {
                'O', 'X', 'X',
                'X', 'O', 'X',
                'O', 'X', 'O'
        };
        assertTrue(Winner.playerWon('O',gamestate));
    }
    @Test
    public void playerWonTest2 () {
        char[] gamestate = {
                'X', 'O', 'O',
                'X', 'O', 'X',
                'O', 'O', 'X'
        };
        assertFalse(Winner.playerWon('X',gamestate));
    }
    @Test
    public void playerWonTest3 () {
        char[] gamestate = {
                'X', 'X', 'O',
                'X', 'O', 'X',
                'O', 'O', 'X'
        };
        assertFalse(Winner.playerWon('X',gamestate));
    }
}
