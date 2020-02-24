package tdd;

import lombok.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

    Validate validate;

    @Test
    void shouldReturnTrueForValidPostCode() {
        assertEquals(validate.validatePostCode("12-123"),true);
        assertEquals(validate.validatePostCode("32-343"),true);
        assertEquals(validate.validatePostCode("99-999"),true);
    }

    @ParameterizedTest
    @ValueSource(strings={"12-123","32-343","99-999"})
    void shouldReturnTrueForValidPostCode(String codeToTest) {
        assertEquals(validate.validatePostCode(codeToTest),true);
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

    @ParameterizedTest
    @ValueSource(strings = {"null","aa-aaa","aaaaa","","12345","12-1y3","00-000"})
    @NullSource
    @NullAndEmptySource
    void shouldReturnFalseForInvalidPostCode(String codeToTest) {
        assertEquals(validate.validatePostCode(codeToTest),false);
    }


}