package org.example.home7.model.calculation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumber {

    private static final Pattern SIGN_PATTERN = Pattern.compile("[+-]");
    private static final Pattern IMAGINARY_PATTERN = Pattern.compile("i");

    private final Double real;
    private final Double imaginary;

    public ComplexNumber() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    public ComplexNumber(Double real, Double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /*
        1
        -1
        1+2i
        1-2i
        -1+2i
        -1-2i
        1i
        -1i
        1i
        2i+2
        2i-2
        -2i+2
        -2i-2
     */
    public ComplexNumber(String expression) {
        if (expression == null || expression.equals("")) {
            throw new IllegalArgumentException("Expression must not be null!");
        }

        try {
            String cleanExpression = expression.replace(" ", "");
            Matcher matcher = SIGN_PATTERN.matcher(cleanExpression);
            if (matcher.find()) {
                int end = matcher.end();
                //there is only one value
                if (end == 1 && !matcher.find()) {
                    Matcher imgMatcher = IMAGINARY_PATTERN.matcher(cleanExpression);
                    if (imgMatcher.find()) {
                        this.real = 0.0;
                        this.imaginary = Double.parseDouble(cleanExpression.substring(0, cleanExpression.length() - 1));
                    } else {
                        this.real = Double.parseDouble(cleanExpression);
                        this.imaginary = 0.0;
                    }
                } else {
                    end = matcher.end();
                    String firstPart = cleanExpression.substring(0, matcher.end() - 1);
                    String secondPart = cleanExpression.substring(end - 1);
                    Matcher imgMatcher = IMAGINARY_PATTERN.matcher(firstPart);
                    if (imgMatcher.find()) {
                        this.real = Double.parseDouble(secondPart);
                        this.imaginary =  Double.parseDouble(firstPart.substring(0, firstPart.length() - 1));
                    } else {
                        this.real = Double.parseDouble(firstPart);
                        this.imaginary =  Double.parseDouble(secondPart.substring(0, secondPart.length() - 1));
                    }
                }
            } else {
              //again only one value from possible
                Matcher imgMatcher = IMAGINARY_PATTERN.matcher(cleanExpression);
                if (imgMatcher.find()) {
                    this.real = 0.0;
                    this.imaginary = Double.parseDouble(cleanExpression.substring(0, cleanExpression.length() - 1));
                } else {
                    this.real = Double.parseDouble(cleanExpression);
                    this.imaginary = 0.0;
                }
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Broken expression! %s".formatted(expression));
        }
    }

    public Double getReal() {
        return real;
    }

    public Double getImaginary() {
        return imaginary;
    }

    public ComplexNumber plus(ComplexNumber another) {
        return new ComplexNumber(this.real + another.real, this.imaginary + another.imaginary);
    }

    public ComplexNumber minus(ComplexNumber another) {
        return new ComplexNumber(this.real - another.real, this.imaginary - another.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber another) {
        double r = this.real * another.real - this.imaginary * another.imaginary;
        double i = this.real * another.imaginary + this.imaginary * another.real;
        return new ComplexNumber(r, i);
    }

    public ComplexNumber divide(ComplexNumber another) {
        return this.multiply(another.reciprocal());
    }

    public ComplexNumber reciprocal() {
        double scale = real * real + imaginary * imaginary;
        return new ComplexNumber(real / scale, -imaginary / scale);
    }

    public String print() {
        if (imaginary == 0) return real + "";
        if (real == 0) return imaginary + "i";
        if (imaginary <  0) return real + " - " + (-imaginary) + "i";
        return real + " + " + imaginary + "i";
    }
}
