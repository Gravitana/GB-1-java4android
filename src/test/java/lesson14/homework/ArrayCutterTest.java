package lesson14.homework;

import lesson11.test.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCutterTest {
    private ArrayCutter arrayCutter;
    private ArrayList<Integer> input;
    private ArrayList<Integer> result;

    @BeforeEach
    void startUp() {
        arrayCutter = new ArrayCutter();
        input = new ArrayList<>();
        result = new ArrayList<>();
    }

    @Test
    void test1() {
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);

        result.add(5);
        result.add(6);
        result.add(7);

        Assertions.assertEquals(result, arrayCutter.cutAfterNumber(input, 4));
    }

    @Test
    void test2() {
        input.add(3);
        input.add(5);
        input.add(4);
        input.add(6);
        input.add(7);

        result.add(6);
        result.add(7);

        Assertions.assertEquals(result, arrayCutter.cutAfterNumber(input, 4));
    }

    @Test
    void test3() {
        input.add(3);
        input.add(5);
        input.add(6);

        result.add(5);
        result.add(6);
        Assertions.assertThrows(RuntimeException.class, () -> {
            Assertions.assertEquals(result, arrayCutter.cutAfterNumber(input, 4));
        });
    }

    @Test
    void test4() {
        input.add(3);
        input.add(5);
        input.add(4);

        result.add(5);
        result.add(6);
        Assertions.assertThrows(RuntimeException.class, () -> {
            Assertions.assertEquals(result, arrayCutter.cutAfterNumber(input, 4));
        });
    }

}