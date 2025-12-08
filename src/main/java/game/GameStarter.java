package game;

import userinteraction.UserInput;

public class GameStarter {
    public void start() {
        UserInput ui = new UserInput();

        // 유저 input 받음
        String input = ui.getInput();
        // input 검증
        ui.validInput(input);

    }
}
