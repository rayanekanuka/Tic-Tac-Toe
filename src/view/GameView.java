package view;

import board.Cell;

public class GameView {

    public GameView() {

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

    // Affiche le message de début de partie
    public void displayPlayerMove(String playerName, char playerSymbol) {
        System.out.print(playerName + " (" + playerSymbol + "), entrez votre coup (ligne et colonne avec un espace) : ");
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
        System.out.println(message); // Affiche le message de fin
        System.out.println("\n Merci d'avoir joué  =)\n Le jeu est terminé !\n");
    }

}
