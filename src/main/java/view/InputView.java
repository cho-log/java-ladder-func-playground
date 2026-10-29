package view;

import domain.LadderHeight;
import domain.LadderWidth;

import java.util.Scanner;

public class InputView {
    public static LadderWidth readWidth(Scanner scanner) {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return new LadderWidth(readInteger(scanner));
    }

    public static LadderHeight readHeight(Scanner scanner) {
        System.out.println("사다리의 높이는 몇 개인가요?");
        return new LadderHeight(readInteger(scanner));
    }

    public static int readInteger(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("크기는 정수로 입력해야 합니다.");
        }
    }
}
