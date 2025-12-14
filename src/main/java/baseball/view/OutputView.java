package baseball.view;

import baseball.domain.GameResult;

import java.io.Console;

public class OutputView {
    /**
     * 출력해야 하는 메시지
     * "숫자를 입력해주세요 : "
     * "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
     * "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
     */

    /**
     * static: 객체를 생성할 때마다 문자열을 메모리에 새로 생성하지 않음. 메모리 절약
     * final: 고정 문구이므로 값이 바뀌지 않음
     */
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public void printAskRestartMessage() {
        System.out.println(ASK_RESTART_MESSAGE);
    }

    public void printResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb = new StringBuilder();

        if (gameResult.getBallCount() > 0) {
            sb.append(gameResult.getBallCount()).append("볼 ");
        }

        if (gameResult.getStrikeCount() > 0) {
            sb.append(gameResult.getStrikeCount()).append("스트라이크");
        }

        System.out.println(sb.toString().trim());

        if (gameResult.isWin()) {
            printEndMessage();
            printAskRestartMessage();
        }
    }
}
