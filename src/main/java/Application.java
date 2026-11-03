import domain.LadderGame;
import domain.connection.RandomConnectionGenerator;
import domain.ladder.LadderHeight;
import domain.participant.Participants;
import domain.result.GameResults;
import domain.result.Outcomes;

import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Participants participants = InputView.readParticipants(scanner);
        Outcomes outcomes = Outcomes.of(participants.getWidth(), InputView.readOutcomes(scanner));
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
