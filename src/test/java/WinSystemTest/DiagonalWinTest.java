package WinSystemTest;

import org.example.WinSystem.DiagonalWin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiagonalWinTest {
    @Test
    public void diagonalWinTest() {
        char[] gamestate = {
                'X', 'O', 'O',
                'O', 'X', 'O',
                'X', 'O', 'X'
        };
        assertTrue(DiagonalWin.diagonalWin('X',gamestate));
    }
    @Test
    public void noDiagonalWinTest() {
        char[] gamestate = {
                'O', 'O', 'X',
                'X', 'X', 'O',
                'O', 'X', 'O'
        };
        assertFalse(DiagonalWin.diagonalWin('X', gamestate));
    }
}
