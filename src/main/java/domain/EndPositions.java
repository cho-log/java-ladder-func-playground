package domain;

import java.util.Collections;
import java.util.List;

/*
 * 도착 위치 목록
 * 목록의 순서가 시작 위치
 */

public class EndPositions {
    private final List<Position> endPositions;

    public EndPositions(List<Position> endPositions) {
        this.endPositions = endPositions;
    }

    public Position findEndPosition(Position startPosition) {
        return endPositions.get(startPosition.getPosition());
    }

    public List<Position> getEndPositions() {
        return Collections.unmodifiableList(endPositions);
    }
}
