package service.botPlayingStrategy;

import exception.GameOverException;
import model.*;

import java.util.List;
import java.util.Random;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board, Player bot){
        List<List<Cell>> matrix = board.getMatrix();
        Random random = new Random();

        // Create a list to store empty cells
        List<Cell> emptyCells = board.getEmptyCells();

        // If there are no empty cells, return null
        if (emptyCells.isEmpty()) {
            System.out.println("The board is full. Cannot make a move.");
            return null;
        }
        // Select a random empty cell and make a move
        Cell randomCell = emptyCells.get(random.nextInt(emptyCells.size()));
        randomCell.setCellState(CellState.FILLED);
        randomCell.setPlayer(bot);
        return new Move(randomCell, bot);
    }
}
