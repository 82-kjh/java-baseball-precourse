package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import userinteraction.UserInput;

import java.util.ArrayList;
import java.util.List;

public class GameStarter {

    // 게임을 진행
    public void start() {

        // 컴퓨터의 정답 숫자
        List<Integer> randomNums = generateAnswer();
        UserInput ui = new UserInput();

        while (true) {
            // 유저 input 받음
            String input = ui.getInput();
            // input 검증
            ui.validInput(input);

            // 점수 계산
            GameResult gameResult = calculateGameResult(randomNums, input);

            int ball = gameResult.getBall();
            int strike = gameResult.getStrike();

            // 낫싱
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
                continue;
            }

            // 0 strike
            if (strike == 0 && ball > 0) {
                System.out.println(ball + "볼");
                continue;
            }

            // 0 ball
            if (strike > 0 && strike != 3 && ball == 0) {
                System.out.println(strike + "스트라이크");
                continue;
            }

            // strike, ball 모두 있음
            if (strike > 0 && ball > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
                continue;
            }

            // 3 strike
            if (strike == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }

            // 정답시 마지막 질문
            int finish = ui.finishGameInput();
            if (finish == 1) {
                // 이어서 할 경우 정답을 다시 초기화
                randomNums = generateAnswer();
                continue;
            } else if (finish == 2) {
                break;
            }
        }
    }

    // 랜덤 숫자 3자리를 생성
    private List<Integer> generateAnswer() {
        List<Integer> randomNums = new ArrayList<>();

        while (randomNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }

        return randomNums;
    }

    // 사용자의 입력 점수를 계산
    public GameResult calculateGameResult(List<Integer> randomNums, String input) {

        // 점수 초기화
        GameResult gameResult = new GameResult();

        int strike = gameResult.getStrike();
        int ball = gameResult.getBall();

        for (int i = 0; i < randomNums.size(); i++) {
            // strike
            if (randomNums.get(i) == Character.getNumericValue(input.charAt(i))) {
                strike++;

            } else if (randomNums.contains(Character.getNumericValue(input.charAt(i)))) {
                // ball
                ball++;
            }
        }

        gameResult.setStrike(strike);
        gameResult.setBall(ball);

        return gameResult;
    }

}
