package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {

    @Test
    @DisplayName("입력한 순서대로 이름 목록을 반환한다")
    void getNames() {
        Names names = new Names(List.of("neo", "brown", "brie", "tommy"));

        assertThat(names.getNames()).containsExactly("neo", "brown", "brie", "tommy");
    }

    @Test
    @DisplayName("참가자 수를 반환한다")
    void getSize() {
        Names names = new Names(List.of("neo", "brown", "brie"));

        assertThat(names.getSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("중복된 이름이 있으면 예외가 발생한다")
    void duplicateName() {
        assertThatThrownBy(() -> new Names(List.of("neo", "brown", "neo")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("이름 중 하나라도 5자를 넘으면 예외가 발생한다")
    void containsInvalidName() {
        assertThatThrownBy(() -> new Names(List.of("neo", "brownie")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하여야 합니다.");
    }

}