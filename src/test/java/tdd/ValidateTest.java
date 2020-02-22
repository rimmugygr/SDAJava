package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

    Validate validate;

    @Test
    void shouldReturnTrueForValidPostCode() {
        assertEquals(validate.validatePostCode("12-123"),true);
        assertEquals(validate.validatePostCode("32-343"),true);
        assertEquals(validate.validatePostCode("99-999"),true);
    }

    @Test
    void shouldReturnFalseForInvalidPostCode() {
        assertEquals(validate.validatePostCode("null"),false);
        assertEquals(validate.validatePostCode("aa-aaa"),false);
        assertEquals(validate.validatePostCode("aaaaa"),false);
        assertEquals(validate.validatePostCode(""),false);
        assertEquals(validate.validatePostCode(null),false);
        assertEquals(validate.validatePostCode("12345"),false);
        assertEquals(validate.validatePostCode("12-1y3"),false);
        assertEquals(validate.validatePostCode("00-000"),false);
    }



}