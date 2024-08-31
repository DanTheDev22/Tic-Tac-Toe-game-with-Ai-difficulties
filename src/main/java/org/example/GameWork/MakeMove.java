package org.example.GameWork;

import org.example.Main;
import org.example.PlayerModel.PlayerType;

import java.util.Scanner;

import static org.example.AiLevels.AiHardLevel.AiHard;
import static org.example.AiLevels.AiMediumLevel.AiMedium;
import static org.example.AiLevels.AiSimpleLevel.AiSimple;
import static org.example.GameWork.GetMove.getMove;

public class MakeMove {

    public static void makeMove(char[] game, char player, PlayerType playerType, Scanner scanner) {
        // Easy AI Level
        if (playerType == PlayerType.EASY) {
            System.out.println("Making move level easy");
            int indexAI = AiSimple(game);
            game[indexAI] = player;
        }  // Medium AI Level
        else if (playerType == PlayerType.MEDIUM) {
            System.out.println("Making move level medium");
            int indexAI = AiMedium(game,player);
            game[indexAI] = player;
        }  // Hard AI Level
        else if (playerType == PlayerType.HARD) {
            System.out.println("Making move level hard");
            int indexAI = AiHard(game, player);
            game[indexAI] = player;
        } // User
        else if (playerType == PlayerType.USER) {
            boolean validMove = false;
            while (!validMove) {
                System.out.print("Enter the coordinates: ");
                String input = scanner.nextLine().trim();
                int index = getMove(input, game);
                if (index != -1) {
                    game[index] = player;
                    validMove=true;
                }
            }
        }
    }
}
