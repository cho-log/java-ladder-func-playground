package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readWidth() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return parseToInt(scanner.nextLine(), "넓이");
    }

    public int readHeight() {
        System.out.println("\n사다리의 높이는 몇 개인가요?");
        return parseToInt(scanner.nextLine(), "높이");
    }

    private int parseToInt(String input, String fieldName) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    "사다리의 " + fieldName + "는 정수로 입력해야 합니다."
            );
        }
    }
}
