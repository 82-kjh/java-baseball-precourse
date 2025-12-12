package userinteraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class UserInputTest {

    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @Test
    void 정상_입력() {
        assertThatCode(() -> userInput.validInput("123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 잘못된_길이_입력() {
        assertThatThrownBy(() -> userInput.validInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_입력() {
        assertThatThrownBy(() -> userInput.validInput("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
