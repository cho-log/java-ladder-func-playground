import controller.LadderController;
import domain.random.ConnectionGenerator;
import domain.random.RandomConnectionGenerator;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        ConnectionGenerator connectionGenerator = new RandomConnectionGenerator();

        LadderController ladderController = new LadderController(inputView, outputView);
        ladderController.run(connectionGenerator);
    }
}
