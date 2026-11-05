package model;

import java.util.Iterator;
import java.util.List;

public class Names implements Iterable<Name> {
    private static final int MIN_PARTICIPANTS = 2;
    private final List<Name> names;

    public Names(List<String> inputs) {
        List<Name> names = inputs.stream()
                .map(Name::new)
                .toList();
        validateSize(names);
        validateDuplicate(names);
        this.names = names;
    }

    public int getParticipantCount() {
        return names.size();
    }

    public Name get(int index) {
        return names.get(index);
    }

    @Override
    public Iterator<Name> iterator() {
        return names.iterator();
    }

    private void validateSize(List<Name> names) {
        if (names.size() < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicate(List<Name> names) {
        long distinctCount = names.stream()
                .distinct()
                .count();
        if (distinctCount != names.size()) {
            throw new IllegalArgumentException("참가자 이름은 중복될 수 없습니다.");
        }
    }
}
