package baseball;

import baseball.controller.GameController;
import baseball.domain.NumberGenerator;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Referee referee = new Referee();

        GameController gameController = new GameController(inputView, outputView, numberGenerator, referee);
        gameController.run();

    }
}
