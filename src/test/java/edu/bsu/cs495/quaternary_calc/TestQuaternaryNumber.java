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
}
