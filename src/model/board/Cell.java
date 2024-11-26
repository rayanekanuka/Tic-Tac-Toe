package model.board;

public class Cell {

    private CellState state;

    Cell(){
        this.state = CellState.EMPTY;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public String getRepresentation(){
        return this.state.getValue();
    }

    public CellState getState(){
        return this.state;
    }

    public String toString()
    {
        return getRepresentation();
    }

}