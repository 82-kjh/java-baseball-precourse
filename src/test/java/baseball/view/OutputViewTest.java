package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * System.out.print로 출력되는 메시지를 테스트
 * System.out을 가로채서 검증해야함
 * System.out을 ByteArrayOutputStream으로 교체
 */
class OutputViewTest {

    private OutputView outputView;
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream standardOut;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();

        // 표준 출력
        standardOut = System.out;

        // 가로챌 byte stream
        byteArrayOutputStream = new ByteArrayOutputStream();

        // 교체
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        System.out.println("테스트 종료, 복구 완료");
    }

    @Test
    void INPUT_메세지가_정상적으로_출력된다() {
        // when
        outputView.printInputMessage();

        // then
        // 엔터 때문에 trim() 추가
        assertThat(byteArrayOutputStream.toString().trim())
                .isEqualTo("숫자를 입력해주세요 :");
    }

    @Test
    void END_메세지가_정상적으로_출력된다() {
        // when
        outputView.printEndMessage();

        // then
        // 엔터 때문에 trim() 추가
        assertThat(byteArrayOutputStream.toString().trim())
                .isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void RESTART_메세지가_정상적으로_출력된다() {
        // when
        outputView.printAskRestartMessage();

        // then
        // 엔터 때문에 trim() 추가
        assertThat(byteArrayOutputStream.toString().trim())
                .isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Test
    void printAskRestartMessage() {
    }
}