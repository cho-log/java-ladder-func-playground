package domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateLines(lines);
        this.lines = List.copyOf(lines);
    }

    private void validateLines(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리는 최소 1개 이상의 행이 필요합니다.");
        }
        validateNullLines(lines);
        validateLineSizes(lines);
    }

    private void validateNullLines(List<Line> lines) {
        if (lines.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("사다리에 null인 Line이 포함될 수 없습니다.");
        }
    }

    private void validateLineSizes(List<Line> lines) {
        int pointCount = lines.get(0).size();
        for (Line line : lines) {
            validateLineSize(line, pointCount);
        }
    }

    private void validateLineSize(Line line, int pointCount) {
        if (line.size() != pointCount) {
            throw new IllegalArgumentException("모든 Line의 연결 위치 개수는 같아야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getRow() {
        return lines.size();
    }

    public int getColumn() {
        return lines.get(0).size() + 1;
    }

    public boolean isConnected(int row, int column) {
        return lines.get(row).isConnectedPoint(column);
    }
}
