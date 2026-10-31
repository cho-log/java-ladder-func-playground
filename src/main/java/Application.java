import controller.LadderController;
import domain.ladder.ConnectionGenerator;
import domain.ladder.LadderFactory;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        LadderFactory ladderFactory = new LadderFactory(new ConnectionGenerator());

        LadderController ladderController = new LadderController(inputView, ladderFactory);
        ladderController.run();
    }
}
