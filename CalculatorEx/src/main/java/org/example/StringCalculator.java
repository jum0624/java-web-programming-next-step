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
                    .mapToInt(token -> {
                        int number = Integer.parseInt(token);
                        if (number < 0) {
                            throw new InputException("Negative number detected: " + number);
                        }
                        return number;
                    })
                    .sum();
        } catch (NumberFormatException e) {
            throw new InputException("다시 입력해주세요.");
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
        this.text = text;
        // 초기화를 여기서 하는게 맞을까...? 이렇게 된다면 객체 생성 시, text = null로 초기화 할 필요가 있나..? 계속 add를 선언할 때마다 값을 바뀔텐데..
        if (isEmptyText(text)) return 0;
        customSplit(text);
        String[] tokens = this.text.split(delimeter);
        return stringToInt(tokens);
    }
}
