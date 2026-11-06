package domain.game;

import domain.outcome.Outcomes;
import domain.participant.Participants;
import domain.ladder.Width;

public class GameSetup {
    private final Participants participants;
    private final Outcomes outcomes;

    public GameSetup(Participants participants, Outcomes outcomes) {
        validate(participants, outcomes);
        this.participants = participants;
        this.outcomes = outcomes;
    }

    private void validate(Participants participants, Outcomes outcomes) {
        if (participants.getSize() != outcomes.getSize()) {
            throw new IllegalArgumentException("참여자 수와 당첨 결과 수가 같아야 합니다.");
        }
    }

    public Width getWidth() {
        return new Width(participants.getSize());
    }
}
