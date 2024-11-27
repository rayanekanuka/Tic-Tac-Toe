package model.games;

import model.board.Board;
import model.board.CellState;
import model.player.ArtificialPlayer;
import model.player.HumanPlayer;
import model.player.Player;
import view.GameView;

public abstract class Game {
    protected int sizeX;
    protected int sizeY;
    protected Board board;
    protected Player currentPlayer;
    protected Player playerX;
    protected Player playerO;
    protected GameView view;
    protected String decoration;
    protected int WinWin;

    /**
     * Constructeur de la classe Game.
     * 
     * @param view La vue du jeu.
     * @param size La taille du plateau de jeu.
     */
    public Game(GameView view, int sizeX, int sizeY, int WinWin) {
        this.view = view;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.WinWin = WinWin;
        this.board = new Board(sizeX, sizeY);
        this.playerO = new HumanPlayer(CellState.O);
        this.playerX = new HumanPlayer(CellState.X);
    }

    /**
     * Choisit les joueurs en fonction du mode de jeu.
     * 
     * @param gameMode Le mode de jeu choisi (1: Humain vs Bot, 2: Bot vs Bot,
     *                 3 : Humain vs Humain).
     */
    public void playerChoice(int gameMode) {
        if (gameMode == 1) {
            playerX = new HumanPlayer(CellState.X);
            playerO = new ArtificialPlayer(CellState.O);
        } else if (gameMode == 2) {
            playerX = new ArtificialPlayer(CellState.X);
            playerO = new ArtificialPlayer(CellState.O);
        } else {
            playerX = new HumanPlayer(CellState.X);
            playerO = new HumanPlayer(CellState.O);
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
            view.decoration(this.decoration);
            view.displayMessage("Tour du Joueur" + currentPlayer.getRepresentation());
            view.displayBoard(board.getBoard());

            int[] move;

            // Demande au joueur de saisir un coup ou laisse l'IA choisir un coup
            if (currentPlayer instanceof HumanPlayer) {
                move = getMoveFromPlayer();
            } else {
                // Le Bot choisit un coup
                move = ((ArtificialPlayer) currentPlayer).getMove(board.getBoard(), sizeX, sizeY);
            }

            // Attribue la cellule au joueur

            if (this instanceof ConnectFour) {
                ((ConnectFour) this).placeStone(move[1], currentPlayer.getState());
            } else {
                board.setOwner(move[0], move[1], currentPlayer);
            } 

            //board.setOwner(move[0], move[1], currentPlayer);
            // wait(1000); // Pause de 1 seconde

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
        return view.makeMove(currentPlayer.getRepresentation(), currentPlayer.getRepresentation(), sizeX, sizeY);
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
        if (board.checkWin(WinWin, currentPlayer.getState())) {
            view.displayBoard(board.getBoard()); // Affiche le plateau final
            view.endGame("\n Le Joueur" + currentPlayer.getRepresentation() + "a gagné !");
            return true;
        } else if (board.isBoardFull()) {
            view.displayBoard(board.getBoard()); // Affiche le plateau final
            view.endGame("\nLe plateau est rempli. Aucun gagnant. Partie nulle !");
            return true;
        } else {
            return false; // La partie continue
        }
    }

    public abstract boolean checkWin();
    public abstract void setDecoration();
    public abstract String getDecoration();

}
