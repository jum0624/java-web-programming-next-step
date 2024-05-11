package org.example;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private String text;
    private String delimeter;

    public StringCalculator() {
        this.text = null;
        this.delimeter = ":|,";
    }

    private boolean isEmptyText(String text) {
        if (text == null || text.isBlank()) {
            return true;
        }
        return false;
    }

    public int stringToInt(String[] tokens) {
        try {
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .filter(number -> number >= 0)
                    .sum();
        } catch (NumberFormatException e) {
            throw new InputException("0 이상의 양수를 입력해주세요.");
        }
    }

    public void customSplit(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            this.delimeter = matcher.group(1);
            this.text = matcher.group(2);
        }
    }

    public int add(String text) {
        if (isEmptyText(text)) return 0;
        customSplit(text);
        String[] tokens = this.text.split(delimeter);
        return stringToInt(tokens);
    }
}
