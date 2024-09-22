package AiLevels;

import org.example.AiLevels.Minimax;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MinimaxTest {
    @Test
    public void minimaxTestWinScenario () {
        char[] game = {
                'X','O','X',
                'O','X','_',
                '_','_','_'
        };
        int result = Minimax.minimax(game,0,'X',true);
        assertEquals(9,result);
    }
    @Test
    public void minimaxTestLossScenario () {
        char[] game = {
                'X','O','X',
                'O','X','_',
                '_','_','X'
        };
        int result = Minimax.minimax(game,0,'O',true);
        assertEquals(-10,result);
    }
    @Test
    public void minimaxTestDrawScenario () {
        char[] game = {
                'X','O','X',
                'X','O','X',
                'O','X','O'
        };
        int result = Minimax.minimax(game,0,'X',true);
        assertEquals(0,result);
    }
}
