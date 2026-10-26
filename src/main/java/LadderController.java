public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            runApp();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    public void runApp() {
        Width width = new Width(inputView.readWidth());
        Height height = new Height(inputView.readHeight());
        Ladder ladder = new Ladder(width, height);
        outputView.printLadder(ladder);
    }
}
