package model;

import java.util.List;

public class Names {
    private final List<Name> names;

    public Names(List<String> inputs) {
        List<Name> names = inputs.stream()
                .map(Name::new)
                .toList();
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

    private void validateDuplicate(List<Name> names) {
        long distinctCount = names.stream()
                .distinct()
                .count();
        if (distinctCount != names.size()) {
            throw new IllegalArgumentException("참가자 이름은 중복될 수 없습니다.");
        }
    }
}
