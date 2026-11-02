package domain.game;

import domain.EndPositions;
import domain.Ladder;
import domain.Position;
import exception.ErrorMessage;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private final Map<Name, Prize> results;

    private GameResult(Map<Name, Prize> results) {
        this.results = results;
    }

    public static GameResult of(Names names, Ladder ladder, Prizes prizes)  {
        validateSameCount(names, prizes);
        EndPositions endPositions = ladder.findEndPositions();
        List<Name> participants = names.getNames();
        Map<Name, Prize> results = new LinkedHashMap<>();
        for(int index = 0; index < participants.size(); index++) {
            Position endPosition = endPositions.findEndPosition(new Position(index));
            results.put(participants.get(index), prizes.findPrize(endPosition));
        }
        return new GameResult(results);
    }

    private static void validateSameCount(Names names, Prizes prizes) {
        if (names.getNames().size() != prizes.getPrizes().size()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_RESERVED.getMessage());
        }
    }

    public Prize findPrize(Name name) {
        if(!results.containsKey(name)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_NOT_FOUND.getMessage());
        }
        return results.get(name);
    }

    public Map<Name, Prize> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
