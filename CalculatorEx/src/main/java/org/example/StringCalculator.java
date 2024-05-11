package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        try {
            int number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            String[] split = text.split(",|:");
            Matcher matcher = Pattern.compile("//(.*?)\\n", Pattern.DOTALL).matcher(text);  // "//"와 "\n" 사이의 값 추출

        }
        return 0;
    }
}
