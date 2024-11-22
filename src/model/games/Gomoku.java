package model.games;
import view.GameView;

public class Gomoku extends Game {

    public Gomoku(GameView view) {
        super(view, 15);
    }

    public boolean checkWin() {
        return false;
    }

}
