package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    public void setup() {
        stringCalculator = new StringCalculator();
    }


    @Test
    @DisplayName("입력한 값이 null이거나 빈 문자열이라면 0반환")
    public void inputNullStringTest() throws Exception {
        // given
        String text1 = "";
        String text2 = " ";
        String text3 = null;
        
        // when
        int emptyText1 = stringCalculator.add(text1);
        int emptyText2 = stringCalculator.add(text2);
        int emptyText3 = stringCalculator.add(text3);


        // then
        assertEquals(0, emptyText1);
        assertEquals(0, emptyText2);
        assertEquals(0, emptyText3);
    }
    
    @Test
    @DisplayName("입력한 값이 숫자만 입력한 문자열이라면 숫자로 변환 후 반환")
    public void numberStringAddTest() throws Exception {
        // given
        String text1 = "12";
        String text2 = "1";
        String text3 = "999";
        
        // when
        int test1 = stringCalculator.add(text1);
        int test2 = stringCalculator.add(text2);
        int test3 = stringCalculator.add(text3);

        // then
        assertEquals(12, test1);
        assertEquals(1, test2);
        assertEquals(999, test3);
    }

    @Test
    @DisplayName("커스텀하지 않은 구분자로 입력한 경우, 해당 구분자를 기준으로 구분하기")
    public void notCustomStringAddTest() throws Exception {
        // given
        String text1 = "1,2,3";
        String text2 = "1:2:3";
        String text3 = "1,2:3";

        // when
        int result1 = stringCalculator.add(text1);
        int result2 = stringCalculator.add(text2);
        int result3 = stringCalculator.add(text3);

        // then
        assertEquals(6, result1);
        assertEquals(6, result2);
        assertEquals(6, result3);
    }

    @Test
    @DisplayName("커스텀한 구분자로 입력한 경우, 해당 구분자를 기준으로 구분하기")
    public void customStringAddTest() throws Exception {
        // given
        String text1 = "//;\n1;2;3";
        String text2 = "///\n1/2/3";

        // when
        int result1 = stringCalculator.add(text1);
        int result2 = stringCalculator.add(text2);

        // then
        assertEquals(6, result1);
        assertEquals(6, result2);
    }
    
    @Test
    @DisplayName("구분자를 기준으로 숫자가 아닌 다른 문자를 입력한 경우 예외를 발생 시킨다.")
    public void checkInputStringToIntExceptionTest() throws Exception {
        // given
        String text1 = "i,j,2";
        String text2 = "#,3,4";
        
        // when


        // then
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text1));
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text2));
    }

    @Test
    @DisplayName("커스텀 구분자 지정을 잘못 지정하여 입력한 경우 예외 처리")
    public void customInputExceptionTest() throws Exception {
        // given
        String text = "::i\n1i2i3";

        // when


        // then
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text));
    }

    @Test
    @DisplayName("기본 구분자가 아닌 다른 구분자를 커스텀 지정 없이 입력한 경우 예외처리")
    public void basicDelimeterInputExceptionTest1() throws Exception {
        // given
        String text1 = "1.2.3";
        String text2 = "1@3^4";

        // when


        // then
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text1));
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text2));
    }

    @Test
    @DisplayName("기본 구분자 이외에 다른 구분자를 혼합하여 입력한 경우 예외처리")
    public void basicDelimeterInputExceptionTest2() throws Exception {
        // given
        String text1 = "1,2*3";
        String text2 = "2:3,4*5";

        // when


        // then
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text1));
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text2));

    }

    @Test
    @DisplayName("구분자 사이에 공백 넣어 입력한 경우 예외처리")
    public void inputBlankExceptionTest() throws Exception {
        // given
        String text1 = "1, 2, 3";
        String text2 = "1 , 2 , 3";

        // when


        // then
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text1));
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text2));
    }

    @Test
    @DisplayName("음수를 입력한 경우 예외처리")
    public void inputNegativeNumberExceptionTest() throws Exception {
        // given
        String text1 = "1,2,-3";
        String text2 = "-1,-2,-3";

        // when


        // then
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text1));
        assertThrows(RuntimeException.class, () -> stringCalculator.add(text2));
    }

}