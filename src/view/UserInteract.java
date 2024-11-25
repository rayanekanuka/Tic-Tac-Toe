package view;

import java.util.Scanner;

import model.games.Game;
import model.games.Gomoku;
import model.games.TicTacToe;
import model.games.ConnectFour;

public class UserInteract {
    private Scanner scanner;
    private GameView gameView;
    private Game game;

    public UserInteract() {
        this.scanner = new Scanner(System.in);
        this.gameView = new GameView();
    }

    public void displayMenu() {
        decoMenu();
        System.out.println("On joue à quoi ?");
        System.out.println("1. Jouer au Tic Tac Toe");
        System.out.println("2. Jouer à Gomoku");
        System.out.println("3. Jouer au Puissance 4");
        System.out.println("4. Quitter");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                game = new TicTacToe(gameView);
                game.play(startGame());
                break;
            case 2:
                game = new Gomoku(gameView);
                game.play(startGame());
                break;
            case 3:
                game = new ConnectFour(gameView);
                game.play(startGame());
                break;
            case 4:
                System.out.println("\nA bientôt (^_^)");
                break;
            default:
                System.out.println("Choix invalide");
                displayMenu();
        }
    }

    public int startGame() {
        decoMenu();
        System.out.println("CHOISISSEZ UN MODE DE JEU :");
        System.out.println("1. Humain vs Bot");
        System.out.println("2. Bot vs Bot");
        System.out.println("3. Humain vs Humain");
        System.out.print("\nVotre choix : ");

        int gameMode = scanner.nextInt();
        scanner.nextLine();
        return gameMode;
    }


    public void decoMenu() {
        System.out.println("\r\n" + //
                "██████╗ ██╗      █████╗ ██╗   ██╗     ██████╗  █████╗ ███╗   ███╗███████╗███████╗\r\n" + //
                "██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝██╔════╝\r\n" + //
                "██████╔╝██║     ███████║ ╚████╔╝     ██║  ███╗███████║██╔████╔██║█████╗  ███████╗\r\n" + //
                "██╔═══╝ ██║     ██╔══██║  ╚██╔╝      ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ╚════██║\r\n" + //
                "██║     ███████╗██║  ██║   ██║       ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗███████║\r\n" + //
                "╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝        ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝╚══════╝\r\n" + //
                "                                                                                 \r\n" + //
                "");
    }

}