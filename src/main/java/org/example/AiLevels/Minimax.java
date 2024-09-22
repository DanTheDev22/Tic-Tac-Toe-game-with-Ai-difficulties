package org.example.AiLevels;

import static org.example.AiLevels.ScoreSystem.score;
import static org.example.WinSystem.DrawChecking.checkDraw;
import static org.example.WinSystem.Winner.playerWon;

public class Minimax {
    public static int minimax(char[] game, int depth, char currentPlayer, boolean isMaximizingPlayer) {
        if (playerWon('X', game) || playerWon('O', game) || checkDraw(game)) {
            return score(game, depth, currentPlayer);
        }
        char opponent = (currentPlayer == 'X') ? 'O' : 'X';
        if (isMaximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < game.length; i++) {
                if (game[i] == '_') {
                    game[i] = currentPlayer;
                    int eval = minimax(game, depth + 1, currentPlayer, false);
                    game[i] = '_';
                    maxEval = Math.max(maxEval, eval);
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < game.length; i++) {
                if (game[i] == '_') {
                    game[i] = opponent;
                    int eval = minimax(game, depth + 1, currentPlayer, true);
                    game[i] = '_';
                    minEval = Math.min(minEval, eval);
                }
            }
            return minEval;
        }
    }
}
