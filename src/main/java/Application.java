import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        ConnectionGenerator connectionGenerator = new ConnectionGenerator();
        LadderFactory ladderFactory = new LadderFactory(connectionGenerator);

        LadderController ladderController = new LadderController(inputView, outputView, ladderFactory);
        ladderController.run();
    }
}
