package org.example.AiLevels;

import static org.example.AiLevels.WinningMove.findWinningMove;

public class AiMediumLevel implements AiLevel {


    @Override
    public int getMove(char[] game, char currentPlayer) {
        AiSimpleLevel aiSimpleLevel = new AiSimpleLevel();
        char opponent = (currentPlayer == 'X') ? 'O' : 'X';

        int winningMove = findWinningMove(game,currentPlayer);
        if (winningMove != -1) {
            return winningMove;
        }

        int blockingMove = findWinningMove(game,opponent);
        if (blockingMove != -1) {
            return blockingMove;
        }

        return aiSimpleLevel.getMove(game,currentPlayer);
    }

}
