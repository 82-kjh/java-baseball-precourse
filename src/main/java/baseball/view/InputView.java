package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Integer> readNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        // 빈 값 체크
        validateNotBlank(input);

        return stringToIntegerList(input);
    }

    // 빈 값 체크
    private void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    // string을 list로 변환
    private List<Integer> stringToIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력가능합니다.");
            }
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }
}
