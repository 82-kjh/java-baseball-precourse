package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 사용자의 입력, 컴퓨터의 정답을 가지는 객체
 */
public class BaseballNumbers {

    // 불변
    private final List<Integer> baseballNumbers;

    public static final int SIZE = 3;

    public BaseballNumbers(List<Integer> baseballNumbers) {
        // 검증
        validate(baseballNumbers);

        this.baseballNumbers = new ArrayList<>(baseballNumbers);
    }

    private void validate(List<Integer> baseballNumbers) {
        validateSize(baseballNumbers);
        validateRange(baseballNumbers);
        validateDuplicate(baseballNumbers);
    }

    private void validateDuplicate(List<Integer> baseballNumbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(baseballNumbers);
        if (uniqueNumbers.size() != baseballNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private void validateRange(List<Integer> baseballNumbers) {
        for (Integer number : baseballNumbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 입력하세요.");
            }
        }
    }

    private void validateSize(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리가 아닙니다.");
        }
    }

    // strike 판별
    public boolean isStrike(int index, int number) {
        return baseballNumbers.get(index) == number;
    }

    // ball 판별을 위한 메서드
    public boolean contains(int number) {
        return baseballNumbers.contains(number);
    }

    public int getNumber(int index) {
        return baseballNumbers.get(index);
    }
}
