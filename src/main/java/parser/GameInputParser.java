package parser;

import domain.Outcome;
import domain.Participant;

import java.util.ArrayList;
import java.util.List;

public class GameInputParser {
    public List<Participant> parseParticipants(String participantNames) {
        List<Participant> participants = new ArrayList<>();

        String[] names = participantNames.split(",");

        for (String name : names) {
            Participant participant = new Participant(name);
            participants.add(participant);
        }

        return participants;
    }

    public List<Outcome> parseOutcomes(String outcomes) {
        List<Outcome> outcomesList = new ArrayList<>();

        String[] values = outcomes.split(",");

        for (String value : values) {
            Outcome outcome = new Outcome(value);
            outcomesList.add(outcome);
        }

        return outcomesList;
    }
}
