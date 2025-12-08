package userinteraction;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    // 유저의 입력을 받는다
    public String getInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        return userInput;
    }

    // 유저의 입력이 이상하면 에러
    public void validInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    // 정답을 맞추고 난 다음 입력
    public int finishGameInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int finishNum = 0;

        String finalInput = Console.readLine();
        if (finalInput.equals("1")) {
            finishNum = 1;
        } else if (finalInput.equals("2")) {
            finishNum = 2;
        } else {
            throw new IllegalArgumentException();
        }

        return finishNum;
    }
}
