import controller.LadderController;
import domain.ConnectionGenerator;
import domain.LadderFactory;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        LadderFactory ladderFactory = new LadderFactory(new ConnectionGenerator());

        LadderController ladderController = new LadderController(inputView, outputView, ladderFactory);
        ladderController.run();
    }
}
