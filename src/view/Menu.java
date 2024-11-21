package view;

import java.util.Scanner;

import model.Game;
import model.TicTacToe;
import model.Gomoku;

public class Menu {
    private Scanner scanner;
    private GameView gameView;
    private Game game;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.gameView = new GameView();
    }

    public void displayMenu() {
        decoMenu();
        System.out.println("Bienvenue !");
        System.out.println("1. Commencer une nouvelle partie");
        System.out.println("2. Jouer à Gomoku");
        System.out.println("3. Quitter");

        int choix = scanner.nextInt();
        if (choix == 1) {
            game = new TicTacToe(gameView);
            game.play(startGame());
        } else if (choix == 2) {
            game = new Gomoku(gameView);
            game.play(startGame());
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