package view;

import domain.LadderSize;
import domain.Names;
import domain.Prizes;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public Names readNames() {
        return Names.from(readLine(MessageFormat.INPUT_NAMES));
    }

    public Prizes readPrizes() {
        return Prizes.from(readLine(MessageFormat.INPUT_PRIZES));
    }

    public LadderSize readHeight() {
        return new LadderSize(parseNumber(readLine(MessageFormat.INPUT_HEIGHT)));
    }

    public String readTarget() {
        return readLine(MessageFormat.INPUT_TARGET);
    }

    private String readLine(MessageFormat question) {
        System.out.println(question.message());
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
