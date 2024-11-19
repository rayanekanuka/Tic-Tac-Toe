package model.player;
import java.util.Random;

import model.board.Cell;

public class ArtificialPlayer extends Player {

    public ArtificialPlayer(String name, char symbole) {
        super(name, symbole);
    }

    // Cette méthode choisit un coup aléatoire parmi les cases vides
    public int[] getMove(Cell[][] board, int size) {
        Random rand = new Random();
        int row, col;

        // Recherche d'un coup valide (une case vide)
        while (true) {
            row = rand.nextInt(size); // Ligne aléatoire
            col = rand.nextInt(size); // Colonne aléatoire

            // Vérifie si la case est vide
            if (board[row][col].isEmpty()) {
                break;
            }
        }
        return new int[] { row, col };
    }

}