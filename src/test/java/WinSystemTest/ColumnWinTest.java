package WinSystemTest;


import org.example.WinSystem.ColumnWin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ColumnWinTest {
    @Test
    public void testColumnWin_firstColumn () {
        char[] gamestate = {
                'X','O','X',
                'X','O',' ',
                'X',' ',' '
        };
        assertTrue(ColumnWin.columnWin('X',gamestate));
    }
    @Test
    public void testColumnWin_secondColumn () {
        char[] gamestate = {
                'X','O','X',
                'X','O',' ',
                ' ','O',' '
        };
        assertTrue(ColumnWin.columnWin('O',gamestate));
    }
    @Test
    public void testColumnWin_thirdColumn () {
        char[] gamestate = {
                'X','O','X',
                'X','O','X',
                'O',' ','X'
        };
        assertTrue(ColumnWin.columnWin('X',gamestate));
    }
    @Test
    public void testColumnWin_noWin () {
        char[] gamestate = {
                'X','O','X',
                'O','O','X',
                'X','X','O'
        };
        assertFalse(ColumnWin.columnWin('O',gamestate));
    }
}
