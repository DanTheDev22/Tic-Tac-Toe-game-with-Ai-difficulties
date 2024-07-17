package org.example;


import java.util.*;
import java.util.regex.Pattern;

public class Main {
    // Pattern to match valid coordinate input
    private static final Pattern PATTERN = Pattern.compile("^-?\\d+\\s+-?\\d+$");
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

    // Method to play the game with the given player types
    public static void playGame (PlayerType playerX, PlayerType playerO) {
        Scanner scanner = new Scanner(System.in);
        char[] game = initGame(); // the game is initializing
        printGrid(game);
        char currentPlayer = 'X'; // X always starts

        // Map to store the player type for 'X' and 'O'
        Map<Character, PlayerType> players = new HashMap<>();
        players.put('X', playerX);
        players.put('O', playerO);

        while (true) {
            makeMove (game, currentPlayer, players.get(currentPlayer), scanner); // calling the method for playerTypes
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

    // Method to handle moves based on player type
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

    // Enumeration for Player types
    public enum PlayerType {
        USER,
        EASY,
        MEDIUM,
        HARD
    }

    // Validate input format
    public static boolean inputIsValid (String input) {
        return PATTERN.matcher(input).find();
    }

    // Initialize the game grid with empty spaces
    public static char[] initGame() {
        char[] game = new char[9];
        Arrays.fill(game, '_');
        return game;
    }

    // Method for printing the 3x3 grid game
    public static void printGrid(char[] game) {

        System.out.println("---------");
        System.out.println("| " + game[0] + " " + game[1] + " " + game[2] + " |");
        System.out.println("| " + game[3] + " " + game[4] + " " + game[5] + " |");
        System.out.println("| " + game[6] + " " + game[7] + " " + game[8] + " |");
        System.out.println("---------");
    }

    // Parse and validate user move input
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

    // Check if a player has won the game
    public static boolean playerWon(char ch, char[] game) {
        return rowWin(ch,game) || columnWin(ch, game) || diagonalWin(ch, game);
    }

    // Check for a row win
    public static boolean rowWin(char character, char[] gamestate) {
        return gamestate[0] == character && gamestate[1] == character && gamestate[2] == character  ||
                gamestate[3] == character && gamestate[4] == character && gamestate[5] == character ||
                gamestate[6] == character && gamestate[7] == character && gamestate[8] == character;
    }

    // Check for a column win
    public static boolean columnWin(char character, char[] gamestate) {
        return gamestate[0] == character && gamestate[3] == character && gamestate[6] == character  ||
                gamestate[1] == character && gamestate[4] == character && gamestate[7] == character ||
                gamestate[2] == character && gamestate[5] == character && gamestate[8] == character;
    }

    // Check for a diagonal win
    public static boolean diagonalWin(char character, char[] gamestate) {
        return gamestate[0] == character && gamestate[4] == character && gamestate[8] == character ||
                gamestate[2] == character && gamestate[4] == character && gamestate[6] == character;
    }

    // Check for a draw
    public static boolean checkDraw(char[] gamestate) {
        for (char elements : gamestate) {
            if (elements =='_') {
                return false;
            }
        }
        return true;
    }

    // AI Easy Level: Random move
    public static int AiSimple(char[] game) {
        int min = 0;
        int max = 8;
        Random random = new Random();
        int index;

        do {
            index = random.nextInt(max - min + 1) + min;
        } while (game[index] != '_'); // Repeat until an empty cell is found
        return index;
    }

    // AI Medium Level: Win if possible, otherwise block opponent, else random move
    public static int AiMedium(char[] game, char currentPlayer) {
        char opponent = (currentPlayer == 'X') ? 'O' : 'X';

        int winningMove = findWinningMove(game,currentPlayer);
        if (winningMove != -1) {
            return winningMove;
        }

        int blockingMove = findWinningMove(game,opponent);
        if (blockingMove != -1) {
            return blockingMove;
        }

        return AiSimple(game);
    }

    // Find a winning move for the given player
    public static int findWinningMove (char[] game, char currentPlayer) {

        for (int i = 0; i < game.length ; i++) {
            if (game[i] == '_') {
                game[i] =  currentPlayer;
                if (playerWon(currentPlayer,game)) {
                    game[i] = '_';
                    return i;
                }
                game[i]='_';
            }

        }
        return -1;
    }

    // Method for the evaluation purpose of the Minimax algorithm
    public static int score (char[] game, int depth, char currentPlayer) {
        char opponent = (currentPlayer == 'X') ? 'O' : 'X';

        if (playerWon(currentPlayer,game)) {
            return 10 - depth;
        } else if (playerWon(opponent,game)) {
            return depth - 10;
        } else {
            return 0;
        }
    }

    // Method for Minimax Algorithm. Its using score method for the evaluation purpose
    public static int minimax (char[] game, int depth, char currentPlayer, boolean isMaximizingPlayer) {
        if (playerWon('X', game) || playerWon('O', game) || checkDraw(game)) {
            return score(game, depth, currentPlayer);
        }

        char opponent = (currentPlayer == 'X') ? 'O' : 'X';

        if (isMaximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < game.length; i++) {
                if (game[i] == '_') {
                    game[i] = currentPlayer;
                    int eval = minimax(game, depth + 1, currentPlayer, false);
                    game[i] = '_';
                    maxEval = Math.max(maxEval, eval);
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < game.length; i++) {
                if (game[i] == '_') {
                    game[i] = opponent;
                    int eval = minimax(game, depth + 1, currentPlayer, true);
                    game[i] = '_';
                    minEval = Math.min(minEval, eval);
                }
            }
            return minEval;
        }
    }

    // AI Hard Level: Use minimax algorithm to find the best move
    public static int AiHard (char[] game, char currentPlayer) {
        int bestMove = -1;
        int bestValue = Integer.MIN_VALUE;

        for (int i = 0; i < game.length ; i++) {
            if (game[i] == '_') {
                game[i] = currentPlayer;
                int moveValue = minimax(game,0,currentPlayer,false);
                game[i]='_';
                if (moveValue > bestValue) {
                    bestMove = i;
                    bestValue=moveValue;
                }
            }
        }
        return bestMove;
    }
}