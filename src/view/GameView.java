package view;

import java.util.Scanner;

import model.board.Cell;
import model.board.Board;

public class GameView {
    private Scanner scanner = new Scanner(System.in);
    protected int sizeX;
    protected int sizeY;
    private Board board;

    public GameView() {
        this.scanner = new Scanner(System.in);
        this.board = new Board(sizeX, sizeY);
    }

    public void decoration(String decoration) {
        System.out.println(decoration);
    }

    public void displayBoard(Cell[][] board) {
        int rows = board.length;  
        int columns = board[0].length;
    
        // Génère et affiche les en-têtes de colonnes dynamiquement
        System.out.print("     ");  // Espace de début pour l'alignement
        for (int i = 0; i < columns; i++) {
            System.out.printf("%-5d", i + 1);  // Ajuste l'espacement pour l'alignement des colonnes
        }
        System.out.println();
    
        // Bordure supérieure du plateau
        System.out.print("  ");
        for (int i = 0; i < columns; i++) {
            System.out.print("-----");  // Ajuste les tirets pour la bordure
        }
        System.out.println();
    
        // Affiche les lignes avec les numéros de lignes
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " |");  // Affiche le numéro de la ligne
            for (Cell cell : board[i]) {
                System.out.printf("%-4s|", cell.getRepresentation());  // Affiche le contenu de la cellule avec un espacement approprié
            }
            System.out.println(); 
    
            // Affiche le séparateur de ligne
            System.out.print("  ");
            for (int j = 0; j < columns; j++) {
                System.out.print("-----");  // Ajuste les tirets pour séparer les lignes
            }
            System.out.println();
        }
    }

    /**
     * Demande au joueur de saisir un coup.
     * 
     * @return Un tableau contenant les coordonnées du coup (ligne et colonne).
     */
    public int[] makeMove(String playerName, String playerSymbole, int sizeX, int sizeY) {
        int row = -1, col = -1;

        while (true) {
            try {
                displayPlayerMove(playerName, playerSymbole);
                row = scanner.nextInt() - 1; // Décrémente pour obtenir des indices à partir de 0
                col = scanner.nextInt() - 1;

                if (row < 0 || row >= sizeX || col < 0 || col >= sizeY) {
                    displayInvalidCoordinates();
                } else if (board.isCellEmpty(row, col)) {
                    displayOccupiedCell();
                } else {
                    break;
                }
            } catch (Exception e) {
                displayInvalidInput();
                scanner.nextLine();
            }
        }
        return new int[] { row, col };
    }

    // Affiche le message de début de partie
    public void displayPlayerMove(String playerName, String playerSymbole) {
        System.out.print(" (" + playerName + "), entrez votre coup (ligne et colonne avec un espace) : ");
    }

    // Messages d'erreur entrée utilisateur
    public void displayInvalidCoordinates() {
        displayMessage("Erreur : coordonnées en dehors du plateau. Réessayez =)");
    }

    public void displayOccupiedCell() {
        displayMessage("Erreur : case déjà occupée. Choisissez une autre case =)");
    }

    public void displayInvalidInput() {
        displayMessage("Erreur : saisie invalide. Veuillez entrer deux nombres entiers séparés par un espace =)");
    }

    // Affiche le message
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Affiche le message de fin de partie
    public void endGame(String message) {
        System.out.println(message);
        System.out.println("\nMerci d'avoir joué (^_^)\n");
    }

}
