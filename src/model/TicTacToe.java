package model;

import java.util.Scanner;

import board.Cell;
import player.ArtificialPlayer;
import player.HumanPlayer;
import player.Player;
import view.GameView;

public class TicTacToe {
    private int size = 3;
    private Cell[][] board;
    private Player currentPlayer;
    private Player playerX;
    private Player playerO;
    private GameView view;

    public TicTacToe(GameView view) {
        this.view = view;
        initBoard();
    }

    // Initialisation du plateau de jeu
    private void initBoard() {
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    // Choix des joueurs en fonction du mode de jeu
    public void playerChoice(int gameMode) {
        if (gameMode == 1) { // 1 humain vs 1 Bot
            playerX = new HumanPlayer("Humain", 'X');
            playerO = new ArtificialPlayer("Bot", 'O');
        } else if (gameMode == 2) { // 2 Bots
            playerX = new ArtificialPlayer("Bot X", 'X');
            playerO = new ArtificialPlayer("Bot O", 'O');
        } else { // 2 humains
            playerX = new HumanPlayer("Joueur X", 'X');
            playerO = new HumanPlayer("Joueur O", 'O');
        }

        currentPlayer = playerX;
    }

    // Lance le jeu
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

    // Demande au joueur de saisir un coup
    public int[] getMoveFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        int row = -1, col = -1;

        while (true) {
            try {
                view.displayPlayerMove(currentPlayer.getName(), currentPlayer.getSymbole());
                row = scanner.nextInt() - 1; // Décrémente pour obtenir des indices à partir de 0
                col = scanner.nextInt() - 1;

                if (row < 0 || row >= size || col < 0 || col >= size) {
                    view.displayInvalidCoordinates();
                } else if (!board[row][col].isEmpty()) {
                    view.displayOccupiedCell();
                } else {
                    break; // Coordonnées valides
                }
            } catch (Exception e) {
                view.displayInvalidInput();
                scanner.nextLine();
            }
        }

        return new int[] { row, col };
    }

    // Attribue une cellule à un joueur
    public void setOwner(int row, int col, Player player) {
        // Attribue le symbole du joueur à la cellule
        board[row][col].setRepresentation(String.valueOf(player.getSymbole()));
    }

    // Passe au joueur suivant
    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    // Vérifie si le plateau est plein (aucune cellule vide)
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true; // Plateau plein
    }

    // Vérifie les conditions de victoire et si la partie est terminée
    public boolean isOver() {
        // Vérifie les colonnes
        for (int i = 0; i < size; i++) {
            if (board[i][0].getRepresentation().equals(board[i][1].getRepresentation())
                    && board[i][1].getRepresentation().equals(board[i][2].getRepresentation())
                    && !board[i][0].isEmpty()) {
                view.endGame("\n" + currentPlayer.getName() + " a gagné !");
                return true;
            }
        }
        // Vérifie les lignes
        for (int i = 0; i < size; i++) {
            if (board[0][i].getRepresentation().equals(board[1][i].getRepresentation())
                    && board[1][i].getRepresentation().equals(board[2][i].getRepresentation())
                    && !board[0][i].isEmpty()) {
                view.endGame("\n" + currentPlayer.getName() + " a gagné !");
                return true;
            }
        }
        // Vérifie les diagonales
        for (int i = 0; i < size; i++) {
            if (board[0][0].getRepresentation().equals(board[1][1].getRepresentation())
                    && board[1][1].getRepresentation().equals(board[2][2].getRepresentation())
                    && !board[0][0].isEmpty()) {
                view.endGame("\n" + currentPlayer.getName() + " a gagné !");
                return true;
            }
            if (board[0][2].getRepresentation().equals(board[1][1].getRepresentation())
                    && board[1][1].getRepresentation().equals(board[2][0].getRepresentation())
                    && !board[0][2].isEmpty()) {
                view.endGame("\n" + currentPlayer.getName() + " a gagné !");
                return true;
            }
        }
        // Vérifie si le plateau est plein
        if (isBoardFull()) {
            view.endGame("\nLe plateau est rempli. Aucun gagnant. Partie nulle !");
            return true;
        }

        return false; // La partie continue
    }

}