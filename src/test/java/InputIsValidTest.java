import org.example.InputIsValid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputIsValidTest {
    @Test
    public void testValidInput() {
        assertTrue(InputIsValid.inputIsValid("1 2"));
        assertTrue(InputIsValid.inputIsValid("-1 -2"));
        assertTrue(InputIsValid.inputIsValid("0 0"));
        assertTrue(InputIsValid.inputIsValid("10 -5"));
    }
    @Test
    public void testInvalidInput() {
        assertFalse(InputIsValid.inputIsValid("1"));
        assertFalse(InputIsValid.inputIsValid("1, 2"));
        assertFalse(InputIsValid.inputIsValid("a b"));
        assertFalse(InputIsValid.inputIsValid("1 2 3"));
        assertFalse(InputIsValid.inputIsValid("10.5 -5.5"));
    }
    @Test
    public void testEdgeCases() {
        assertFalse(InputIsValid.inputIsValid(" "));
        assertFalse(InputIsValid.inputIsValid("   "));
        assertFalse(InputIsValid.inputIsValid(""));
    }
}
