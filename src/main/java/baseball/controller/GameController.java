package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.GameResult;
import baseball.domain.NumberGenerator;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

/**
 * Game 진행의 역할
 */
public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private final Referee referee;
    private BaseballNumbers computerNumbers;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator, Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
        this.referee = referee;
    }

    public void run() {

        // 처음 세팅
        boolean isPlay = true;
        computerNumbers = new BaseballNumbers(numberGenerator.generate());

        // while문
        while (isPlay) {
            // 컴퓨터 정답과 사용자 입력을 비교해야함.
            GameResult gameResult = playOneTurn();

            // 정답이라면 재시작, 종료 여부를 물어봐야함.
            isPlay = askRestart(gameResult.isWin());
        }
    }

    private boolean askRestart(boolean isWin) {
        if (!isWin) {
            return true;
        }

        int restartInput = inputView.readNumber().get(0);
        boolean isRestart = restartInput == 1;

        // 재시작한다면, 컴퓨터의 정답을 변경해야함.
        if (isRestart) {
            computerNumbers = new BaseballNumbers(numberGenerator.generate());
        }

        return isRestart;
    }

    private GameResult playOneTurn() {

        // 매 턴마다 사용자의 입력을 받음
        List<Integer> userNumberList = inputView.readNumber();
        // 사용자의 입력을 baseballNumbers 로 저장
        BaseballNumbers userNumbers = new BaseballNumbers(userNumberList);

        // 컴퓨터의 정답과 비교
        // 컴퓨터의 정답은 라운드가 끝나도 변하지 않음
        GameResult gameResult = referee.judge(userNumbers, computerNumbers);

        // 결과 출력
        outputView.printResult(gameResult);

        return gameResult;
    }

}
