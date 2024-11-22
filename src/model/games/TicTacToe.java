package model.games;

import view.GameView;

/**
 * Classe représentant le jeu de Tic-Tac-Toe.
 */
public class TicTacToe extends Game {

    /**
     * Constructeur de la classe TicTacToe.
     * 
     * @param view La vue du jeu.
     */
    public TicTacToe(GameView view) {
        super(view, 3, 3,3);
        this.setDecoration();
    }

    /**
     * Affiche la décoration du jeu.
     */
    public void setDecoration() {
        this.decoration = "\r\n" + //
                "╔╦╗┬┌─┐  ╔╦╗┌─┐┌─┐  ╔╦╗┌─┐┌─┐\r\n" + //
                " ║ ││     ║ ├─┤│     ║ │ │├┤ \r\n" + //
                " ╩ ┴└─┘   ╩ ┴ ┴└─┘   ╩ └─┘└─┘\r\n" + //
                "";
    }

    public String getDecoration() {
        return this.decoration;
    }   

}