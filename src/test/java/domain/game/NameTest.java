package domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NameTest {

    @Test
    void 이름이_5글자_이하면_생성된다() {
        Name name = new Name("tommy");

        assertThat(name.getName()).isEqualTo("tommy");
    }

    @Test
    void 이름이_5글자를_넘으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Name("tommyy"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 글자가_같으면_같은_이름이다() {
        assertThat(new Name("neo")).isEqualTo(new Name("neo"));
    }
}
