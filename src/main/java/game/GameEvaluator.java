package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEvaluator {
    private int strike;
    private int ball;

    public GameEvaluator() {
        this.strike = 0;
        this.ball = 0;
    }

    public void resetStrike() {
        this.strike = 0;
    }
    public void resetBall() {
        this.ball = 0;
    }
    public void increaseStrike() {
        this.strike += 1;
    }
    public void increaseBall() {
        this.ball += 1;
    }

    // 사용자의 입력 점수를 계산
    public Map<String, Integer> evaluate(List<Integer> randomNums, String input) {
        resetStrike();
        resetBall();

        for (int i = 0; i < randomNums.size(); i++) {
            if (randomNums.get(i) == Character.getNumericValue(input.charAt(i))) {
                increaseStrike();

            } else if (randomNums.contains(Character.getNumericValue(input.charAt(i)))) {
                increaseBall();
            }
        }

        Map<String, Integer> result = new HashMap<>();
        result.put("strike", strike);
        result.put("ball", ball);

        return result;
    }

    // 사용자 입력 점수에 대한 메시지 출력
    public String getMessage(Map<String, Integer> result) {
        if (result == null) {
            throw new IllegalArgumentException("결과가 null일 수 없음");
        }

        if (!result.containsKey("strike") || result.get("strike") == null ||
                !result.containsKey("ball") || result.get("ball") == null) {
            throw new IllegalArgumentException("결과에 'strike' 와 'ball' 키를 포함해야 하며, null일 수 없음");
        }

        int strike = result.get("strike");
        int ball = result.get("ball");

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }

        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }

        return sb.toString().trim();
    }

    // 3 strike 인지 평가
    public boolean validThreeStrike(int strike) {
        if (strike != 3) {
            return false;
        }

        return true;
    }
}
