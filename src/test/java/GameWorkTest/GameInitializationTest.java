package GameWorkTest;

import org.example.GameWork.GameInitialization;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class GameInitializationTest {
    @Test
    public void initGameTest () {
        char[] expected = new char[9];
        for (int i = 0; i <= expected.length - 1 ; i++) {
            expected[i]='_';
        }
        assertArrayEquals(expected,GameInitialization.initGame());
    }
}
