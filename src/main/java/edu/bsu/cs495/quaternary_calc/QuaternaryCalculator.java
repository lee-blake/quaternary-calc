package edu.bsu.cs495.quaternary_calc;

import java.util.ArrayList;

public class QuaternaryCalculator {

    private final ArrayList<QuaternaryNumber> operands = new ArrayList<>();
    private final ArrayList<BinaryOperator> operators = new ArrayList<>();

    // define operations in controller
    public void submitBinaryOperation(QuaternaryNumber leftOperand, BinaryOperator operator) {
        operands.add(leftOperand);
        operators.add(operator);
    }

    // clears operators and operands array list
    public void reset() {
        operands.clear();
        operators.clear();
    }

    // evaluation of given expression ignoring last operator symbol
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
            default -> throw new IllegalArgumentException("The operator has not be implemented!");
        }
    }

    public QuaternaryNumber evaluate(QuaternaryNumber lastOperand) {
        if (operands.size() == 0) {
            return lastOperand;
        }
        QuaternaryNumber subtotalIgnoringLastOperation = this.evaluateIgnoringLastOperation();
        BinaryOperator lastOperator = operators.get(operators.size() - 1);
        return performOperation(
                subtotalIgnoringLastOperation,
                lastOperator,
                lastOperand);
    }

    public void replaceLastBinaryOperation(BinaryOperator optr) {
        if (operators.isEmpty()) {
            throw new IllegalStateException("No binary operations to replace");
        }
        operators.set(operators.size() - 1, optr);
    }

}
