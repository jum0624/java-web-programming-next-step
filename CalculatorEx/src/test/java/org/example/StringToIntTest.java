package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringToIntTest {
    @Test
    public void stringToIntTest() throws Exception {
        // given
        String s = ",";

        // when

        // then
        assertThrows(RuntimeException.class, () -> Integer.parseInt(s));
    }
}
