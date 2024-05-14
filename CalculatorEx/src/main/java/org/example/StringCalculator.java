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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDelimeter() {
        return delimeter;
    }

    public void setDelimeter(String delimeter) {
        this.delimeter = delimeter;
    }

    private boolean isEmptyText(String text) {
        if (text == null || text.isBlank()) {
            return true;
        }
        return false;
    }

    private int validationNumber(String[] tokens) {
        try {
            return Arrays.stream(tokens)
                    .mapToInt(this::stringToInt)
                    .sum();
        } catch (NumberFormatException e) {
            throw new InputException("다시 입력해주세요.");
        }
    }

    private void customSplit(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            setDelimeter(matcher.group(1));
            setText(matcher.group(2));
        }
    }

    public int add(String text) {
        setText(text);
        if (isEmptyText(text)) return 0;  // 유효성 검증으로 입력값 변환 x
        customSplit(text); // text, Delimeter 변동 가능(파라미터 text를 사용하게 되면 값 변환 가능성 있음)
        String[] tokens = getText().split(getDelimeter());
        return validationNumber(tokens);
    }

    private int stringToInt(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new InputException("Negative number detected: " + number);
        }
        return number;
    }
}
