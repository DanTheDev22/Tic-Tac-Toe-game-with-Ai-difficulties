package org.example.AiLevels;

import static org.example.WinSystem.Winner.playerWon;

public class ScoreSystem {
    public static int score (char[] game, int depth, char currentPlayer) {
        char opponent = (currentPlayer == 'X') ? 'O' : 'X';
        if (playerWon(currentPlayer,game)) {
            return 10 - depth;
        } else if (playerWon(opponent,game)) {
            return depth - 10;
        } else {
            return 0;
        }
    }
}
