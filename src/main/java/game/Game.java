package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import userinteraction.UserInput;

import java.util.*;

public class Game {

    public void play() {
        // 컴퓨터의 정답 숫자
        List<Integer> randomNums = generateAnswer();
        UserInput ui = new UserInput();
        GameEvaluator gameEvaluator = new GameEvaluator();

        boolean isGameFinished = false;

        while (!isGameFinished) {
            // 유저 input 받음
            String input = ui.getInput();
            // input 3자리 숫자 검증
            ui.validInput(input);

            // 유저 입력 채점
            Map<String, Integer> evaluateResult = gameEvaluator.evaluate(randomNums, input);

            // 채점 결과에 따른 메시지 출력
            String resultMessage = gameEvaluator.getMessage(evaluateResult);
            System.out.println(resultMessage);

            boolean isThreeStrike = gameEvaluator.validThreeStrike(evaluateResult.get("strike"));

            // 정답이 아니라면 다시 while문 반복
            if (!isThreeStrike) {
                continue;
            }
            
            // 재시작, 종료 입력받기
            isGameFinished = ui.askRestart();
            
            // 재시작한다면 새로운 정답으로 교체
            if (!isGameFinished) {
                randomNums = generateAnswer();
            }
        }
    }

    // 랜덤 숫자 3자리를 생성
    private List<Integer> generateAnswer() {
        Set<Integer> randomNums = new LinkedHashSet<>();

        while (randomNums.size() < 3) {
            randomNums.add(Randoms.pickNumberInRange(1, 9));
        }

        // 각 자리별 숫자 비교를 위해서 List 사용
        return new ArrayList<>(randomNums);
    }
}
