package edu.bsu.cs495.quaternary_calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVirtualDisplay {

    @Test
    public void testTypeDigitThrowsIllegalArgumentExceptionOnNonBase4() {
        VirtualDisplay display = new VirtualDisplay();
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> display.typeDigit("4")
        );
    }

    @Test
    public void testTypeDigitDoesNotThrowOnBase4Digits() {
        VirtualDisplay display = new VirtualDisplay();
        display.typeDigit("0");
        display.typeDigit("1");
        display.typeDigit("2");
        display.typeDigit("3");
    }

    @Test
    public void testTypeDigitDoesNotAcceptMultipleDigits() {
        VirtualDisplay display = new VirtualDisplay();
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> display.typeDigit("01")
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
        display.typeDigit("3");
        display.typeDigit("2");
        display.typeDigit("1");
        display.typeDigit("0");
        String actual = display.getDisplayString();
        String expected = "3210";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetDisplayStringLeadingZerosAreIgnored() {
        VirtualDisplay display = new VirtualDisplay();
        display.typeDigit("0");
        display.typeDigit("0");
        display.typeDigit("0");
        display.typeDigit("1");
        String actual = display.getDisplayString();
        String expected = "1";
        Assertions.assertEquals(expected, actual);
    }
}
