package model.games;

import view.GameView;
import model.games.Game;
import model.board.CellState;

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

    public String getDecoration() {
        return this.decoration;
    }

    @Override
    public boolean isOver() {
        CellState currentState = currentPlayer.getState();

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (checkDirection(i, j, 0, 1, currentState) // Horizontal
                        || checkDirection(i, j, 1, 0, currentState) // Vertical
                        || checkDirection(i, j, 1, 1, currentState) // Diagonale descendante
                        || checkDirection(i, j, 1, -1, currentState)) { // Diagonale ascendante
                    view.displayBoard(board.getBoard());
                    view.endGame("\nLe Joueur " + currentPlayer.getRepresentation() + " a gagné !");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int i, int j, int u, int v, CellState currentState) {
        for (int k = 0; k < WinWin; k++) {
            if (!exist(i + u * k, j + v * k)) {
                return false;
            }
            if (board.getBoard()[i + u * k][j + v * k].getState() != currentState) {
                return false;
            }
        }
        return true;
    }

    private boolean exist(int i, int j) {
        return i >= 0 && i < sizeX && j >= 0 && j < sizeY;
    }
}
