package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public String readOutcomeValues() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
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

    public String readResultTarget() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine().trim();
    }
}
