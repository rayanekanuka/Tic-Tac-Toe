package model.board;

public class Board {
    private int size;
    private Cell[][] board;

    public Board(int size) {
        this.size = size;
        initBoard();
    }

    /**
     * Initialise le plateau de jeu.
     */
    private void initBoard() {
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }
}
