package domain.game;

import domain.Position;
import domain.Width;
import exception.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
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
        return new Names(names);
    }

    public Position findPosition(Name name) {
        int index = names.indexOf(name);
        if (index == NOT_FOUND){
            throw new IllegalArgumentException(ErrorMessage.NAME_NOT_FOUND.getMessage());
        }
        return new Position(index);
    }

    public Width toWidth() {
        return new Width(names.size());
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
