package lesson14.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void init() { // название может быть любым
        System.out.println("ГЛАВНОЕ НАЧАЛО");
    }

    @AfterAll
    static void end() { // название может быть любым
        System.out.println("ГЛАВНОЕ ОКОНЧАНИЕ");
    }

    @BeforeEach
    void startUp() { // название может быть любым
        System.out.println("Начало теста");
        calculator = new Calculator();
    }

    @AfterEach
    void shutdown() { // название может быть любым
        System.out.println("Конец теста");
    }

    @Test
    void add1() {
        Assertions.assertEquals(3, calculator.add(1, 2));
    }

    @Test
    void add2() {
        Assertions.assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void add3() {
        Assertions.assertEquals(7, calculator.add(3, 3));
    }

    @Test
    void div1() {
        Assertions.assertThrows(ArithmeticException.class, () -> { // ждём ошибку, если она будет, то тест удачный
            Assertions.assertEquals(4, calculator.div(8, 0));
        });
    }

    @Test
    void div2() {
        Assertions.assertTimeout(Duration.ofSeconds(3), () -> { // проверяем, уложится ли тест в определённое время
            Thread.sleep(4000);
            Assertions.assertEquals(4, calculator.div(8, 2));
        });
    }

    /*
        --------- Параметризированный тест ---------
        не сработало с junit-jupiter-api + junit-jupiter-engine
        пришлось грузить просто junit-jupiter
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>

     */

    @DisplayName("Parampampam") // задаёт новое имя для вызова теста
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(int expectedSum, int valA, int valB) {
        Assertions.assertEquals(expectedSum, calculator.add(valA, valB));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(3, 1, 2),
                Arguments.arguments(5, 1, 2),
                Arguments.arguments(4, 2, 2),
                Arguments.arguments(1, 1, 2),
                Arguments.arguments(1, 1, 2),
                Arguments.arguments(-1, 0, -1),
                Arguments.arguments(-2, -1, -1)
        );
    }


}