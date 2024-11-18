import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez le mode de jeu :");
        System.out.println("1. Humain vs IA");
        System.out.println("2. IA vs IA");
        System.out.println("3. Humain vs Humain");
        int gameMode = scanner.nextInt();

        TicTacToe game = new TicTacToe(gameMode);
        game.play();
    }
}