package model.games;

import view.GameView;

public class Gomoku extends Game {

    public Gomoku(GameView view) {
        super(view, 15, 15, 5);
        this.setDecoration();
    }

    public boolean checkWin() {
        return isOver();
    }

    public void setDecoration() {
        this.decoration = "\r\n" + //
                "╔═╗┌─┐┌┬┐┌─┐┬┌─┬ ┬\r\n" + //
                "║ ╦│ │││││ │├┴┐│ │\r\n" + //
                "╚═╝└─┘┴ ┴└─┘┴ ┴└─┘\r\n" + //
                "";
    }

    @Override
    public String getDecoration() {
        return this.decoration;
    }

}
