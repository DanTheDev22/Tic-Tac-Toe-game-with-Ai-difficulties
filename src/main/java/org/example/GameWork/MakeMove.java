package org.example.GameWork;

import org.example.AiLevels.AiLevel;
import org.example.PlayerModel.PlayerType;
import java.util.Scanner;
import static org.example.GameWork.GetMove.getMove;

public class MakeMove {
    private final AiLevel aiLevel;
    public MakeMove(AiLevel aiLevel) {
        this.aiLevel=aiLevel;
    }
    public void makeMove(char[] game, char player, PlayerType playerType, Scanner scanner) {
        if (playerType == PlayerType.USER) {
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
        } else {
            int indexAI = aiLevel.getMove(game,player);
            game[indexAI]=player;
            System.out.println("Making move level " + playerType.name().toLowerCase());
        }
    }
}
