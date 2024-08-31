package org.example.WinSystem;

public class DiagonalWin {
    public static boolean diagonalWin(char character, char[] gamestate) {
        return gamestate[0] == character && gamestate[4] == character && gamestate[8] == character ||
                gamestate[2] == character && gamestate[4] == character && gamestate[6] == character;
    }
}
