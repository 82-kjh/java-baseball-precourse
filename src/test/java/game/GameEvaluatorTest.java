package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameEvaluatorTest {

    private GameEvaluator gameEvaluator;

    @BeforeEach
    void setUp() {
        gameEvaluator = new GameEvaluator();
    }

    @Test
    void 스트라이크_3개() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        String userInput = "123";

        // when
        Map<String, Integer> result = gameEvaluator.evaluate(answer, userInput);

        // then
        assertThat(result.get("strike")).isEqualTo(3);
        assertThat(result.get("ball")).isEqualTo(0);
    }

    @Test
    void 볼_2개_스트라이크_1개() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        String userInput = "321"; // 3은 볼, 2는 스트라이크, 1은 볼

        // when
        Map<String, Integer> result = gameEvaluator.evaluate(answer, userInput);

        // then
        assertThat(result.get("strike")).isEqualTo(1);
        assertThat(result.get("ball")).isEqualTo(2);
    }

    @Test
    void 낫싱() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        String userInput = "456";

        // when
        Map<String, Integer> result = gameEvaluator.evaluate(answer, userInput);

        // then
        assertThat(result.get("strike")).isEqualTo(0);
        assertThat(result.get("ball")).isEqualTo(0);
    }

    @Test
    void 메시지_출력_낫싱() {
        Map<String, Integer> result = new java.util.HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);
        
        assertThat(gameEvaluator.getMessage(result)).isEqualTo("낫싱");
    }

    @Test
    void 메시지_출력_볼과_스트라이크() {
        Map<String, Integer> result = new java.util.HashMap<>();
        result.put("strike", 1);
        result.put("ball", 1);
        
        assertThat(gameEvaluator.getMessage(result)).isEqualTo("1볼 1스트라이크");
    }
}
