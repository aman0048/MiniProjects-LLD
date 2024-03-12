package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> matrix;
    /*
    *   dimension = 3
    *   [
    *       [_, _, _]
    *       [_, _, _]
    *       [_, _, _]
    *   ]
    * */

    public Board(int dimension) {
        this.dimension = dimension;
        matrix = new ArrayList<>(); // outside list
        for (int i = 0; i < dimension; i++){
            matrix.add(new ArrayList<>()); // adding the internal list
            for (int j = 0; j < dimension; j++){
                matrix.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard(){
        for (int i = 0; i<dimension; i++){
            List<Cell> cells = matrix.get(i);
            for (Cell cell : cells){
                cell.displayCell();
            }
            System.out.println();
        }
    }
    public List<Cell> getEmptyCells() {
        List<Cell> emptyCells = new ArrayList<>();
        for (List<Cell> row : matrix) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                    emptyCells.add(cell);
                }
            }
        }
        return emptyCells;
    }
    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
