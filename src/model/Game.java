package model;

import model.board.Board;
import model.board.Cell;
import model.player.ArtificialPlayer;
import model.player.HumanPlayer;
import model.player.Player;
import view.GameView;

public abstract class Game {
    private int size = 3;
    private Board board;
    private Player currentPlayer;
    private Player playerX;
    private Player playerO;
    private GameView view;

    public Game(GameView view) {
        this.size = 3;
        this.view = view;
        board = new Board(size, size);
    }

    /**
     * Choisit les joueurs en fonction du mode de jeu.
     * 
     * @param gameMode Le mode de jeu choisi (1: Humain vs Bot, 2: Bot vs Bot, 
     *                 3 : Humain vs Humain).
     */
    public void playerChoice(int gameMode) {
        if (gameMode == 1) {
            playerX = new HumanPlayer("Humain", 'X');
            playerO = new ArtificialPlayer("Bot", 'O');
        } else if (gameMode == 2) {
            playerX = new ArtificialPlayer("Bot X", 'X');
            playerO = new ArtificialPlayer("Bot O", 'O');
        } else {
            playerX = new HumanPlayer("Joueur X", 'X');
            playerO = new HumanPlayer("Joueur O", 'O');
        }

        currentPlayer = playerX;
    }

    /**
     * Lance le jeu.
     * 
     * @param gameMode Le mode de jeu choisi.
     */
    public void play(int gameMode) {
        playerChoice(gameMode); // Choix des joueurs

        while (true) {
            view.decoration();
            view.displayMessage("Tour du " + currentPlayer.getName() + " (" + currentPlayer.getSymbole() + ")");
            view.displayBoard(board);

            int[] move;

            // Demande au joueur de saisir un coup ou laisse l'IA choisir un coup
            if (currentPlayer instanceof HumanPlayer) {
                move = getMoveFromPlayer();
            } else {
                move = ((ArtificialPlayer) currentPlayer).getMove(board, size); // Laisse l'IA choisir un coup
            }

            setOwner(move[0], move[1], currentPlayer); // Attribue la cellule au joueur
            wait(1000); // Pause de 1 seconde

            // Vérifie si le joueur a gagné ou si la partie est terminée
            if (isOver()) {
                break;
            }
            switchPlayer();
        }
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Demande au joueur de saisir un coup.
     * 
     * @return Un tableau contenant les coordonnées du coup (ligne et colonne).
     */
    public int[] getMoveFromPlayer() {
        return view.makeMove(currentPlayer.getName(), currentPlayer.getSymbole(), size);
    }

    /**
     * Passe au joueur suivant.
     */
    public void switchPlayer() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }

    /**
     * Vérifie les conditions de victoire et si la partie est terminée.
     * 
     * @return true si la partie est terminée, false sinon.
     */
    public boolean isOver() {
        if (checkWin()) {
            view.displayBoard(board); // Affiche le plateau final
            view.endGame("\n" + currentPlayer.getName() + " a gagné !");
            return true;
        }
        if (isBoardFull()) {
            view.displayBoard(board); // Affiche le plateau final
            view.endGame("\nLe plateau est rempli. Aucun gagnant. Partie nulle !");
            return true;
        }
        return false; // La partie continue
    }

}
