package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private String delimeter;

    private final String basicDelimeter = ":|,";
    private final String customRegex = "//(.)\n(.*)";

    public StringCalculator() {
        this.delimeter = basicDelimeter;
    }

    public int add(String text) {
        if (isEmptyText(text)) return 0;
        return sum(stringToInt(split(getDelimeter(text))));
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += toPositive(numbers[i]);
        }
        return sum;
    }


    private int toPositive(int number) {
        if (number < 0) {
            throw new RuntimeException("0이상의 숫자를 입력하세요.");
        }
        return number;
    }

    private int[] stringToInt(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }

    private String[] split(String text) {
        return text.split(delimeter);
    }

    private String getDelimeter(String text) {
        Matcher matcher = Pattern.compile(customRegex).matcher(text);
        if (matcher.find()) {
            this.delimeter = matcher.group(1);
            text = matcher.group(2);
        }
        return text;
    }

    private boolean isEmptyText(String text) {
        return text == null || text.isBlank();
    }
}
