package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    void 숫자끼리_정답을_비교한다() {
        //given
        Referee referee = new Referee();
        BaseballNumbers user = new BaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballNumbers computer = new BaseballNumbers(Arrays.asList(1, 2, 4));

        //when
        GameResult gameResult = referee.judge(user, computer);

        //then
        assertThat(gameResult.getStrikeCount()).isEqualTo(2);
    }
}