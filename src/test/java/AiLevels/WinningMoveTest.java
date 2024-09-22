package AiLevels;

import org.example.AiLevels.WinningMove;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class WinningMoveTest {
    @Test
    public void winningMoveTest1() {
        char[] game = {
                'X','_','O',
                'O','X','O',
                '_','_','_'
        };
        int move = WinningMove.findWinningMove(game,'X');
        assertEquals(8,move);
    }
}
