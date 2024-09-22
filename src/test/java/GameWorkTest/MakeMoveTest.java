package GameWorkTest;

import org.example.AiLevels.AiLevel;
import org.example.GameWork.MakeMove;
import org.example.PlayerModel.PlayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class MakeMoveTest {
    private AiLevel mockAiLevel;
    private MakeMove makeMove;
    @BeforeEach
    public void setUp() {
        mockAiLevel = mock(AiLevel.class);
        makeMove= new MakeMove(mockAiLevel);
    }
    @Test
    public void testUserMoveValid() {
        char[] game = {
                '_','_','_',
                '_','_','_',
                '_','_','_'
        };
        Scanner scanner = new Scanner("2 2\n");
        makeMove.makeMove(game,'X', PlayerType.USER,scanner);
        assertEquals('X',game[4]);
    }
    @Test
    public void testUserMoveInvalidAndValid1 () {
        char[] game = {
                'X', 'O', 'X',
                'X', 'X', 'O',
                'O', '_', 'X'
        };
        Scanner scanner = new Scanner("3 3\n 3 2\n");
        makeMove.makeMove(game,'O',PlayerType.USER,scanner);
        assertEquals('O',game[7]);
    }
    @Test
    public void testUserMoveInvalidAndValid2 () {
        char[] game = {
                'X', 'O', 'X',
                'X', '_', 'O',
                '_', '_', '_'
        };
        Scanner scanner = new Scanner("4 3\n 3 1\n");
        makeMove.makeMove(game,'O',PlayerType.USER,scanner);
        assertEquals('O',game[6]);
    }
    @Test
    public void TestAiMove () {
        char[] game = {
                '_', '_', '_',
                '_', '_', '_',
                '_', '_', '_'
        };
        when(mockAiLevel.getMove(game,'O')).thenReturn(0);
        makeMove.makeMove(game,'O',PlayerType.EASY,new Scanner(System.in));
        assertEquals('O',game[0]);
    }
}
