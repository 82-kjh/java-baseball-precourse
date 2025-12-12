package userinteraction;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    // 유저의 입력을 받는다
    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
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

    public boolean askRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = Console.readLine();
        if (userInput.equals("1")) {
            // 재시작
            return false;
        } else  if (userInput.equals("2")) {
            // 종료
            return true;
        } else {
            throw new IllegalArgumentException("입력이 1 또는 2가 아닙니다.");
        }
    }
}
