package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class GameResults {
    private final Map<Participant, Outcome> results;

    public GameResults(Participants participants, Outcomes outcomes, Ladder ladder) {
        outcomes.validateCount(participants.getWidth());
        this.results = createResults(participants, outcomes, ladder);
    }

    private Map<Participant, Outcome> createResults(Participants participants, Outcomes outcomes, Ladder ladder) {
        Map<Participant, Outcome> results = new LinkedHashMap<>();
        for (LadderPath path : ladder.getPaths()) {
            results.put(participants.getParticipant(path.getStart()), outcomes.get(path.getEnd()));
        }
        return Collections.unmodifiableMap(results);
    }

    public Outcome getResult(Participant name) {
        return Optional.ofNullable(results.get(name))
                .orElseThrow(() -> new IllegalArgumentException("참여하지 않은 사람입니다: " + name.getValue()));
    }

    public Map<Participant, Outcome> getResults() {
        return results;
    }
}
