package WinSystemTest;

import org.example.WinSystem.DrawChecking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class DrawCheckTest {
    @Test
    public void checkDrawTest () {
        char[] gamestate = {
                'X', 'O', 'X',
                'X', 'X', 'O',
                'O', 'O', 'X'
        };
        assertTrue(DrawChecking.checkDraw(gamestate));
    }
    @Test
    public void checkNotDrawTest() {
        char[] gamestate = {
                'X', 'O', '_',
                'X', 'X', 'O',
                'O', 'O', 'X'
        };
        assertFalse(DrawChecking.checkDraw(gamestate));
    }
}
