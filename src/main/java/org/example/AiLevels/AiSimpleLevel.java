package org.example.AiLevels;

import java.util.Random;

public class AiSimpleLevel implements AiLevel {

    @Override
    public int getMove(char[] game, char currentPlayer) {
        int min = 0;
        int max = 8;
        Random random = new Random();
        int index;

        do {
            index = random.nextInt(max - min + 1) + min;
        } while (game[index] != '_'); // Repeat until an empty cell is found
        return index;
    }
}
