package org.example;

import static org.example.Main.PATTERN;

public class InputIsValid {
    public static boolean inputIsValid (String input) {
        return PATTERN.matcher(input).find();
    }
}
