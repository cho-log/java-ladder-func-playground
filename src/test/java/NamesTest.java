import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Name;
import domain.Names;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @Test
    void 중복된_이름이_있으면_예외가_발생한다() {
        List<Name> names = List.of(
                new Name("neo"),
                new Name("brown"),
                new Name("neo")
        );

        assertThrows(IllegalArgumentException.class, () -> new Names(names));
    }

    @Test
    void 이름이_5글자를_초과하면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> new Name("abcdef"));
    }

    @Test
    void 이름이_5글자면_생성할_수_있다() {
        assertDoesNotThrow(() -> new Name("brown"));
    }
}
