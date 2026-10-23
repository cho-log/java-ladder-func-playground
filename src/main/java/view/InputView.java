package view;

import domain.LadderSize;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public LadderSize readWidth() {
        return read(MessageFormat.INPUT_WIDTH);
    }

    public LadderSize readHeight() {
        return read(MessageFormat.INPUT_HEIGHT);
    }

    private LadderSize read(MessageFormat question) {
        System.out.println(question.message());
        LadderSize size = new LadderSize(Integer.parseInt(scanner.nextLine()));
        System.out.println();
        return size;
    }
}
