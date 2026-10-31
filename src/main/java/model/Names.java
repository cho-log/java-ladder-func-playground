package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> unique = new HashSet<>();
        for (Name name : names) {
            unique.add(name.getName());
        }
        if (unique.size() != names.size()) {
            throw new IllegalArgumentException("참가자 이름은 중복될 수 없습니다.");
        }
    }
}
