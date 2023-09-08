package edu.bsu.cs495.quaternary_calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VirtualDisplay {

    private String keyboardBuffer = "0";

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
        return new QuaternaryNumber(keyboardBuffer).toString();
    }
}
