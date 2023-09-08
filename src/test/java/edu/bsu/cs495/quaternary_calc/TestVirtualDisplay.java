package edu.bsu.cs495.quaternary_calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVirtualDisplay {

    @Test
    public void testPressDigitThrowsIllegalArgumentExceptionOnNonBase4() {
        VirtualDisplay display = new VirtualDisplay();
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> display.pressDigit("4")
        );
    }

    @Test
    public void testPressDigitDoesNotThrowOnBase4Digits() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("0");
        display.pressDigit("1");
        display.pressDigit("2");
        display.pressDigit("3");
    }

    @Test
    public void testPressDigitDoesNotAcceptMultipleDigits() {
        VirtualDisplay display = new VirtualDisplay();
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> display.pressDigit("01")
        );
    }


    @Test
    public void testGetDisplayStringStartsAsZero() {
        VirtualDisplay display = new VirtualDisplay();
        String actual = display.getDisplayString();
        String expected = "0";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetDisplayStringEchosATypingSequence() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("3");
        display.pressDigit("2");
        display.pressDigit("1");
        display.pressDigit("0");
        String actual = display.getDisplayString();
        String expected = "3210";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetDisplayStringLeadingZerosAreIgnored() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("0");
        display.pressDigit("0");
        display.pressDigit("0");
        display.pressDigit("1");
        String actual = display.getDisplayString();
        String expected = "1";
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testToggleBaseDisplaysBase10After1Call() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("1");
        display.pressDigit("3");
        display.toggleBase();
        String actual = display.getDisplayString();
        String expected = "7";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToggleBaseDisplaysBase10EvenWhenTypingOccursAfterSingleCall() {
        VirtualDisplay display = new VirtualDisplay();
        display.toggleBase();
        display.pressDigit("2");
        display.pressDigit("1");
        String actual = display.getDisplayString();
        String expected = "9";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToggleBaseDisplaysBase4After2Calls() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("3");
        display.pressDigit("2");
        display.toggleBase();
        display.toggleBase();
        String actual = display.getDisplayString();
        String expected = "32";
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testpressUnaryOperatorSquaredDisplaysCorrectly() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("1");
        display.pressDigit("0");
        display.pressUnaryOperator(UnaryOperator.SQUARE);
        String actual = display.getDisplayString();
        String expected = "100";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testpressUnaryOperatorSquareRootDisplaysCorrectly() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("1");
        display.pressDigit("0");
        display.pressUnaryOperator(UnaryOperator.SQUARE_ROOT);
        String actual = display.getDisplayString();
        String expected = "2";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testpressUnaryOperatorTypingAdditionalDigitsImplicitlyClears() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("1");
        display.pressDigit("0");
        display.pressUnaryOperator(UnaryOperator.SQUARE_ROOT);
        display.pressDigit("3");
        String actual = display.getDisplayString();
        String expected = "3";
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testClearEntryClearsEntry() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("1");
        display.pressDigit("0");
        display.clearEntry();
        String actual = display.getDisplayString();
        String expected = "0";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testClearEntryAllowsTypingAfterClearing() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("2");
        display.pressDigit("3");
        display.clearEntry();
        display.pressDigit("3");
        display.pressDigit("3");
        display.pressDigit("0");
        String actual = display.getDisplayString();
        String expected = "330";
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testpressBackspaceOnZeroRetainsZero() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressBackspace();
        String actual = display.getDisplayString();
        String expected = "0";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testpressBackspaceOnSingleDigitTurnsToZero() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("3");
        display.pressBackspace();
        String actual = display.getDisplayString();
        String expected = "0";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testpressBackspaceOnMultipleDigitsOnlyErasesLast() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("3");
        display.pressDigit("2");
        display.pressDigit("1");
        display.pressBackspace();
        String actual = display.getDisplayString();
        String expected = "32";
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testpressEnterAfterSingleNumberContinuesDisplayingThatNumber() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("3");
        display.pressDigit("2");
        display.pressDigit("1");
        display.pressEnter();
        String actual = display.getDisplayString();
        String expected = "321";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testpressEnterAfterSingleNumberImplicitlyClears() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("3");
        display.pressDigit("2");
        display.pressDigit("1");
        display.pressEnter();
        display.pressDigit("2");
        String actual = display.getDisplayString();
        String expected = "2";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testpressEnterCalculationResetsAfterEnter() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("1");
        display.pressBinaryOperator(BinaryOperator.ADDITION);
        display.pressDigit("2");
        display.pressEnter();
        display.pressDigit("2");
        display.pressBinaryOperator(BinaryOperator.MULTIPLICATION);
        display.pressDigit("2");
        display.pressEnter();
        String actual = display.getDisplayString();
        String expected = "10";
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testpressBinaryOperatorDoesAdditionCorrectly() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("1");
        display.pressDigit("3");
        display.pressBinaryOperator(BinaryOperator.ADDITION);
        display.pressDigit("2");
        display.pressEnter();
        String actual = display.getDisplayString();
        String expected = "21";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testpressBinaryOperatorDoesSubtractionCorrectly() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("2");
        display.pressDigit("0");
        display.pressBinaryOperator(BinaryOperator.SUBTRACTION);
        display.pressDigit("3");
        display.pressEnter();
        String actual = display.getDisplayString();
        String expected = "11";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testpressBinaryOperatorDoesMultiplicationCorrectly() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("2");
        display.pressBinaryOperator(BinaryOperator.MULTIPLICATION);
        display.pressDigit("3");
        display.pressEnter();
        String actual = display.getDisplayString();
        String expected = "12";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testpressBinaryOperatorDoesDivisionCorrectly() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("1");
        display.pressDigit("3");
        display.pressBinaryOperator(BinaryOperator.DIVISION);
        display.pressDigit("3");
        display.pressEnter();
        String actual = display.getDisplayString();
        String expected = "2";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testpressBinaryOperatorFollowingOtherBinaryOperatorReplaces() {
        VirtualDisplay display = new VirtualDisplay();
        display.pressDigit("2");
        display.pressBinaryOperator(BinaryOperator.ADDITION);
        display.pressBinaryOperator(BinaryOperator.MULTIPLICATION);
        display.pressDigit("3");
        display.pressEnter();
        String actual = display.getDisplayString();
        String expected = "12";
        Assertions.assertEquals(expected, actual);
    }
}
