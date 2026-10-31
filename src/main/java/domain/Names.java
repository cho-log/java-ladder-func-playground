package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {
    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names from(String input) {
        List<Name> names = new ArrayList<>();
        for (String value : input.split(",")) {
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
