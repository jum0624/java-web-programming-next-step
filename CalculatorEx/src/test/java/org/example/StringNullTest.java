package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringNullTest {
    @Test
    @DisplayName("빈 문자열 입력 시, 결과값으로 0을 반환한다.")
    public void inputNullStringTest1() throws Exception {
        // given
        String text = "";
        int result = -1;

        // when
        if (text == null || text.isBlank()) {
            result = 0;
        }

        // then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("입력 시, null일 경우 결과값으로 0을 반환한다.")
    public void inputNullStringTest2() throws Exception {
        // given
        String text = null;
        int result = -1;

        // when
        if (text == null || text.isBlank()) {
            result = 0;
        }

        // then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("공백 문자열 입력 시, 결과값으로 0을 반환한다.")
    public void inputNullStringTest3() throws Exception {
        // given
        String text = " ";
        int result = -1;

        // when
        if (text == null || text.isBlank()) {
            result = 0;
        }

        // then
        assertEquals(0, result);
    }
}
