package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitTest {
    @Test
    @DisplayName("숫자 하나만 문자열로 입력한 경우, 해당 숫자를 반환한다.")
    public void inputOneNumberStringTest() throws Exception {
        // given
        String text = "1";

        // when
        String[] split = text.split(",");
        int sum = Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();

        // then
        assertEquals(1, sum);
    }

    @Test
    @DisplayName(", 구분자를 통해 입력할 경우, 구분자를 기준으로 합을 계산한다.")
    public void inputStringSplitTest() throws Exception {
        // given
        String text = "1,2";


        // when
        String[] split = text.split(",");
        int sum = Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();

        // then
        assertEquals(3, sum);
    }

    @Test
    @DisplayName(", 또는 : 으로 구분자를 통해 입력했을 때, 해당 문자열을 기준으로 합을 계산한다.")
    public void inputStringSplitTest2() throws Exception {
        // given
        String text = "1,2:3";


        // when
        String[] split = text.split(",|:");
        int sum = Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();

        // then
        assertEquals(6, sum);
    }

    @Test
    @DisplayName("//와 \n 사이에 구분자를 입력하여 커스텀한 경우, 해당 구분자를 기준으로 합을 구한다.")
    public void inputCustomStringSplitTest() throws Exception {
        // given
        String text = "//;\n2;3";

        // when
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        int sum = 0;
        if (matcher.find()) {  // 패턴이 일치한 문자열이 있다면
            String customDelimeter = matcher.group(1);
            String[] split = matcher.group(2).split(customDelimeter);

            sum = Arrays.stream(split)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        // then
        assertEquals(5, sum);
    }

}
