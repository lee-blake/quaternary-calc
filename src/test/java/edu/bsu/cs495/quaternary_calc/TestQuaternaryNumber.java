package edu.bsu.cs495.quaternary_calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestQuaternaryNumber {

    @Test
    public void testConstructorThrowsExceptionOnNonQuaternaryNumber() {
        String notQuaternary = "1042";
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new QuaternaryNumber(notQuaternary)
        );
    }

    @Test
    public void testConstructorWorksFineOnQuaternaryNumber() {
        String quaternary = "-0321";
        new QuaternaryNumber(quaternary);
    }


    @Test
    public void testConstructorToStringSimpleReturnsIdentically() {
        String constructorString = "12";
        QuaternaryNumber number = new QuaternaryNumber(constructorString);
        String actual = number.toString();
        Assertions.assertEquals(constructorString, actual);
    }

    @Test
    public void testConstructorToStringLeadingZerosAreStripped() {
        String leadingZeros = "001313232112";
        QuaternaryNumber number = new QuaternaryNumber(leadingZeros);
        String actual = number.toString();
        String expected = "1313232112";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testConstructorToStringNegativeNumberReturnsIdentically() {
        String constructorString = "-12032102";
        QuaternaryNumber number = new QuaternaryNumber(constructorString);
        String actual = number.toString();
        Assertions.assertEquals(constructorString, actual);
    }

    @Test
    public void testConstructorToStringZeroDisplaysCorrectly() {
        QuaternaryNumber zero = new QuaternaryNumber("0");
        String actual = zero.toString();
        String expected = "0";
        Assertions.assertEquals(expected, actual);
    }



    // This is testing that incomparable types due result in 'false' - which is intended behavior in Java.
    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    public void testEqualsCompareToNonNumberFalse() {
        String otherObject = "a";
        QuaternaryNumber number = new QuaternaryNumber("0");
        Assertions.assertNotEquals(number, otherObject);
    }

    @Test
    public void testEqualsSameNumberTrue() {
        QuaternaryNumber first = new QuaternaryNumber("321");
        QuaternaryNumber second = new QuaternaryNumber("321");
        Assertions.assertEquals(first, second);
    }

    @Test
    public void testEqualsOtherNumberFalse() {
        QuaternaryNumber first = new QuaternaryNumber("11111");
        QuaternaryNumber second = new QuaternaryNumber("22222");
        Assertions.assertNotEquals(first, second);
    }

    @Test
    public void testEqualsTwoEqualNegativesTrue() {
        QuaternaryNumber first = new QuaternaryNumber("-3210");
        QuaternaryNumber second = new QuaternaryNumber("-03210");
        Assertions.assertEquals(first, second);
    }

    @Test
    public void testEqualsTwoNonEqualNegativesFalse() {
        QuaternaryNumber first = new QuaternaryNumber("-123");
        QuaternaryNumber second = new QuaternaryNumber("-321");
        Assertions.assertNotEquals(first,second);
    }

    @Test
    public void testEqualsMixedSignsFalse() {
        QuaternaryNumber positive = new QuaternaryNumber("1");
        QuaternaryNumber negative = new QuaternaryNumber("-1");
        Assertions.assertNotEquals(positive, negative);
    }



    @Test
    public void testTimesMultiplyByZeroReturnsZero() {
        QuaternaryNumber five = new QuaternaryNumber("11");
        QuaternaryNumber zero = new QuaternaryNumber("0");
        QuaternaryNumber result = five.times(zero);
        Assertions.assertEquals(result, zero);
    }

    @Test
    public void testTimesMultiplyByTwoReturnsDouble() {
        QuaternaryNumber seven = new QuaternaryNumber("13");
        QuaternaryNumber two = new QuaternaryNumber("2");
        QuaternaryNumber result = seven.times(two);
        QuaternaryNumber expected = new QuaternaryNumber("32");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testTimesMultiplyByNegativeNumberReturnsCorrectly() {
        QuaternaryNumber negativeFive = new QuaternaryNumber("-11");
        QuaternaryNumber negativeThree = new QuaternaryNumber("-3");
        QuaternaryNumber result = negativeFive.times(negativeThree);
        QuaternaryNumber expected = new QuaternaryNumber("33");
        Assertions.assertEquals(expected, result);
    }



    @Test
    public void testDividedByDivisionByOneReturnsIdentity() {
        QuaternaryNumber seven = new QuaternaryNumber("13");
        QuaternaryNumber one = new QuaternaryNumber("1");
        QuaternaryNumber result = seven.dividedBy(one);
        Assertions.assertEquals(seven, result);
    }

    @Test
    public void testDividedByDivisionByNegativeTwoReturnsCorrectly() {
        QuaternaryNumber eight = new QuaternaryNumber("20");
        QuaternaryNumber negativeTwo = new QuaternaryNumber("-2");
        QuaternaryNumber actual = eight.dividedBy(negativeTwo);
        QuaternaryNumber expected = new QuaternaryNumber("-10");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDividedByDivisionFractionalAnswerRoundsDown() {
        QuaternaryNumber ten = new QuaternaryNumber("22");
        QuaternaryNumber three = new QuaternaryNumber("3");
        QuaternaryNumber actual = ten.dividedBy(three);
        QuaternaryNumber expected = new QuaternaryNumber("3");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDividedByDivisionByZeroThrowsException() {
        QuaternaryNumber ten = new QuaternaryNumber("22");
        QuaternaryNumber zero = new QuaternaryNumber("0");
        Assertions.assertThrows(
                ArithmeticException.class,
                () -> ten.dividedBy(zero)
        );
    }



    @Test
    public void testPlusPositiveAddition() {
        QuaternaryNumber first = new QuaternaryNumber("1");
        QuaternaryNumber second = new QuaternaryNumber("2");
        QuaternaryNumber result = first.plus(second);
        QuaternaryNumber expected = new QuaternaryNumber("3");
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testPlusNegativePositiveAddition() {
        QuaternaryNumber first = new QuaternaryNumber("-12");
        QuaternaryNumber second = new QuaternaryNumber("13");
        QuaternaryNumber result = first.plus(second);
        QuaternaryNumber expected = new QuaternaryNumber("1");
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testPlusPositiveNegativeAddition() {
        QuaternaryNumber first = new QuaternaryNumber("13");
        QuaternaryNumber second = new QuaternaryNumber("-11");
        QuaternaryNumber result = first.plus(second);
        QuaternaryNumber expected = new QuaternaryNumber("2");
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testPlusBothNegativeAddition() {
        QuaternaryNumber first = new QuaternaryNumber("-21");
        QuaternaryNumber second = new QuaternaryNumber("-3");
        QuaternaryNumber result = first.plus(second);
        QuaternaryNumber expected = new QuaternaryNumber("-30");
        Assertions.assertEquals(expected,result);
    }



    @Test
    public void testMinusBothPositiveSubtraction() {
        QuaternaryNumber first = new QuaternaryNumber("2");
        QuaternaryNumber second = new QuaternaryNumber("1");
        QuaternaryNumber result = first.minus(second);
        QuaternaryNumber expected = new QuaternaryNumber("1");
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testMinusNegativePositiveSubtraction() {
        QuaternaryNumber first = new QuaternaryNumber("-10");
        QuaternaryNumber second = new QuaternaryNumber("1");
        QuaternaryNumber result = first.minus(second);
        QuaternaryNumber expected = new QuaternaryNumber("-11");
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testMinusPositiveNegativeSubtraction() {
        QuaternaryNumber first = new QuaternaryNumber("22");
        QuaternaryNumber second = new QuaternaryNumber("-2");
        QuaternaryNumber result = first.minus(second);
        QuaternaryNumber expected = new QuaternaryNumber("30");
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testMinusBothNegativeSubtraction() {
        QuaternaryNumber first = new QuaternaryNumber("-1");
        QuaternaryNumber second = new QuaternaryNumber("-21");
        QuaternaryNumber result = first.minus(second);
        QuaternaryNumber expected = new QuaternaryNumber("20");
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testSquareRootInteger(){
        QuaternaryNumber number = new QuaternaryNumber("10");
        QuaternaryNumber result = number.squareRoot();
        QuaternaryNumber expected = new QuaternaryNumber("2");
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testSquareRootRoundedInteger(){
        QuaternaryNumber number = new QuaternaryNumber("13");
        QuaternaryNumber result = number.squareRoot();
        QuaternaryNumber expected = new QuaternaryNumber("2");
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testSquareRootNegativeInteger(){
        QuaternaryNumber number = new QuaternaryNumber("-10");
        Assertions.assertThrows(ArithmeticException.class, number::squareRoot);
    }

    @Test
    public void testSquaredInteger(){
        QuaternaryNumber number = new QuaternaryNumber("2");
        QuaternaryNumber results = number.squared();
        QuaternaryNumber expected = new QuaternaryNumber("10");
        Assertions.assertEquals(expected,results);
    }

    @Test
    public void testSquaredwithNegativeInteger(){
        QuaternaryNumber number = new QuaternaryNumber("-10");
        QuaternaryNumber results = number.squared();
        QuaternaryNumber expected = new QuaternaryNumber("100");
        Assertions.assertEquals(expected,results);
    }
}
