import java.util.Scanner;

public class TicTacToe {
    private int size = 3;
    private Cell[][] board;
    private Player currentPlayer;
    private Player playerX;
    private Player playerO;

    // Initialise le plateau de jeu et les joueurs
    public TicTacToe(int gameMode) {
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
        // Choix des joueurs en fonction du mode de jeu
        if (gameMode == 1) { // 1 humain vs 1 IA
            playerX = new HumanPlayer("Humain", 'X');
            playerO = new ArtificialPlayer("Bot", 'O');
        } else if (gameMode == 2) { // 2 IA
            playerX = new ArtificialPlayer("Bot X", 'X');
            playerO = new ArtificialPlayer("Bot O", 'O');
        } else { // 2 humains
            playerX = new HumanPlayer("Joueur X", 'X');
            playerO = new HumanPlayer("Joueur O", 'O');
        }

        currentPlayer = playerX;
    }

    // Affiche le plateau de jeu
    public void display() {
        System.out.print("   "); // Pour l'alignement de l'affichage des indices de colonnes
        for (int i = 1; i <= size; i++) {
            System.out.print("   " + i + "   "); // Affiche les indices de colonnes
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print("  " + (i + 1) + " "); // Affiche les indices de lignes
            for (int j = 0; j < size; j++) {
                System.out.print("|  " + board[i][j].getRepresentation() + "  |");
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("    ---------------------"); // Ligne de séparation
            }
        }
        System.out.println();
    }

    // Demande au joueur de saisir un coup
    public int[] getMoveFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        int row = -1, col = -1;

        while (true) {
            try {
                System.out.print(currentPlayer.getName() + " (" + currentPlayer.getSymbole()
                        + "), entrez votre coup (ligne et colonne avec un espace) : ");
                row = scanner.nextInt() - 1; // Décrémente pour obtenir des indices à partir de 0
                col = scanner.nextInt() - 1;

                if (row < 0 || row >= size || col < 0 || col >= size) {
                    System.out.println("\nCoordonnées hors plateau. Réessayez =)\n");
                } else if (!board[row][col].isEmpty()) {
                    System.out.println("\nCellule déjà occupée. Réessayez =)\n");
                } else {
                    break; // Coordonnées valides
                }
            } catch (Exception e) {
                System.out.println("\nEntrée invalide =(. Assurez-vous de saisir deux nombres entiers.\n");
                scanner.nextLine();
            }
        }

        return new int[] { row, col };
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
        System.out.println("\nLe plateau est rempli. Merci d'avoir joué !\n Le jeu est terminé !\n");
        return true; // Plateau plein
    }

    // Vérifie les conditions de victoire et si la partie est terminée
    public boolean isOver() {
        // Vérifie les colonnes
        for (int i = 0; i < size; i++) {
            if (board[i][0].getRepresentation().equals(board[i][1].getRepresentation())
                    && board[i][1].getRepresentation().equals(board[i][2].getRepresentation())
                    && !board[i][0].isEmpty()) {
                endGame("\nLe " + currentPlayer.getName() + " a gagné !");
                return true;
            }
        }
        // Vérifie les lignes
        for (int i = 0; i < size; i++) {
            if (board[0][i].getRepresentation().equals(board[1][i].getRepresentation())
                    && board[1][i].getRepresentation().equals(board[2][i].getRepresentation())
                    && !board[0][i].isEmpty()) {
                endGame("\nLe " + currentPlayer.getName() + " a gagné !");
                return true;
            }
        }
        // Vérifie les diagonales
        for (int i = 0; i < size; i++) {
            if (board[0][0].getRepresentation().equals(board[1][1].getRepresentation())
                    && board[1][1].getRepresentation().equals(board[2][2].getRepresentation())
                    && !board[0][0].isEmpty()) {
                endGame("\nLe " + currentPlayer.getName() + " a gagné !");
                return true;
            }
            if (board[0][2].getRepresentation().equals(board[1][1].getRepresentation())
                    && board[1][1].getRepresentation().equals(board[2][0].getRepresentation())
                    && !board[0][2].isEmpty()) {
                endGame("\nLe " + currentPlayer.getName() + " a gagné !");
                return true;
            }
        }

        // Vérifie si le plateau est plein
        if (isBoardFull()) {
            endGame("\nLe plateau est rempli. Aucun gagnant. Partie nulle !");
            return true;
        }

        return false; // La partie continue
    }

    public void endGame(String message) {
        display(); // Affiche le plateau de jeu
        System.out.println(message); // Affiche le message de fin
        System.out.println("\n Merci d'avoir joué  =)\n Le jeu est terminé !\n");
    }

    // Lance le jeu
    public void play() {
        decoration(); // Affiche le Titre
        while (true) {
            System.out.println("Tour du " + currentPlayer.getName() + " (" + currentPlayer.getSymbole() + ")"); // Affiche le joueur actuel
            display(); // Affiche le plateau de jeu

            int[] move;

            if (currentPlayer instanceof HumanPlayer) {
                move = getMoveFromPlayer();
            } else {
                move = ((ArtificialPlayer) currentPlayer).getMove(board, size); // Laisse l'IA choisir un coup
                System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbole() + ") a joué en ["
                        + (move[0] + 1) + ", " + (move[1] + 1) + "]");
            }

            setOwner(move[0], move[1], currentPlayer); // Attribue la cellule au joueur

            // Vérifie si le joueur a gagné ou si la partie est terminée
            if (isOver()) {
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