package WinSystemTest;

import org.example.WinSystem.RowWin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RowWinTest {
    @Test
    public void rowWinTest1 () {
        char[] gamestate = {
                'X','X','X',
                'O','O','X',
                'O','X','O'
        };
        assertTrue(RowWin.rowWin('X',gamestate));
    }
    @Test
    public void rowWinTest2 () {
        char[] gamestate = {
                'X','O','X',
                'X','O','X',
                'O','X','O'
        };
        assertFalse(RowWin.rowWin('O',gamestate));
    }
}
