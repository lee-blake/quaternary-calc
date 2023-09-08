package edu.bsu.cs495.quaternary_calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        public void testEvaluateEmptyCalculatorReturnsPassedValue() {
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                QuaternaryNumber actual = calculator.evaluate(new QuaternaryNumber("101"));
                QuaternaryNumber expected = new QuaternaryNumber("101");
                Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testEvaluateSingleSubmissionAdditionAddsBothValues() {
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("3"),
                                BinaryOperator.ADDITION);
                QuaternaryNumber actual = calculator.evaluate(new QuaternaryNumber("11"));
                QuaternaryNumber expected = new QuaternaryNumber("20");
                Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testEvaluateSingleSubmissionSubtractionSubtractsInCorrectOrder() {
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("13"),
                                BinaryOperator.SUBTRACTION);
                QuaternaryNumber actual = calculator.evaluate(new QuaternaryNumber("2"));
                QuaternaryNumber expected = new QuaternaryNumber("11");
                Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testEvaluateSequenceOfAllOperatorsReturnsCorrectly() {
                // In decimal, this will be 2-1+7/2*3 and should return 12 if using the
                // classical calculator
                // approach of "greedy" application of operations and this assignment's integer
                // division
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("2"),
                                BinaryOperator.SUBTRACTION);
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("1"),
                                BinaryOperator.ADDITION);
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("13"),
                                BinaryOperator.DIVISION);
                calculator.submitBinaryOperation(
                                new QuaternaryNumber("2"),
                                BinaryOperator.MULTIPLICATION);
                QuaternaryNumber actual = calculator.evaluate(new QuaternaryNumber("3"));
                QuaternaryNumber expected = new QuaternaryNumber("30");
                Assertions.assertEquals(expected, actual);
        }

        @Test
        public void testClear() {
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                calculator.submitBinaryOperation(new QuaternaryNumber("1"), BinaryOperator.ADDITION);
                calculator.submitBinaryOperation(new QuaternaryNumber("2"), BinaryOperator.SUBTRACTION);
                calculator.evaluateIgnoringLastOperation();
                calculator.reset();
                assertEquals(new QuaternaryNumber("0"), calculator.evaluateIgnoringLastOperation());
        }

        @Test
        public void testReplaceLastBinaryOperation() {
                QuaternaryCalculator calculator = new QuaternaryCalculator();
                calculator.submitBinaryOperation(new QuaternaryNumber("2"), BinaryOperator.SUBTRACTION);
                calculator.replaceLastBinaryOperation(BinaryOperator.MULTIPLICATION);
                assertEquals(new QuaternaryNumber("-2"), calculator.evaluate(new QuaternaryNumber("-1")));
        }

}
