package org.example.WinSystem;

public class DrawChecking {
    public static boolean checkDraw(char[] gamestate) {
        for (char elements : gamestate) {
            if (elements =='_') {
                return false;
            }
        }
        return true;
    }

}
