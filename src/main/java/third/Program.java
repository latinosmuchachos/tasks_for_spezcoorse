package third;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите выражение: ");
        String input_expression = console.nextLine();

        Calculator calculator = new Calculator();
        calculator.answer(input_expression);
    }
}
