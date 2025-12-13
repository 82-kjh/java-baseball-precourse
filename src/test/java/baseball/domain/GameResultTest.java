package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameResultTest {

    @Test
    void 볼과_스트라이크를_조회한다() {
        //given
        GameResult gameResult = new GameResult(1,2);

        //when
        int ball = gameResult.getBallCount();
        int strike = gameResult.getStrikeCount();

        //then
        assertThat(ball).isEqualTo(1);
        assertThat(strike).isEqualTo(2);
    }

    @Test
    void 스트라이크가_3개면_게임종료() {
        //given
        GameResult gameResult = new GameResult(0, 3);

        //when && then
        assertThat(gameResult.isWin()).isTrue();
    }

    @Test
    void 스트라이크가_3개가_아니면_Win이_아님() {
        //given
        GameResult gameResult = new GameResult(1, 2);

        //when && then
        assertThat(gameResult.isWin()).isFalse();
    }

    @Test
    void 볼과_스트라이크가_모두_없다면_Nothing() {
        //given
        GameResult gameResult = new GameResult(0, 0);

        //when && then
        assertThat(gameResult.isNothing()).isTrue();
    }

    @Test
    void 볼과_스트라이크가_있다면_Nothing이_아님() {
        //given
        GameResult gameResult = new GameResult(1, 0);

        //when && then
        assertThat(gameResult.isNothing()).isFalse();
    }
}