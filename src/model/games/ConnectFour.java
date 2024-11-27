package model.games;

import model.board.CellState;
import view.GameView;

public class ConnectFour extends Game {

    public ConnectFour(GameView view) {
        super(view, 7, 6, 4);
        this.setDecoration();
    }

    @Override
    public void setDecoration() {
        this.decoration = "\r\n" + //
                "╔═╗┌─┐┌┐┌┌┐┌┌─┐┌─┐┌┬┐  ╔═╗┌─┐┬ ┬┬─┐\r\n" + //
                "║  │ │││││││├┤ │   │   ╠╣ │ ││ │├┬┘\r\n" + //
                "╚═╝└─┘┘└┘┘└┘└─┘└─┘ ┴   ╚  └─┘└─┘┴└─\r\n" + //
                "";
    }

    @Override
    public String getDecoration() {
        return this.decoration;
    }

    @Override
    public boolean checkWin() {
        return isOver();
    }

    public boolean placeStone(int col, CellState state) {
        for (int row = sizeX - 1; row >= 0; row--) {
            if (board.getBoard()[row][col].getState() == CellState.EMPTY) {
                board.getBoard()[row][col].setState(state);
                return true;
            }
        }
        return false; // La colonne est pleine
    }

}