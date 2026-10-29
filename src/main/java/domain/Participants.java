package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Participants {
    private final List<ParticipantName> names;

    public Participants(List<String> names) {
        this.names = createNames(names);
        validateNames();
    }

    private List<ParticipantName> createNames(List<String> names) {
        List<ParticipantName> participants = new ArrayList<>();
        for (String name : names) {
            participants.add(new ParticipantName(name));
        }
        return List.copyOf(participants);
    }

    private void validateNames() {
        if (names.isEmpty() || new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException("참여자는 한 명 이상이어야 하며 이름이 중복될 수 없습니다.");
        }
    }

    public LadderWidth getWidth() {
        return new LadderWidth(names.size());
    }

    public ParticipantName get(Position position) {
        return names.get(position.getValue());
    }

    public List<ParticipantName> getNames() {
        return names;
    }
}
