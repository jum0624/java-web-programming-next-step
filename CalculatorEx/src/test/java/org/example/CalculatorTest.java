package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator cal;

    @BeforeEach
    public void before() throws Exception {
        cal = new Calculator();
    }

    @Test
    void sum() {
        assertEquals(3, cal.sum(1, 2));
    }

    @Test
    void sub() {
        assertEquals(4, cal.sub(6,2));
    }

    @Test
    void mul() {
        assertEquals(12, cal.mul(3,4));
    }

    @Test
    void div() {
        assertEquals(6, cal.div(18, 3));
    }
}