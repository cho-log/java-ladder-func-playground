package domain.game;

import domain.outcome.Outcome;
import domain.outcome.Outcomes;
import domain.participant.Participant;
import domain.participant.Participants;
import domain.ladder.LadderResults;
import domain.ladder.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults(
            Participants participants,
            Outcomes outcomes,
            LadderResults ladderResults
    ) {
        validateResults(participants, outcomes, ladderResults);
        this.gameResults = calculateGameResults(participants, outcomes, ladderResults);
    }

    private void validateResults(Participants participants, Outcomes outcomes, LadderResults ladderResults) {
        if (participants.getSize() != outcomes.getSize() ||
                participants.getSize() != ladderResults.size()) {
            throw new IllegalArgumentException("참여자 수와 결과 수가 같아야 합니다.");
        }
    }

    private List<GameResult> calculateGameResults(
            Participants participants,
            Outcomes outcomes,
            LadderResults ladderResults
    ) {
        return IntStream.range(0, participants.getSize())
                        .mapToObj(Position::new)
                        .map(start -> createGameResult(start, participants, outcomes, ladderResults))
                        .collect(Collectors.toUnmodifiableList());
    }

    private GameResult createGameResult(
            Position start, Participants participants, Outcomes outcomes, LadderResults ladderResults) {
        Participant participant = participants.getParticipantByPosition(start);
        Position destination = ladderResults.getDestination(start);
        Outcome outcome = outcomes.getOutcomeByPosition(destination);
        return new GameResult(participant, outcome);
    }

    public GameResult getGameResult(Participant participant) {
        return gameResults.stream()
                          .filter(gameResult -> gameResult.hasParticipant(participant))
                          .findFirst()
                          .orElseThrow(() -> new IllegalArgumentException(
                                  "존재하지 않는 사용자입니다: " + participant.getName()));
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }
}
