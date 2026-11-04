package view;

import exception.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return toList(scanner.nextLine());
    }

    public List<String> readPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return toList(scanner.nextLine());
    }

    public String readTargetName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine().trim();
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return parseNumber(scanner.nextLine(), ErrorMessage.HEIGHT_IS_NOT_INTEGER.getMessage());
    }

    private int parseNumber(String input, String errorMessage) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private List<String> toList(String line) {
        return Arrays.stream(line.split(",", -1))
                .map(String::trim)
                .toList();
    }
}
