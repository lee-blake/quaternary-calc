package edu.bsu.cs495.quaternary_calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VirtualDisplay {

    private String keyboardBuffer = "0";
    private QuaternaryNumber displayValue = new QuaternaryNumber("0");
    private boolean displayBase10 = false;
    private final QuaternaryCalculator calculator = new QuaternaryCalculator();
    private boolean binaryOperatorInCalculator = false;
    private boolean lastKeyPressedWasBinaryOperator = false;

    public void typeDigit(String digit) {
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
    }

    public String getDisplayString() {
        if (displayBase10) {
            return displayValue.toDecimalForm();
        } else {
            return displayValue.toString();
        }
    }

    public void toggleBase() {
        displayBase10 = !displayBase10;
    }

    public void typeUnaryOperator(UnaryOperator operator) {
        if (operator == UnaryOperator.SQUARE) {
            displayValue = displayValue.squared();
        } else {
            displayValue = displayValue.squareRoot();
        }
        clearTypedInputButKeepDisplay();
        lastKeyPressedWasBinaryOperator = false;
    }

    private void clearTypedInputButKeepDisplay() {
        keyboardBuffer = "0";
    }

    public void clearEntry() {
        keyboardBuffer = "0";
        updateDisplayValue();
        lastKeyPressedWasBinaryOperator = false;
    }

    public void typeBackspace() {
        int bufferLength = keyboardBuffer.length();
        if (bufferLength == 1) {
            keyboardBuffer = "0";
        } else {
            keyboardBuffer = keyboardBuffer.substring(0, bufferLength - 1);
        }
        updateDisplayValue();
        lastKeyPressedWasBinaryOperator = false;
    }

    public void typeEnter() {
        clearTypedInputButKeepDisplay();
        displayValue = calculator.evaluate(displayValue);
        calculator.reset();
        lastKeyPressedWasBinaryOperator = false;
        binaryOperatorInCalculator = false;
    }

    public void typeBinaryOperator(BinaryOperator operator) {
        if (!lastKeyPressedWasBinaryOperator && !binaryOperatorInCalculator) {
            clearTypedInputButKeepDisplay();
            calculator.submitBinaryOperation(displayValue, operator);
            lastKeyPressedWasBinaryOperator = true;
            binaryOperatorInCalculator = true;
        } else if (lastKeyPressedWasBinaryOperator) {
            calculator.replaceLastBinaryOperation(operator);
        }
    }
}
