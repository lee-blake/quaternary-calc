package edu.bsu.cs495.quaternary_calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VirtualDisplay {

    private String keyboardBuffer = "0";
    private boolean displayBase10 = false;

    public void typeDigit(String digit) {
        verifyDigitIsBase4(digit);
        keyboardBuffer += digit;
    }

    private void verifyDigitIsBase4(String possibleDigit) {
        Pattern pattern = Pattern.compile("^[0123]$");
        Matcher matcher = pattern.matcher(possibleDigit);
        if (!matcher.find()) {
            throw new IllegalArgumentException("'" + possibleDigit + "' is not a base 4 digit!");
        }
    }

    public String getDisplayString() {
        if (displayBase10) {
            return new QuaternaryNumber(keyboardBuffer).toDecimalForm();
        } else {
            return new QuaternaryNumber(keyboardBuffer).toString();
        }
    }

    public void toggleBase() {
        displayBase10 = !displayBase10;
    }
}
