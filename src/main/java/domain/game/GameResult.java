package domain.game;

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

    public static GameResult of(Names names, Ladder ladder, Prizes prizes) {
        validateSameCount(names, prizes);
        List<Name> participants = names.getNames();
        Map<Name, Prize> results = new LinkedHashMap<>();
        for (int index = 0; index < participants.size(); index++) {
            Position endPosition = ladder.findEndPosition(new Position(index));
            results.put(participants.get(index), prizes.findPrize(endPosition));
        }
        return new GameResult(results);
    }

    public static void validateSameCount(Names names, Prizes prizes) {
        if (names.getNames().size() != prizes.getPrizes().size()) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_IS_NOT_NAME_NUMBER.getMessage());
        }
    }

    public Prize findPrize(String targetName) {
        return results.entrySet().stream()
                .filter(result -> result.getKey().getName().equals(targetName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NAME_NOT_FOUND.getMessage()));
    }

    public Map<Name, Prize> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
