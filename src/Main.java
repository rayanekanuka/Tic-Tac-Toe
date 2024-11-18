import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voulez-vous jouer contre un joueur artificiel ? (oui/non)");
        String response = scanner.nextLine().trim().toLowerCase();
        boolean isArtificialPlayer = response.equals("oui");

        TicTacToe game = new TicTacToe(isArtificialPlayer);
        game.play();
    }
}