package baseball.domain;

/**
 * DTO 클래스
 * 채점 결과를 담는 클래스
 */
public class GameResult {

    // 불변
    private final int ball;
    private final int strike;

    public GameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBallCount() {
        return ball;
    }

    public int getStrikeCount() {
        return strike;
    }

    public boolean isWin() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }


}
