package view;

import java.util.Scanner;
import model.TicTacToe;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Bienvenue dans le jeu du Tic Tac Toe !");
        System.out.println("Choisissez un mode de jeu :");
        System.out.println("1. Humain vs IA");
        System.out.println("2. IA vs IA");
        System.out.println("3. Humain vs Humain");
        System.out.print("Votre choix : ");
        int gameMode = scanner.nextInt();
        scanner.nextLine(); // Consomme le retour à la ligne

        TicTacToe game = new TicTacToe(gameMode);
        game.play();
    }
}