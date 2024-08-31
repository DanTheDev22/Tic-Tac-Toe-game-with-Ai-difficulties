package org.example.AiLevels;

import static org.example.AiLevels.AiSimpleLevel.AiSimple;
import static org.example.AiLevels.WinningMove.findWinningMove;

public class AiMediumLevel {
    public static int AiMedium(char[] game, char currentPlayer) {
        char opponent = (currentPlayer == 'X') ? 'O' : 'X';

        int winningMove = findWinningMove(game,currentPlayer);
        if (winningMove != -1) {
            return winningMove;
        }

        int blockingMove = findWinningMove(game,opponent);
        if (blockingMove != -1) {
            return blockingMove;
        }

        return AiSimple(game);
    }

}
