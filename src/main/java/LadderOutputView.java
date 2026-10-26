import java.util.ArrayList;
import java.util.List;

public class LadderOutputView {
    public void print(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(formatLine(line));
        }
    }

    private String formatLine(Line line) {
        List<String> result = new ArrayList<>();

        for (Boolean point : line.getPoints()) {
            result.add("|");

            if (point) {
                result.add("-----");
                continue;
            }

            result.add("     ");
        }

        result.add("|");

        return String.join("", result);
    }
}
