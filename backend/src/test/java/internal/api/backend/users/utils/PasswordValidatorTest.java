package internal.api.backend.users.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static internal.api.backend.users.utils.PasswordValidator.*;

class PasswordValidatorTest {

    String EMPTY = "";
    String[] LESS_THAN_EIGHT_CHARS = {"1", "1234", "random", "non empty", "1a@AqqA", "ADad1!"};
    String[] MISSING_COMPONENTS = {"1Aafillerword", "!Aafillerword", "1!afillerword", "1!AFILLERWORD"};
    String[] CONTAINS_SPACES = {" 1Aa!PASSWORD", "P ASSWORD!Q2a", "equ1 Q!2Q!", "1!Aa fill"};
    String[] VALID_PASSWORD = {"1Aa!PASSWORD", "PASSWORD!Q2a", "equ1Q!2Q!", "1!Aafill"};

    @Test
    void passwordMustBeAtLeast8Chars(){
        assertFalse(containsRequiredComponents(EMPTY));
        for (String str : LESS_THAN_EIGHT_CHARS) {
            assertFalse(containsRequiredComponents(str));
        }
    }

    @Test
    void mustContainAllComponents(){
        for (String str : MISSING_COMPONENTS) {
            assertFalse(containsRequiredComponents(str));
        }
    }

    @Test
    void cannotContainSpaces(){
        for (String str : CONTAINS_SPACES) {
            assertFalse(containsRequiredComponents(str));
        }
    }

    @Test
    void trueForValidPasswords(){
        for (String str : VALID_PASSWORD) {
            assertTrue(containsRequiredComponents(str));
        }
    }
}