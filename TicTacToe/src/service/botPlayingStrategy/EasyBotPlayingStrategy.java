package service.botPlayingStrategy;

import exception.GameOverException;
import model.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board, Player bot) {
        int dimension = board.getDimension();
        List<List<Cell>> matrix = board.getMatrix();

        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                Cell cell = matrix.get(i).get(j);
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    cell.setCellState(CellState.FILLED);
                    cell.setPlayer(bot);
                    return new Move(cell, bot);
                }
            }
        }
        throw new GameOverException("There are no empty cells in the board");
    }
}
