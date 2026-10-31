package parser;

import domain.outcome.Outcome;
import domain.participant.Participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameInputParser {
    public List<Participant> parseParticipants(String participantNames) {
        return Arrays.stream(participantNames.split(","))
                     .map(Participant::new)
                     .collect(Collectors.toList());
    }

    public List<Outcome> parseOutcomes(String outcomes) {
        return Arrays.stream(outcomes.split(","))
                     .map(Outcome::new)
                     .collect(Collectors.toList());
    }
}
