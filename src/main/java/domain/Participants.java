package domain;

import java.util.HashSet;
import java.util.List;

public class Participants {
    private final List<Participant> names;

    public Participants(List<String> names) {
        this.names = createNames(names);
        validateNotEmpty();
        validateDuplicateNames();
    }

    private List<Participant> createNames(List<String> names) {
        return names.stream().map(Participant::new).toList();
    }

    private void validateNotEmpty() {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("참여자는 한 명 이상이어야 합니다.");
        }
    }

    private void validateDuplicateNames() {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException("참여자 이름이 중복될 수 없습니다.");
        }
    }

    public LadderWidth getWidth() {
        return new LadderWidth(names.size());
    }

    public Participant getParticipant(Position position) {
        return names.get(position.getValue());
    }

    public List<Participant> getNames() {
        return names;
    }
}
