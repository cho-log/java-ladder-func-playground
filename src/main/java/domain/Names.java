package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Names {
    private final List<Name> names;

    public Names(List<Name> names) {
        validateNames(names);
        this.names = List.copyOf(names);
    }

    private void validateNames(List<Name> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("참여자 이름은 최소 1개 이상이어야 합니다.");
        }
        validateNullNames(names);
        validateDuplicateNames(names);
    }

    private void validateNullNames(List<Name> names) {
        if (names.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("참여자 이름에 null이 포함될 수 없습니다.");
        }
    }

    private void validateDuplicateNames(List<Name> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException("참여자 이름은 중복될 수 없습니다.");
        }
    }

    public int size() {
        return names.size();
    }

    public Name get(int index) {
        return names.get(index);
    }

    public List<Name> getNames() {
        return names;
    }
}
