package model.board;

public enum CellState {
    EMPTY ("   "),
    X (" X "),
    O (" O ");

    private final String value;

    private CellState(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
