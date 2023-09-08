package edu.bsu.cs495.quaternary_calc;

public enum UnaryOperator {

    SQUARE("sq"),
    SQUARE_ROOT("sqrt");

    private final String symbol;

    UnaryOperator(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
