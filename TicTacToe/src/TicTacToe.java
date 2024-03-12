import Controller.GameController;
import model.*;
import service.winningStrategy.WinningFactoryName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);
        boolean replay = true;
        
        while (replay) {
            int id = 1;
            List<Player> playerList = new ArrayList<>();
            System.out.println("----- Welcome to the Tic Tac Toe Game -----");
            System.out.println("Please Enter the dimension of the board");
            int dimension = sc.nextInt();
            System.out.println("Do you want a Bot in the game ? Y or N");
            String botInput = sc.next();
            if (botInput.equalsIgnoreCase("Y")) {
                System.out.println("Choose bot difficulty level:");
                System.out.println("1. Normal");
                System.out.println("2. Random");
                int botDifficultyChoice = sc.nextInt();
                Player bot = new Bot(id++, '$', botDifficultyChoice);
                playerList.add(bot);
            }
            
            while (id < dimension) { // or we can use playerList.size() < dimension
                System.out.println("Please Enter the Player name");
                String playerName = sc.next();
                System.out.println("Please Enter Player symbol");
                char symbol = sc.next().charAt(0);
                Player player = new Player(id++, playerName, symbol, PlayerType.HUMAN);
                playerList.add(player);
            }
            
            Collections.shuffle(playerList);
            Game game = gameController.createGame(dimension, playerList, WinningFactoryName.ORDERONEWINNINGSTRATEGY);
            
            int playerIndex = -1;
            int symbolsPlacedCount = 0;
            while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
                playerIndex++;
                playerIndex = (playerIndex) % playerList.size(); // Increment playerIndex at the start of the loop
                System.out.println("Current Board Status");
                gameController.displayBoard(game);
                Move playedMove = gameController.executeMove(game, playerList.get(playerIndex));
                if (playedMove.getCell() == null) {
                    // Handle the case where the move was unsuccessful (cell already filled)
                    System.out.println("Invalid move! Please try again.");
                    playerIndex--; // Decrement playerIndex to allow the same player to make another move
                } else {
                    symbolsPlacedCount++;
                    game.getMoves().add(playedMove);
                    game.getBoardStates().add(game.getBoard());
                    Player winnerPlayer = gameController.checkWinner(game, playedMove);
                    if (winnerPlayer != null) {
                        if (symbolsPlacedCount == dimension * dimension) {
                            System.out.println("There is No Winner game is drawn");
                            break;
                        }
                        System.out.println("WINNER IS : " + winnerPlayer.getName());
                        break;
                    }
                }
            }
            System.out.println("Final Board Status");
            gameController.displayBoard(game);
            System.out.println("Do you want to replay? (Y/N)");
            String replayInput = sc.next();
            replay = replayInput.equalsIgnoreCase("Y");
        }
        System.out.println("Thanks for playing Tic Tac Toe!");
    }
}
