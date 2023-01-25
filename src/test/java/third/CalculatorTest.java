package third;

import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void answer1() {
        Calculator calculator = new Calculator();
        String expression = "1 + 1";
        Deque<Token> queue = calculator.sortingStation(expression.split(" "));
        double answer = calculator.stackCalculator(queue);
        assertEquals(answer, 2.0);
    }

    @Test
    void answer2() {
        Calculator calculator = new Calculator();
        String expression = "( 1 + 2 ) ^ ( 1 + 2 )";
        Deque<Token> queue = calculator.sortingStation(expression.split(" "));
        double answer = calculator.stackCalculator(queue);
        assertEquals(answer, 27.0);
    }

    @Test
    void answer3() {
        Calculator calculator = new Calculator();
        String expression = "1 / 2 + 36 * 4 ^ ( 1 / 2 )";
        Deque<Token> queue = calculator.sortingStation(expression.split(" "));
        double answer = calculator.stackCalculator(queue);
        assertEquals(answer, 72.5);
    }

}