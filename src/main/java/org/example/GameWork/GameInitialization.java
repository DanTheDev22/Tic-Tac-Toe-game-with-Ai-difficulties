package org.example.GameWork;

import java.util.Arrays;

public class GameInitialization {
    public static char[] initGame() {
        char[] game = new char[9];
        Arrays.fill(game, '_');
        return game;
    }
}
