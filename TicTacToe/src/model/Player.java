package model;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Player() {
    }

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row for the target cell");
        int row = sc.nextInt();
        System.out.println("Enter the col for the target cell");
        int col = sc.nextInt();
        // In bound check
        if (row < 0 || row >= board.getDimension() || col < 0 || col >= board.getDimension()) {
            throw new ArrayIndexOutOfBoundsException("Placing values outside the dimensions");
        }
        Cell playedMovedCell = board.getMatrix().get(row).get(col);
        // If the cell is already filled
        if (playedMovedCell.getCellState() == CellState.FILLED) {
            return new Move(null, this);
        }
        playedMovedCell.setCellState(CellState.FILLED);
        playedMovedCell.setPlayer(this);
        return new Move(playedMovedCell, this);
    }
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
