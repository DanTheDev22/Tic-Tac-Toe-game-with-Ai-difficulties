package org.example.AiLevels;

import static org.example.WinSystem.Winner.playerWon;

public class WinningMove {
    public static int findWinningMove (char[] game, char currentPlayer) {

        for (int i = 0; i < game.length ; i++) {
            if (game[i] == '_') {
                game[i] =  currentPlayer;
                if (playerWon(currentPlayer,game)) {
                    game[i] = '_';
                    return i;
                }
                game[i]='_';
            }

        }
        return -1;
    }
}
