package view;

import java.util.Scanner;

import model.board.Board;
import model.board.Cell;

public class GameView {
    private Scanner scanner = new Scanner(System.in);
    private Cell[][] board;

    public GameView() {
        this.scanner = new Scanner(System.in);
    }

    public void decoration() {
        System.out.println("\r\n" + //
                "╔╦╗┬┌─┐  ╔╦╗┌─┐┌─┐  ╔╦╗┌─┐┌─┐\r\n" + //
                " ║ ││     ║ ├─┤│     ║ │ │├┤ \r\n" + //
                " ╩ ┴└─┘   ╩ ┴ ┴└─┘   ╩ └─┘└─┘\r\n" + //
                "");
    }

    public void displayBoard(Cell[][] board) {
        System.out.print("   "); // Pour l'alignement de l'affichage des indices de colonnes
        for (int i = 1; i <= board.length; i++) {
            System.out.print("   " + i + "   "); // Affiche les indices de colonnes
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.print("  " + (i + 1) + " "); // Affiche les indices de lignes
            for (int j = 0; j < board.length; j++) {
                System.out.print("|  " + board[i][j].getRepresentation() + "  ");
            }
            System.out.println("|");
            if (i < board.length - 1) {
                System.out.println("    -------------------"); // Ligne de séparation
            }
        }
    }


    /**
     * Demande au joueur de saisir un coup.
     * 
     * @return Un tableau contenant les coordonnées du coup (ligne et colonne).
     */
    public int[] makeMove(String playerName, char playerSymbole, int size) {
        int row = -1, col = -1;

        while (true) {
            try {
                displayPlayerMove(playerName, playerSymbole);
                row = scanner.nextInt() - 1; // Décrémente pour obtenir des indices à partir de 0
                col = scanner.nextInt() - 1;

                if (row < 0 || row >= size || col < 0 || col >= size) {
                    displayInvalidCoordinates();
                } else if (!board[row][col].isEmpty()) {
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
    public void displayPlayerMove(String playerName, char playerSymbol) {
        System.out
                .print(playerName + " (" + playerSymbol + "), entrez votre coup (ligne et colonne avec un espace) : ");
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
