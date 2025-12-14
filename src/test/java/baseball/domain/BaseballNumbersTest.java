package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BaseballNumbersTest {

    @Test
    void 정상적인_input은_예외가_발생하지_않는다() {
        assertThatCode(() -> new BaseballNumbers(Arrays.asList(1, 2, 3)))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자가_3자리가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_1에서_9까지_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(1, 2, 11)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크를_판별한다() {
        //given
        BaseballNumbers baseballNumbers = new BaseballNumbers(Arrays.asList(1, 2, 3));
        //when && then
        assertThat(baseballNumbers.isStrike(0, 1)).isTrue();
    }

    @Test
    void 숫자를_가지고_있는지_판별한다() {
        //given
        BaseballNumbers baseballNumbers = new BaseballNumbers(Arrays.asList(1, 2, 3));
        //when && then
        assertThat(baseballNumbers.contains(1)).isTrue();
    }
}