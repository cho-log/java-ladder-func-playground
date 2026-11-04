package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;

public class Names {
    private static final int MINIMUM_COUNT = 2;

    private final List<Name> names;

    private Names(List<Name> names) {
        validateNotDuplicated(names);
        validateMinimumCount(names);
        this.names = names;
    }

    private void validateNotDuplicated(List<Name> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private void validateMinimumCount(List<Name> names) {
        if (names.size() < MINIMUM_COUNT) {
            throw new IllegalArgumentException("참여자는 " + MINIMUM_COUNT + "명 이상이어야 합니다.");
        }
    }

    public static Names from(String input) {
        List<Name> names = new ArrayList<>();
        for (String value : input.split(",", -1)) { //-1을 추가하여 끝의 빈값도 버리지않게 처리함.
            names.add(new Name(value.trim()));
        }
        return new Names(names);
    }

    public int size() {
        return names.size();
    }

    public List<Name> names() {
        return Collections.unmodifiableList(names);
    }
}
