import domain.GameResults;
import domain.LadderGame;
import domain.LadderHeight;
import domain.Outcomes;
import domain.Participants;
import domain.RandomConnectionGenerator;
import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Participants participants = InputView.readParticipants(scanner);
        Outcomes outcomes = InputView.readOutcomes(scanner);
        outcomes.validateCount(participants.getWidth());
        LadderHeight height = InputView.readHeight(scanner);
        LadderGame game = new LadderGame(participants, outcomes, height, new RandomConnectionGenerator());
        ResultView.printGame(participants, game.getLadder(), outcomes);
        showResults(scanner, game.getResults());
    }

    private static void showResults(Scanner scanner, GameResults results) {
        while (InputView.hasQuery(scanner)) {
            showResult(scanner, results);
        }
    }

    private static void showResult(Scanner scanner, GameResults results) {
        try {
            ResultView.printResults(InputView.readQuery(scanner), results);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
