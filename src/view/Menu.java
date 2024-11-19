package view;

import java.util.Scanner;
import model.TicTacToe;

public class Menu {
    private Scanner scanner;
    private GameView gameView;
    private TicTacToe game;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.gameView = new GameView();
    }

    public void displayMenu() {
        decoMenu();
        System.out.println("Bienvenue !");
        System.out.println("1. Commencer une nouvelle partie");
        System.out.println("2. Quitter");

        int choix = scanner.nextInt();
        if (choix == 1) {
            startGame();
        } else {
            System.out.println("\nMerci d'avoir joué (^_^)");
        }
    }

    public int startGame() {
        decoMenu();
        System.out.println("Choisissez un mode de jeu :");
        System.out.println("1. Humain vs Bot");
        System.out.println("2. Bot vs Bot");
        System.out.println("3. Humain vs Humain");
        System.out.print("\nVotre choix : ");

        int gameMode = scanner.nextInt();
        scanner.nextLine();

        game = new TicTacToe(gameView);
        game.play(gameMode);
        return gameMode;
    }

    public void decoMenu() {
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