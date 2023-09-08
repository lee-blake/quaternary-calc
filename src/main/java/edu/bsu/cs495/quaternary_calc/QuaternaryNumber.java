package edu.bsu.cs495.quaternary_calc;

//import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuaternaryNumber {

    private final int decimalValue;

    public QuaternaryNumber(String quaternaryString) {
        verifyStringIsAQuaternaryNumber(quaternaryString);
        this.decimalValue = parseQuaternaryNumberFromString(quaternaryString);
    }

    private QuaternaryNumber(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    private void verifyStringIsAQuaternaryNumber(String possibleNumber) {
        Pattern pattern = Pattern.compile("^-?[0123]+$");
        Matcher matcher = pattern.matcher(possibleNumber);
        if (!matcher.find()) {
            throw new IllegalArgumentException("'" + possibleNumber + "' is not a quaternary number!");
        }
    }

    private int parseQuaternaryNumberFromString(String quaternaryString) {
        int total = 0;
        int multiplier = 1;
        while (!quaternaryString.equals("-") && !quaternaryString.equals("")) {
            int lastDigit = Integer.parseInt(quaternaryString.substring(quaternaryString.length() - 1));
            total += multiplier * lastDigit;
            multiplier *= 4;
            quaternaryString = quaternaryString.substring(0, quaternaryString.length() - 1);
        }
        if (quaternaryString.equals("-")) {
            total *= -1;
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder representation = new StringBuilder();
        int remainingValue = Math.abs(decimalValue);
        do {
            representation.insert(0, remainingValue % 4);
            remainingValue /= 4;
        } while (remainingValue != 0);
        if (decimalValue < 0) {
            representation.insert(0, "-");
        }
        return representation.toString();
    }

    public String toDecimalForm() {
        return String.valueOf(this.decimalValue);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof QuaternaryNumber otherNumber) {
            return this.decimalValue == otherNumber.decimalValue;
        }
        return false;
    }

    public QuaternaryNumber times(QuaternaryNumber otherNumber) {
        return new QuaternaryNumber(this.decimalValue * otherNumber.decimalValue);
    }

    public QuaternaryNumber dividedBy(QuaternaryNumber otherNumber) {
        return new QuaternaryNumber(this.decimalValue / otherNumber.decimalValue);
    }

    public QuaternaryNumber plus(QuaternaryNumber otherNumber) {
        return new QuaternaryNumber(this.decimalValue + otherNumber.decimalValue);
    }

    public QuaternaryNumber minus(QuaternaryNumber otherNumber) {
        return new QuaternaryNumber(this.decimalValue - otherNumber.decimalValue);
    }

    public QuaternaryNumber squareRoot() {
        if (decimalValue < 0) {
            throw new ArithmeticException();
        }
        return new QuaternaryNumber((int) Math.sqrt(this.decimalValue));
    }

    public QuaternaryNumber squared() {
        return this.times(this);
    }

}
