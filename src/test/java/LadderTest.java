import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderTest {
    @Test
    void 입력한_높이만큼_Line이_생성된다() {
        Ladder ladder = new Ladder(new Width(4), new Height(4));

        assertEquals(4, ladder.getLines().size());
    }

    @Test
    void 입력한_넓이보다_하나_작은_연결_상태가_생성된다() {
        Ladder ladder = new Ladder(new Width(4), new Height(4));

        for (Line line : ladder.getLines()) {
            assertEquals(3, line.getPoints().size());
        }
    }

    @Test
    void 최소_넓이와_높이로_사다리를_생성할_수_있다() {
        Ladder ladder = new Ladder(new Width(2), new Height(1));

        assertEquals(1, ladder.getLines().size());
        assertEquals(1, ladder.getLines().get(0).getPoints().size());
    }
}
