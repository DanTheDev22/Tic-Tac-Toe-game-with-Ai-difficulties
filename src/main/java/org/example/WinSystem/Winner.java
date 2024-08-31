package org.example.WinSystem;

import static org.example.WinSystem.ColumnWin.columnWin;
import static org.example.WinSystem.DiagonalWin.diagonalWin;
import static org.example.WinSystem.RowWin.rowWin;

public class Winner {
    public static boolean playerWon(char ch, char[] game) {
        return rowWin(ch,game) || columnWin(ch, game) || diagonalWin(ch, game);
    }
}
