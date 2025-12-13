package baseball.domain;

public class Referee {

    public GameResult judge(BaseballNumbers user, BaseballNumbers computer) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < user.SIZE; i++) {
            if (computer.isStrike(i, user.getNumber(i))) {
                strike++;
            } else if (computer.contains(user.getNumber(i))) {
                ball++;
            }
        }

        return new GameResult(ball, strike);
    }
}
