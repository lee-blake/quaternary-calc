//controller

package edu.bsu.cs495.quaternary_calc;

//import java.awt.event.ActionEvent;


import java.util.ArrayList;

public class QuaternaryCalculator {

    public void getString() {
        // placeholder to get the string from gui
    }

    // int quat_num = new QuaternaryNumber(null);

    QuaternaryNumber qn1 = new QuaternaryNumber("1");
    QuaternaryNumber qn2 = new QuaternaryNumber("2");
    // below is placeholder
    String expressionSymbol = "";

    private final ArrayList<QuaternaryNumber> operands = new ArrayList<>();
    private final ArrayList<BinaryOperator> operators = new ArrayList<>();

    public void submitBinaryOperation(QuaternaryNumber leftOperand, BinaryOperator operator) {
        operands.add(leftOperand);
        operators.add(operator);
    }

    public QuaternaryNumber evaluateIgnoringLastOperation() {
        if (operands.isEmpty()) {
            return new QuaternaryNumber("0");
        }
        QuaternaryNumber runningTotal = operands.get(0);
        for (int i = 0; i < operands.size() - 1; i++) {
            QuaternaryNumber rightOperand = operands.get(i + 1);
            BinaryOperator operator = operators.get(i);
            runningTotal = performOperation(runningTotal, operator, rightOperand);
        }
        return runningTotal;
    }

    private QuaternaryNumber performOperation(QuaternaryNumber leftOperand, BinaryOperator operator,
                                              QuaternaryNumber rightOperand) {
        switch (operator) {
            case ADDITION -> {
                return leftOperand.plus(rightOperand);
            }
            case SUBTRACTION -> {
                return leftOperand.minus(rightOperand);
            }
            case MULTIPLICATION -> {
                return leftOperand.times(rightOperand);
            }
            case DIVISION -> {
                return leftOperand.dividedBy(rightOperand);
            }
            default -> {
                throw new IllegalArgumentException("The operator has not be implemented!");
            }
        }
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
