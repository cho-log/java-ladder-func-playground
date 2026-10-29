public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderFactory ladderFactory;

    public LadderController(InputView inputView, OutputView outputView, LadderFactory ladderFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderFactory = ladderFactory;
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

        Ladder ladder = ladderFactory.createLadder(width, height);
        LadderResults results = new LadderResults(width, ladder);

        outputView.printLadder(ladder);
        outputView.printResult(results);
    }
}
