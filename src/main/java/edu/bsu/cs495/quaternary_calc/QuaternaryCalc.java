//controller

package edu.bsu.cs495.quaternary_calc;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuaternaryCalc {

    public void getString() {
        // placeholder to get the string from gui
    }

    // int quat_num = new QuaternaryNumber(null);

    QuaternaryNumber qn1 = new QuaternaryNumber("1");
    QuaternaryNumber qn2 = new QuaternaryNumber("2");
    // below is placeholder
    String expressionSymbol = "";

    public enum BinaryOperator {
        ADDITION("+"),
        SUBTRACTION("-"),
        MULTIPLICATION("*"),
        DIVISION("/"),
        SQUARED("**"),
        SQUAREROOT("Math.sqrt()");

        private final String symbol;

        BinaryOperator(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

    }

    public void submitBinaryOperation() {
        // placeholder
    }

    /*
     * private double operatorExecution(double a, double b,
     * QuaternaryCalc.BinaryOperator operator) {
     * switch (operator) {
     * case ADDITION:
     * return a + b;
     * case SUBTRACTION:
     * return a - b;
     * case MULTIPLICATION:
     * return a * b;
     * case DIVISION:
     * return a / b;
     * case SQUARED:
     * return Math.pow(a, b);
     * case SQUAREROOT:
     * return Math.sqrt(a);
     * default:
     * throw new IllegalArgumentException("This Operator is not valid\n");
     * 
     * }
     * }
     */
}
