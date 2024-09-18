package org.example.GameWork;
import org.example.AiLevels.AiHardLevel;
import org.example.AiLevels.AiLevel;
import org.example.AiLevels.AiMediumLevel;
import org.example.AiLevels.AiSimpleLevel;
import org.example.PlayerModel.PlayerType;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.GameWork.GameInitialization.initGame;
import static org.example.GameWork.Grid.printGrid;
import static org.example.WinSystem.DrawChecking.checkDraw;
import static org.example.WinSystem.Winner.playerWon;

public class PlayGame {
    public static void playGame (PlayerType playerX, PlayerType playerO) {
        Scanner scanner = new Scanner(System.in);
        char[] game = initGame(); // the game is initializing
        printGrid(game);
        char currentPlayer = 'X'; // X always starts

        // Map to store the player type for 'X' and 'O'
        Map<PlayerType, AiLevel> aiLevels = new HashMap<>();
        aiLevels.put(PlayerType.EASY,new AiSimpleLevel());
        aiLevels.put(PlayerType.MEDIUM,new AiMediumLevel());
        aiLevels.put(PlayerType.HARD,new AiHardLevel());

        while (true) {
            PlayerType currentPlayerType = (currentPlayer == 'X') ? playerX : playerO;
            AiLevel aiLevel = aiLevels.get(currentPlayer);
            MakeMove makeMove = new MakeMove(aiLevel);
            makeMove.makeMove (game, currentPlayer, currentPlayerType, scanner); // calling the method for playerTypes
            // if its user, then it will require coordinates , if its Ai, it will return a move
            printGrid(game);

            // Check for a winner or a draw
            if (playerWon('X',game)) {
                System.out.println("X wins");
                break;
            } else if (playerWon('O',game)) {
                System.out.println("O wins");
                break;
            } else if (checkDraw(game)) {
                System.out.println("Draw");
                break;
            }
            // Switch player
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }

    }
}
