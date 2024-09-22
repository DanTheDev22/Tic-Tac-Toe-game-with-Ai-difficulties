package org.example.AiLevels;

import static org.example.AiLevels.Minimax.minimax;

public class AiHardLevel implements AiLevel {
    @Override
    public int getMove (char[] game, char currentPlayer) {
    int bestMove = -1;
    int bestValue = Integer.MIN_VALUE;
        for (int i = 0; i < game.length ; i++) {
        if (game[i] == '_') {
            game[i] = currentPlayer;
            int moveValue = minimax(game,0,currentPlayer,false);
            game[i]='_';
            if (moveValue > bestValue) {
                bestMove = i;
                bestValue=moveValue;
            }
        }
    }
        return bestMove;
}
}
