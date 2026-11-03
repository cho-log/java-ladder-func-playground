package model;

import java.util.List;

public class Names {
    private final List<Name> names;
    private static final int MIN_WIDTH = 2;

    public Names(List<String> inputs) {
        List<Name> names = inputs.stream()
                .map(Name::new)
                .toList();
        validateSize(names);
        validateDuplicate(names);
        this.names = names;
    }


    public int getSize() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getName)
                .toList();
    }

    public Name get(int index) {
        return names.get(index);
    }

    private void validateSize(List<Name> names) {
        if (names.size() < MIN_WIDTH) {
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
