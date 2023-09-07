package edu.bsu.cs495.quaternary_calc;

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
}
