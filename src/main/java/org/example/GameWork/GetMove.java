package org.example.GameWork;

import java.util.NoSuchElementException;

import static org.example.InputIsValid.inputIsValid;

public class GetMove {
    public static int getMove (String input, char[] game) {
        if(!inputIsValid(input)) {
            System.out.println("You should enter numbers!");
            return -1;
        }
        String[] in = input.split("\\s+");
        if (in.length != 2) {
            System.out.println("You should enter two numbers separated by a space!");
            return -1;
        }
        int index;
        try {
            int i = Integer.parseInt(in[0]);
            int j = Integer.parseInt(in[1]);
            if ((i > 3 || i < 1) || (j > 3 || j < 1)) {
                System.out.println("Coordinates should be from 1 to 3!");
                return -1;
            }
            index = (i - 1) * 3 + (j - 1);
            if (game[index] == 'X' || game[index] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return -1;
        } catch (NoSuchElementException d) {
            return -1;
        }
        return index;
    }
}
