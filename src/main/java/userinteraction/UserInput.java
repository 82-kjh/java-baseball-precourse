package userinteraction;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public String getInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        return userInput;
    }

    public void validInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }
}
