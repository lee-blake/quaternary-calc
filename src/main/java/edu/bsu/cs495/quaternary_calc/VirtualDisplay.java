package edu.bsu.cs495.quaternary_calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VirtualDisplay {

    private String keyboardBuffer = "0";
    private boolean lastKeyPressedWasBinaryOperator = false;

    private boolean displayNaN = false;
    private QuaternaryNumber displayValue = new QuaternaryNumber("0");
    private boolean displayBase10 = false;

    private final QuaternaryCalculator calculator = new QuaternaryCalculator();

    public void pressDigit(String digit) {
        verifyDigitIsBase4(digit);
        keyboardBuffer += digit;
        updateDisplayValue();
        lastKeyPressedWasBinaryOperator = false;
    }

    private void verifyDigitIsBase4(String possibleDigit) {
        Pattern pattern = Pattern.compile("^[0123]$");
        Matcher matcher = pattern.matcher(possibleDigit);
        if (!matcher.find()) {
            throw new IllegalArgumentException("'" + possibleDigit + "' is not a base 4 digit!");
        }
    }

    private void updateDisplayValue() {
        displayValue = new QuaternaryNumber(keyboardBuffer);
        displayNaN = false;
    }

    public void pressUnaryOperator(UnaryOperator operator) {
        if (operator == UnaryOperator.SQUARE) {
            displayValue = displayValue.squared();
        }
        else {
            try {
                displayValue = displayValue.squareRoot();
            } catch (ArithmeticException e) {
                displayNaN = true;
            }
        }
        clearTypedInputButKeepDisplay();
        lastKeyPressedWasBinaryOperator = false;
    }

    private void clearTypedInputButKeepDisplay() {
        keyboardBuffer = "0";
    }

    public void pressBinaryOperator(BinaryOperator operator) {
        if (!lastKeyPressedWasBinaryOperator) {
            clearTypedInputButKeepDisplay();
            calculator.submitBinaryOperation(displayValue, operator);
            lastKeyPressedWasBinaryOperator = true;
        }
        else {
            calculator.replaceLastBinaryOperation(operator);
        }
    }

    public void pressEnter() {
        clearTypedInputButKeepDisplay();
        try {
            displayValue = calculator.evaluate(displayValue);
        } catch (ArithmeticException e) {
            displayNaN = true;
        }
        calculator.reset();
        lastKeyPressedWasBinaryOperator = false;
    }

    public void pressBackspace() {
        int bufferLength = keyboardBuffer.length();
        if (bufferLength == 1) {
            keyboardBuffer = "0";
        }
        else {
            keyboardBuffer = keyboardBuffer.substring(0, bufferLength - 1);
        }
        updateDisplayValue();
        lastKeyPressedWasBinaryOperator = false;
    }

    public void clearEntry() {
        keyboardBuffer = "0";
        updateDisplayValue();
        lastKeyPressedWasBinaryOperator = false;
    }

    public void clearAll() {
        clearEntry();
        calculator.reset();
    }

    public void toggleBase() {
        displayBase10 = !displayBase10;
    }

    public String getDisplayString() {
        if (displayNaN) {
            return "NaN";
        }
        else if (displayBase10) {
            return displayValue.toDecimalForm();
        }
        else {
            return displayValue.toString();
        }
    }

    public boolean isBase10() {
        return displayBase10;
    }
}
