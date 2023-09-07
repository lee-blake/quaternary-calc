package edu.bsu.cs495.quaternary_calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestQuaternaryCalculator {

        @Test
        public void testEvaluateIgnoringLastOperationEmptyCalculatorZero() {
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                QuaternaryNumber actual = calculator.evaluateIgnoringLastOperation();
                QuaternaryNumber zero = new QuaternaryNumber("0");
                Assertions.assertEquals(zero, actual);
        }

        @Test
        public void testEvaluateIgnoringLastOperationOneSubmissionReturnsFirstNumber() {
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("13"),
                                BinaryOperator.ADDITION);
                QuaternaryNumber actual = calculator.evaluateIgnoringLastOperation();
                QuaternaryNumber expected = new QuaternaryNumber("13");
                Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testEvaluateIgnoringLastOperationIgnoresLastOperation() {
                QuaternaryCalculator calculator1 = new QuaternaryCalculator();
                calculator1.submitBinaryOperation(
                                new QuaternaryNumber("13"),
                                BinaryOperator.ADDITION);
                calculator1.submitBinaryOperation(
                                new QuaternaryNumber("21"),
                                BinaryOperator.SUBTRACTION);
                QuaternaryNumber result1 = calculator1.evaluateIgnoringLastOperation();
                QuaternaryCalculator calculator2 = new QuaternaryCalculator();
                calculator2.submitBinaryOperation(
                                new QuaternaryNumber("13"),
                                BinaryOperator.ADDITION);
                calculator2.submitBinaryOperation(
                                new QuaternaryNumber("21"),
                                BinaryOperator.ADDITION);
                QuaternaryNumber result2 = calculator2.evaluateIgnoringLastOperation();
                Assertions.assertEquals(result1, result2);
        }

        @Test
        public void testEvaluateIgnoringLastOperationMultipleAdditionSubmissionsReturnSum() {
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("13"),
                                BinaryOperator.ADDITION);
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("3"),
                                BinaryOperator.ADDITION);
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("2"),
                                BinaryOperator.ADDITION);
                QuaternaryNumber actual = calculator.evaluateIgnoringLastOperation();
                QuaternaryNumber expected = new QuaternaryNumber("30");
                Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testEvaluateIgnoringLastOperationAllOperationsSequencePerformsCorrectGreedyCalculation() {
                // In decimal, this will be 3+6-2*5/2 and should return 17 if using the
                // classical calculator
                // approach of "greedy" application of operations and this assignment's integer
                // division
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("3"),
                                BinaryOperator.ADDITION);
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("12"),
                                BinaryOperator.SUBTRACTION);
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("2"),
                                BinaryOperator.MULTIPLICATION);
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("11"),
                                BinaryOperator.DIVISION);
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("2"),
                                BinaryOperator.DIVISION);
                QuaternaryNumber actual = calculator.evaluateIgnoringLastOperation();
                QuaternaryNumber expected = new QuaternaryNumber("101");
                Assertions.assertEquals(expected, actual);
        }

        @Test

        public void testClear() {
                // testing clear function
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                calculator.operands.add(new QuaternaryNumber("10"));
                calculator.operators.add(BinaryOperator.ADDITION);
                calculator.reset();

        }

        @Test
        public void testReplaceLastBinaryOperation() {
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                // Add some operators to the calculator
                BinaryOperator operator1 = BinaryOperator.ADDITION;
                BinaryOperator operator2 = BinaryOperator.SUBTRACTION;
                BinaryOperator operator3 = BinaryOperator.MULTIPLICATION;
                calculator.operators.add(operator1);
                calculator.operators.add(operator2);

                // Call the replaceLastBinaryOperation method with a new operator
                calculator.replaceLastBinaryOperation(operator3);

                // Check if the last operator in the list has been replaced with the new
                // operator
                assertEquals(operator3, calculator.operators.get(calculator.operators.size() - 1),
                                "Last operator should be replaced");

                // Test the case when the operators list is empty and expect an
                // IllegalStateException
                calculator.reset();
                assertThrows(IllegalStateException.class, () -> calculator.replaceLastBinaryOperation(operator1),
                                "Should throw IllegalStateException when no binary operations to replace");
        }

}
