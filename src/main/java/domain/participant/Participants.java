package domain.participant;

import domain.ladder.Position;

import java.util.List;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        validate(participants);
        this.participants = List.copyOf(participants);
    }

    private void validate(List<Participant> participants) {
        if (participants.size() < 2) {
            throw new IllegalArgumentException("참여자는 최소 두 명이여야 합니다.");
        }
    }

    public int getSize() {
        return participants.size();
    }

    public Participant getParticipant(String name) {
        int index = findParticipantIndex(name);

        if (index == participants.size()) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다: " + name);
        }

        return participants.get(index);
    }

    private int findParticipantIndex(String name) {
        int index = 0;

        while (index != participants.size() && !participants.get(index).hasName(name)) {
            index++;
        }

        return index;
    }

    public Participant getParticipantByPosition(Position position) {
        return participants.get(position.getValue());
    }
}
