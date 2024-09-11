package telran.util;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.RecursionMethods.*;

import org.junit.jupiter.api.Test;

public class RecursionMethodsTest {

    @Test
    void ftest() {
        f(4);
    }

    @Test
    void factorialTest() {
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
        assertEquals(6, factorial(-3));
    }

    @Test
    void powTest() {
        assertEquals(10, pow(10, 1));
        assertEquals(100, pow(10, 2));
        assertEquals(100, pow(-10, 2));
        assertEquals(1000, pow(10, 3));
        assertEquals(-1000, pow(-10, 3));
        assertThrowsExactly(IllegalArgumentException.class, () -> pow(10, -3));
    }

    @Test
    void sumTest() {
        int[] ar = {1, 2, 3, 4, 5};
        assertEquals(15, sum(ar));
    }

    @Test
    void squareTest() {
        assertEquals(1, square(1));
        assertEquals(4, square(2));
        assertEquals(9, square(3));
        assertEquals(100, square(10));
        assertEquals(100, square(-10));
        assertEquals(10000, square(100));
    }

    @Test
    void isSubstringTest() {
        assertTrue(isSubstring("My string", " stri"));
        assertFalse(isSubstring("My string", " Stri"));
        assertTrue(isSubstring("My string", "My"));
        assertTrue(isSubstring("My string", "ng"));
        assertTrue(isSubstring("dfdf kjfj38t er45345", "r4"));
        assertFalse(isSubstring("dfdf kjfj38t er45345", "ddd"));
        assertFalse(isSubstring("dfdf kjfj38t er45345", ""));
        assertFalse(isSubstring("", "ddd"));
        assertFalse(isSubstring("", ""));
    }

}
