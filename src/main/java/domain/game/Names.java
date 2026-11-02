package domain.game;

import domain.Position;
import domain.Width;
import exception.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Names {
    private static final int NOT_FOUND = -1;
    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names createNames(List<String> inputNames) {
        List<Name> names = new ArrayList<>();
        for (String inputName : inputNames) {
            names.add(new Name(inputName));
        }

        validateNotDuplicate(names);
        return new Names(names);
    }

    private static void validateNotDuplicate(List<Name> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

    public Width toWidth() {
        return new Width(names.size());
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
