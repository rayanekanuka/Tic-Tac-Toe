package model.games;

import model.board.Board;
import model.board.State;
import model.player.ArtificialPlayer;
import model.player.HumanPlayer;
import model.player.Player;
import view.GameView;

public abstract class Game {
    private int size;
    private Board board;
    private Player currentPlayer;
    private Player playerX;
    private Player playerO;
    private GameView view;

    /**
     * Constructeur générique pour les jeux
     * 
     * @param view La vue du jeu.
     * @param size La taille du plateau de jeu.
     */
    public Game(GameView view, int size) {
        this.size = size;
        this.view = view;
        board = new Board(size);
    }

    /**
     * Constructeur pour le jeu TicTacToe
     * 
     * @param view La vue du jeu.
     */
    public Game(GameView view) {
        this.size = 3;
        this.view = view;
        board = new Board(size);
    }

    /**
     * Constructeur pour le jeu Gomoku
     * 
     * @param view La vue du jeu.
     * @param size La taille du plateau de jeu.
     */
    public Game() {
        this(new GameView());
    }

    /**
     * Choisit les joueurs en fonction du mode de jeu.
     * 
     * @param gameMode Le mode de jeu choisi (1: Humain vs Bot, 2: Bot vs Bot,
     *                 3 : Humain vs Humain).
     */
    public void playerChoice(int gameMode) {
        if (gameMode == 1) {
            playerX = new HumanPlayer(State.X);
            playerO = new ArtificialPlayer(State.O);
        } else if (gameMode == 2) {
            playerX = new ArtificialPlayer(State.X);
            playerO = new ArtificialPlayer(State.O);
        } else {
            playerX = new HumanPlayer(State.X);
            playerO = new HumanPlayer(State.O);
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
            view.displayMessage("Tour du Joueur" + currentPlayer.getRepresentation());
            view.displayBoard(board.getBoard());

            int[] move;

            // Demande au joueur de saisir un coup ou laisse l'IA choisir un coup
            if (currentPlayer instanceof HumanPlayer) {
                move = getMoveFromPlayer();
            } else {
                // Le Bot choisit un coup
                move = ((ArtificialPlayer) currentPlayer).getMove(board.getBoard(), size);
            }
            // Attribue la cellule au joueur
            board.setOwner(move[0], move[1], currentPlayer);
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
        return view.makeMove(currentPlayer.getRepresentation(), currentPlayer.getRepresentation(), size);
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
        if (board.checkWin()) {
            view.displayBoard(board.getBoard()); // Affiche le plateau final
            view.endGame("\n Le Joueur" + currentPlayer.getRepresentation() + "a gagné !");
            return true;
        }
        if (board.isBoardFull()) {
            view.displayBoard(board.getBoard()); // Affiche le plateau final
            view.endGame("\nLe plateau est rempli. Aucun gagnant. Partie nulle !");
            return true;
        }
        return false; // La partie continue
    }

}
