import java.util.Scanner;

public class TicTacToe {
    private int size = 3;
    private Cell[][] board;
    private Player currentPlayer;
    private Player playerX;
    private Player playerO;

    // Initialise le plateau de jeu et les joueurs
    public TicTacToe() {
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
        playerX = new Player("Joueur X", 'X');
        playerO = new Player("Joueur O", 'O');
        currentPlayer = playerX;
    }

    // Affiche le plateau de jeu
        public void display() {
            for (int i = 0; i < size; i++) {
                System.out.print("|");
                for (int j = 0; j < size; j++) {
                    System.out.print(" " + board[i][j].getRepresentation() + " |");
                }
                System.out.println();
                if (i < size - 1) {
                    System.out.println("------------");
                }
            }
        }
    
        // Demande au joueur de saisir un coup
        public int[] getMoveFromPlayer() {
            Scanner scanner = new Scanner(System.in);
            int row = -1, col = -1;
    
            while (true) {
                try {
                    System.out.print(currentPlayer.getName() + " (" + currentPlayer.getSymbole() + "), entrez votre coup (ligne et colonne) : ");
                    row = scanner.nextInt() - 1;
                    col = scanner.nextInt() - 1;
    
                    if (row < 0 || row >= size || col < 0 || col >= size) {
                        System.out.println("Coordonnées hors plateau. Réessayez =) ");
                    } else if (!board[row][col].isEmpty()) {
                        System.out.println("Cellule déjà occupée. Réessayez =)");
                    } else {
                        break; // Coordonnées valides
                    }
                } catch (Exception e) {
                    System.out.println("Entrée invalide =(. Assurez-vous de saisir deux nombres entiers.");
                    scanner.nextLine(); 
                }
            }
    
            return new int[]{row, col};
        }

        // Attribue une cellule à un joueur
        public void setOwner(int row, int col, Player player) {
            board[row][col].setRepresentation(String.valueOf(player.getSymbole())); // Attribue le symbole du joueur à la cellule
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

        public void endGame(String message) {
            display(); // Affiche le plateau de jeu
            System.out.println("Merci d'avoir joué !");
        }

        // Lance le jeu
        public void play() {
            while (true) {
                decoration(); // Affiche le Titre
                System.out.println("Tour de " + currentPlayer.getName() + " (" + currentPlayer.getSymbole() + ")"); // Affiche le joueur actuel
                display(); // Affiche le plateau de jeu
                int[] move = getMoveFromPlayer(); // Demande au joueur de saisir un coup
                setOwner(move[0], move[1], currentPlayer); // Attribue la cellule au joueur

                // Vérifie si le joueur a gagné
                if (isBoardFull()) {
                    endGame("Le jeu est terminé ! Le plateau est rempli.");
                    break; // Fin du jeu
                }
                switchPlayer(); // Passe au joueur suivant
            }
        }

        public void decoration() {
            System.out.println("####### ###  #####     #######    #     #####     ####### ####### #######\r\n" + //
                                "   #     #  #     #       #      # #   #     #       #    #     # #\r\n" + //
                                "   #     #  #             #     #   #  #             #    #     # #\r\n" + //
                                "   #     #  #             #    #     # #             #    #     # #####\r\n" + //
                                "   #     #  #             #    ####### #             #    #     # #\r\n" + //
                                "   #     #  #     #       #    #     # #     #       #    #     # #\r\n" + //
                                "   #    ###  #####        #    #     #  #####        #    ####### #######\r\n" + //
                                "\r\n" + //
                                "");
        }

}