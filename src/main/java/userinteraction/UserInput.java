package userinteraction;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class UserInput {

    private static final Pattern THREE_DIGIT_PATTERN = Pattern.compile("^[0-9]{3}$");

    // 유저의 입력을 받는다
    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        return userInput;
    }

    // 유저의 입력이 이상하면 에러
    public void validInput(String userInput) {
        // 1. Null 체크
        if (userInput == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }

        // 2. 길이 체크
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
        }

        // 3. ReDos 방어
        // 3자리 고정. 중첩 반복자 사용x
        if (!THREE_DIGIT_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
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
