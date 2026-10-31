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
        return participants.stream()
                           .filter(participant -> participant.hasName(name))
                           .findFirst()
                           .orElseThrow(() -> new IllegalArgumentException(
                                   "존재하지 않는 사용자입니다: " + name));
    }

    public Participant getParticipantByPosition(Position position) {
        return participants.get(position.getValue());
    }
}
