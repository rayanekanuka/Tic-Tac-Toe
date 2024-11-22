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
        return board[row][col].getState() != State.EMPTY;
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
                if (board[i][j].getState() == State.EMPTY) {
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
    public boolean checkWin() {
        return checkLines() || checkColumns() || checkDiagonals();
    }

    /**
     * Vérifie les lignes pour voir si un joueur a gagné.
     * 
     * @return true si une ligne satisfait la condition de victoire.
     */
    private boolean checkLines() {
        for (int i = 0; i < sizeX; i++) {
            if (checkLineCells(board[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vérifie les colonnes pour voir si un joueur a gagné.
     * 
     * @return true si une colonne satisfait la condition de victoire.
     */
    private boolean checkColumns() {
        for (int j = 0; j < sizeY; j++) {
            Cell[] column = new Cell[sizeX];
            for (int i = 0; i < sizeX; i++) {
                column[i] = board[i][j];
            }
            if (checkLineCells(column)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vérifie les diagonales pour voir si un joueur a gagné.
     * 
     * @return true si une diagonale satisfait la condition de victoire.
     */
    private boolean checkDiagonals() {
        // Diagonale principale
        Cell[] mainDiagonal = new Cell[sizeX];
        for (int i = 0; i < sizeX; i++) {
            mainDiagonal[i] = board[i][i];
        }
        if (checkLineCells(mainDiagonal)) {
            return true;
        }

        // Diagonale secondaire
        Cell[] secondaryDiagonal = new Cell[sizeX];
        for (int i = 0; i < sizeX; i++) {
            secondaryDiagonal[i] = board[i][sizeY - i - 1];
        }
        return checkLineCells(secondaryDiagonal);
    }

    /**
     * Vérifie si toutes les cellules d'une ligne ou colonne contiennent le même
     * symbole.
     * 
     * @param cells Les cellules à vérifier.
     * @return true si toutes les cellules contiennent le même symbole (et ne sont
     *         pas vides).
     */
    private boolean checkLineCells(Cell[] cells) {
        if (cells[0].getState() == State.EMPTY) {
            return false;
        }
        for (int i = 1; i < cells.length; i++) {
            if (cells[i].getState() != cells[0].getState()) {
                return false;
            }
        }
        return true;
    }

}
