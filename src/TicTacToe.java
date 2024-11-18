public class TicTacToe {
    private int size = 3;
    private Cell[][] board;

    public TicTacToe() {
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("|"); // Début de ligne
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getRepresentation() + " |");
            }
            System.out.println(""); // Nouvelle ligne après une rangée
            if (i < size - 1) {
                System.out.println("----------"); // Séparateurs horizontaux
            }
        }
    }

}