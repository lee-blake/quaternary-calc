//controller

package edu.bsu.cs495.quaternary_calc;

//import java.awt.event.ActionEvent;


public class QuaternaryCalculator {

    public void getString() {
        // placeholder to get the string from gui
    }

    // int quat_num = new QuaternaryNumber(null);

    QuaternaryNumber qn1 = new QuaternaryNumber("1");
    QuaternaryNumber qn2 = new QuaternaryNumber("2");
    // below is placeholder
    String expressionSymbol = "";


    public void submitBinaryOperation() {
        // placeholder
    }

    public QuaternaryNumber evaluateIgnoringLastOperation() {
        return new QuaternaryNumber("0");
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
