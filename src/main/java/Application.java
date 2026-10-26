import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        LadderController ladderController = new LadderController(inputView, outputView);
        ladderController.run();
    }
}
