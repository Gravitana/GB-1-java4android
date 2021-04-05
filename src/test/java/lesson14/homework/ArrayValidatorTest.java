package lesson14.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorTest {
    private ArrayValidator arrayValidator;
    private ArrayList<Integer> numbers;

    @BeforeEach
    void startUp() {
        arrayValidator = new ArrayValidator();
        numbers = new ArrayList<>();
    }

    @Test
    void has1and4test1() {
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(4);
        numbers.add(4);
        numbers.add(1);
        numbers.add(4);
        numbers.add(4);

        assertTrue(arrayValidator.has1and4(numbers));
    }

    @Test
    void has1and4test2() {
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);

        assertFalse(arrayValidator.has1and4(numbers));
    }

    @Test
    void has1and4test3() {
        numbers.add(4);
        numbers.add(4);
        numbers.add(4);
        numbers.add(4);

        assertFalse(arrayValidator.has1and4(numbers));
    }

    @Test
    void has1and4test4() {
        numbers.add(1);
        numbers.add(4);
        numbers.add(4);
        numbers.add(1);
        numbers.add(1);
        numbers.add(4);
        numbers.add(3);

        assertFalse(arrayValidator.has1and4(numbers));
    }
}