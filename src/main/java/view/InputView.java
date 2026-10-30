package view;

import exception.ErrorMessage;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getWidth() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return parseNumber(scanner.nextLine(), ErrorMessage.WIDTH_IS_NOT_INTEGER.getMessage());
    }

    public int getHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        return parseNumber(scanner.nextLine(), ErrorMessage.HEIGHT_IS_NOT_INTEGER.getMessage());
    }

    private int parseNumber(String input, String errorMessage) {
        try {
            return Integer.parseInt(input.trim());
        }  catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
