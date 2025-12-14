package baseball.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView = new InputView();

    @Test
    void 숫자를_입력하면_리스트로_변환된다() {
        //given
        String input = "123";
        systemIn(input);

        //when
        List<Integer> result = inputView.readNumber();

        //then
        assertThat(result).containsExactly(1, 2, 3);
        assertThat(result).hasSize(3);
    }

    @Test
    void 빈_값을_입력하면_예외가_발생한다() {
        //given
        String input = " ";
        systemIn(input);

        //when && then
        assertThatThrownBy(() -> inputView.readNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_다른것을_입력하면_예외가_발생한다() {
        //given
        String input = "1ab";
        systemIn(input);

        //when && then
        assertThatThrownBy(() -> inputView.readNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 콘솔 입력을 도와주는 테스트 헬퍼 메서드
    private void systemIn(String input) {
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(in);
    }
}