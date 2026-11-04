package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @Test
    @DisplayName("끝에 쉼표가 있으면 빈 이름이라 예외가 발생한다.")
    void 끝에_쉼표가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Names.from("neo,brown,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자가 한 명이면 예외가 발생한다.")
    void 참여자가_한_명이면_예외가_발생한다() {
        assertThatThrownBy(() -> Names.from("neo"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 중복되면 예외가 발생한다.")
    void 이름이_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> Names.from("neo,brown,neo"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
