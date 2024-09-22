package org.example.WinSystem;

public class ColumnWin {
    public static boolean columnWin(char character, char[] gamestate) {
        return gamestate[0] == character && gamestate[3] == character && gamestate[6] == character  ||
                gamestate[1] == character && gamestate[4] == character && gamestate[7] == character ||
                gamestate[2] == character && gamestate[5] == character && gamestate[8] == character;
    }
}
