import domain.Ladder;
import domain.LadderHeight;
import domain.LadderWidth;
import domain.RandomConnectionGenerator;
import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LadderWidth width = InputView.readWidth(scanner);
        LadderHeight height = InputView.readHeight(scanner);
        Ladder ladder = new Ladder(width, height, new RandomConnectionGenerator());
        ResultView.print(ladder);
        ResultView.printPaths(ladder.getPaths());
    }
}
