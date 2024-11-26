package model.player;
import model.board.CellState;

public abstract class Player {

    private CellState state;

    public Player(CellState state) {
        this.state = state;
    }

    public String getRepresentation(){
        return state.getValue();
    }

    public CellState getState(){
        return state;
    }

    @Override
    public String toString() {
        return getRepresentation();
    }
    
}
