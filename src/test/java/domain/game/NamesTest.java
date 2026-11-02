package domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NamesTest {
    private final Names names = Names.createNames(List.of("neo", "brown", "brie", "tommy"));

    @Test
    void 이름_개수가_넓이가_된다() {
        assertThat(names.toWidth().getWidth()).isEqualTo(4);
    }

    @Test
    void 참여자가_1명이면_오류가_발생한다() {
        assertThatThrownBy(() -> Names.createNames(List.of("neo")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_목록에_빈_이름이_있으면_오류가_발생한다() {
        assertThatThrownBy(() -> Names.createNames(List.of("neo", "brie", "")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_목록에_중복이_있으면_오류가_발생한다() {
        assertThatThrownBy(() -> Names.createNames(List.of("neo", "brie", "brie")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
