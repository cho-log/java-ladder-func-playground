import controller.LadderController;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderController controller = new LadderController(new OutputView());
        controller.run();
    }
}
