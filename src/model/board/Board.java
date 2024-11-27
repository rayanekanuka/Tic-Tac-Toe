package model.board;

import model.player.Player;

public class Board {
    private int sizeX;
    private int sizeY;
    private Cell[][] board;

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.board = initBoard();
    }

    /**
     * Initialise le plateau de jeu avec des cellules vides.
     * 
     * @return Le plateau de cellules initialisé.
     */
    public Cell[][] initBoard() {
        board = new Cell[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                board[i][j] = new Cell();
            }
        }
        return board;
    }

    /**
     * Retourne le plateau de jeu.
     * 
     * @return Le plateau des cellules
     */
    public Cell[][] getBoard() {
        return board;
    }

    public boolean isCellEmpty(int row, int col) {
        if (row < 0 || row >= sizeX || col < 0 || col >= sizeY) {
            throw new IndexOutOfBoundsException("Coordonnées invalides");
        }
        return board[row][col].getState() != CellState.EMPTY;
    }

    /**
     * Attribue une cellule à un joueur.
     * 
     * @param row    La ligne de la cellule.
     * @param col    La colonne de la cellule.
     * @param player Le joueur à qui attribuer la cellule.
     */
    public void setOwner(int row, int col, Player player) {
        // Attribue le symbole du joueur à la cellule
        board[row][col].setState(player.getState());
    }

    /**
     * Vérifie si le plateau est plein (aucune cellule vide).
     * 
     * @return true si le plateau est plein, false sinon.
     */
    public boolean isBoardFull() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (board[i][j].getState() == CellState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Vérifie les conditions de victoire (lignes, colonnes, diagonales).
     * 
     * @param winCondition Le nombre de cellules identiques nécessaires pour gagner.
     * @param currentState L'état actuel du joueur.
     * @return true si un joueur a gagné, false sinon.
     */
    public boolean checkWin(int winCondition, CellState currentState) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (checkDirection(i, j, 0, 1, currentState, winCondition) // Horizontal
                        || checkDirection(i, j, 1, 0, currentState, winCondition) // Vertical
                        || checkDirection(i, j, 1, 1, currentState, winCondition) // Diagonale descendante
                        || checkDirection(i, j, 1, -1, currentState, winCondition)) { // Diagonale ascendante
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int i, int j, int u, int v, CellState currentState, int winCondition) {
        for (int k = 0; k < winCondition; k++) {
            if (!exist(i + u * k, j + v * k)) {
                return false;
            }
            if (board[i + u * k][j + v * k].getState() != currentState) {
                return false;
            }
        }
        return true;
    }

    private boolean exist(int i, int j) {
        return i >= 0 && i < sizeX && j >= 0 && j < sizeY;
    }

    public boolean placeStone(int col, CellState state) {
        for (int row = sizeX - 1; row >= 0; row--) {
            if (board[row][col].getState() == CellState.EMPTY) {
                board[row][col].setState(state);
                return true;
            }
        }
        return false; // La colonne est pleine
    }
}
