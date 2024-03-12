package service.winningStrategy;

import model.Board;
import model.Move;
import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{
    /*
     -> One List<HashMap> for rows, bcoz there are multiple rows in the board and for every row we need a hashmap
     -> One List<HashMap> for Col, bcoz there are multiple cols in the board and for every col we need a hashmap
     -> Onc HashMap for left Diagonal
     -> One HashMap for right diagonal

      */

    private int dimension;
    private List<HashMap<Character, Integer>> rowHashMapList; // every index will be corresponding to one hashmap of that row
    private List<HashMap<Character, Integer>> colHashMapList;
    private HashMap<Character, Integer> leftDiagonal;
    private HashMap<Character, Integer> rightDiagonal;
    private HashMap<Character, Integer> cornerHashMap;

    public OrderOneWinningStrategy(int dimension){
        this.dimension = dimension;
        rowHashMapList = new ArrayList<>();
        colHashMapList = new ArrayList<>();
        leftDiagonal = new HashMap<>();
        rightDiagonal = new HashMap<>();
        cornerHashMap = new HashMap<>();
        for(int i = 0; i<dimension; i++){
            rowHashMapList.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        //winnerCheckForCorners(board, symbol) -> earlier we are using this method, but it is giving nullpointer
        // as all the dimensions are not yet available
        boolean checkWinner = (checkCorners(row, col) && checkAndUpdateForWinnerInCorner(board, symbol))
                                || commonHashMapCode(rowHashMapList.get(row), symbol)
                                || commonHashMapCode(colHashMapList.get(col), symbol)
                                || (checkLeftDiagonal(row, col) && commonHashMapCode(leftDiagonal, symbol))
                                || (checkRightDiagonal(row, col) && commonHashMapCode(rightDiagonal, symbol)
                            );

        if (checkWinner){
            return player;
        }else{
            return null;
        }
    }

    private boolean checkAndUpdateForWinnerInCorner(Board board, char symbol){
        for(int i = 0; i<dimension; i++){
            if(cornerHashMap.containsKey(symbol)){
                cornerHashMap.put(symbol, cornerHashMap.get(symbol) + 1);
                return cornerHashMap.get(symbol) == 4;
            }
            else {
                cornerHashMap.put(symbol, 1);
            }
        }
        return false;
    }

    public boolean checkCorners(int row, int col){
        return (row == 0 && col == 0)
                || (row == 0 && col == dimension - 1)
                || (row == dimension - 1 && col == 0)
                || (row == dimension - 1 && col == dimension - 1);
    }
    private boolean commonHashMapCode(HashMap<Character, Integer> commonHashMap, char symbol){
            if(commonHashMap.containsKey(symbol)){
                commonHashMap.put(symbol, commonHashMap.get(symbol) + 1);
                return commonHashMap.get(symbol) == dimension;
            }
            else {
                commonHashMap.put(symbol, 1);
            }
        return false;
    }

    private boolean checkLeftDiagonal(int row, int col){
        return row == col;
    }

    private boolean checkRightDiagonal(int row, int col){
        return ((row + col) == (dimension - 1));
    }
}
