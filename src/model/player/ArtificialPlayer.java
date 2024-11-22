package model.player;
import java.util.Random;

import model.board.Cell;
import model.board.State;

public class ArtificialPlayer extends Player {

    public ArtificialPlayer(State state) {
        super(state);
    }

    // Cette méthode choisit un coup aléatoire parmi les cases vides
    public int[] getMove(Cell[][] board, int sizeX, int sizeY) {
        Random rand = new Random();
        int row, col;

        // Recherche d'un coup valide (une case vide)
        while (true) {
            row = rand.nextInt(sizeX); // Ligne aléatoire
            col = rand.nextInt(sizeY); // Colonne aléatoire

            // Vérifie si la case est vide
            if (board[row][col].getRepresentation() == State.EMPTY.getValue()) {
                break;
            }
        }
        return new int[] { row, col };
    }

}