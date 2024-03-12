package Controller;

import model.*;
import service.winningStrategy.WinningFactoryName;
import service.winningStrategy.WinningStrategyFactory;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> player, WinningFactoryName winningFactoryName){
        return Game.builder()
                .setDimension(dimension)
//                .setBoard(new Board(dimension))
                .setPlayers(player)
                .setWinningStrategy(WinningStrategyFactory.getWinningStrategy(winningFactoryName, dimension))
                .build();
    }

    // For whatever game is going on display the board
    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public GameStatus gameStatus(Game game){
        return game.getGameStatus();
    }

    public Player checkWinner(Game game, Move lastPlayedMove){
        return game.getWinningStrategy().checkWinner(game.getBoard(), lastPlayedMove);
    }

    public Move executeMove(Game game, Player player){
        return player.makeMove(game.getBoard());
    }

    // For the Doraemon approach
    public Board undoMove(Game game, Move lastPlayedMove){
        return null;
    }
}
