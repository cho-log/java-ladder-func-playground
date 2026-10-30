package domain.game;

import domain.outcome.Outcome;
import domain.outcome.Outcomes;
import domain.participant.Participant;
import domain.participant.Participants;
import domain.ladder.LadderResults;
import domain.ladder.Position;

import java.util.ArrayList;
import java.util.List;

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
        if (participants.getSize() != outcomes.getSize()
        || participants.getSize() != ladderResults.size()) {
            throw new IllegalArgumentException("참여자 수와 결과 수가 같아야 합니다.");
        }
    }

    private List<GameResult> calculateGameResults(Participants participants, Outcomes outcomes, LadderResults ladderResults) {
        List<GameResult> gameResults = new ArrayList<>();

        for (int i = 0; i < participants.getSize(); i++) {
            Position start = new Position(i);
            Participant participant = participants.getParticipantByPosition(start);

            Position destination = ladderResults.getDestination(start);
            Outcome outcome = outcomes.getOutcomeByPosition(destination);

            GameResult gameResult = new GameResult(participant, outcome);
            gameResults.add(gameResult);
        }

        return List.copyOf(gameResults);
    }

    public GameResult getGameResult(Participant participant) {
        int index = findResultIndex(participant);

        if (index == gameResults.size()) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다: " + participant.getName());
        }

        return gameResults.get(index);
    }

    private int findResultIndex(Participant participant) {
        int index = 0;

        while (index != gameResults.size() && !gameResults.get(index).hasParticipant(participant)) {
            index++;
        }

        return index;
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }
}
