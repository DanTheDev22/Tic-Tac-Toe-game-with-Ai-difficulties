package org.example;


import org.example.PlayerModel.PlayerType;

import java.util.*;
import java.util.regex.Pattern;

import static org.example.GameWork.PlayGame.playGame;

public class Main {
    // Pattern to match valid coordinate input
    static final Pattern PATTERN = Pattern.compile("^-?\\d+\\s+-?\\d+$");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Infinite loop to keep taking commands until "exit" is entered
        while (true) {
            System.out.print("Input command: ");
            // it will take only two scenarios: 1) "start *playerType *playerType" or 2) "exit"
            // *playerType can be only : user, easy, medium or hard
            String command = scanner.nextLine().trim();
            String[] commands = command.split("\\s+");

            if (commands.length == 1 && commands[0].equals("exit")) {
                System.exit(0);  // it will finish the application
            } else if ((commands.length == 3 && commands[0].equalsIgnoreCase("start"))) {
                try {
                    PlayerType playerX = PlayerType.valueOf(commands[1].toUpperCase());
                    PlayerType playerO = PlayerType.valueOf(commands[2].toUpperCase());
                    playGame(playerX, playerO);
                } catch (IllegalArgumentException e) {
                    // Handle invalid player types
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }
}