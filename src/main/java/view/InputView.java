package view;

import domain.LadderHeight;
import domain.LadderWidth;
import domain.Outcomes;
import domain.Participants;
import domain.ResultQuery;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static Participants readParticipants(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Participants(readValues(scanner));
    }

    public static Outcomes readOutcomes(Scanner scanner) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new Outcomes(readValues(scanner));
    }

    private static List<String> readValues(Scanner scanner) {
        return Arrays.asList(scanner.nextLine().split(",", -1));
    }

    public static LadderHeight readHeight(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new LadderHeight(readInteger(scanner));
    }

    public static int readInteger(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("크기는 정수로 입력해야 합니다.");
        }
    }

    public static boolean hasQuery(Scanner scanner) {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.hasNextLine();
    }

    public static ResultQuery readQuery(Scanner scanner) {
        return new ResultQuery(scanner.nextLine());
    }

    public static LadderWidth readWidth(Scanner scanner) {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return new LadderWidth(readInteger(scanner));
    }
}
