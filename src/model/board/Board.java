package model.board;

import model.player.Player;
import view.GameView;

public class Board {
    private int size = 3;
    private Cell[][] board;
    private GameView view;
    private int sizeX;
    private int sizeY;

    public Board() {

    }

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.board = initBoard();

    }

    private Cell[][] initBoard() {
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
        return board;
    }

    public Cell[][] getBoard() {
        return board;
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
        board[row][col].setRepresentation(String.valueOf(player.getSymbole()));
    }

    /**
     * Vérifie si le plateau est plein (aucune cellule vide).
     * 
     * @return true si le plateau est plein, false sinon.
     */
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Vérifie les conditions de victoire (lignes, colonnes, diagonales).
     * 
     * @return true si un joueur a gagné, false sinon.
     */
    private boolean checkWin() {
        // Vérifie les lignes et les colonnes
        for (int i = 0; i < size; i++) {
            if (checkLineOrColumn(board[i][0], board[i][1], board[i][2]) ||
                    checkLineOrColumn(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        // Vérifie les diagonales
        if (checkLineOrColumn(board[0][0], board[1][1], board[2][2]) ||
                checkLineOrColumn(board[0][2], board[1][1], board[2][0])) {
            return true;
        }
        return false;
    }

    /**
     * Vérifie si trois cellules contiennent le même symbole non vide pour les
     * conditions de victoire.
     * 
     * @param c1 La première cellule.
     * @param c2 La deuxième cellule.
     * @param c3 La troisième cellule.
     * @return true si les trois cellules contiennent le même symbole, false sinon.
     */
    private boolean checkLineOrColumn(Cell c1, Cell c2, Cell c3) {
        return c1.getRepresentation().equals(c2.getRepresentation()) &&
                c2.getRepresentation().equals(c3.getRepresentation()) &&
                !c1.isEmpty();
    }

}
