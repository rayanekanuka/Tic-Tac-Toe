package model.player;
import model.board.State;

public abstract class Player {

    private State state;

    public Player(State state) {
        this.state = state;
    }

    public String getRepresentation(){
        return state.getValue();
    }

    public State getState(){
        return state;
    }

    @Override
    public String toString() {
        return getRepresentation();
    }
    
}
