import controller.LadderController;
import domain.random.ConnectionGenerator;
import domain.random.RandomConnectionGenerator;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        ConnectionGenerator connectionGenerator = new RandomConnectionGenerator();

        LadderController ladderController = new LadderController(outputView, connectionGenerator);
        ladderController.run();
    }
}
