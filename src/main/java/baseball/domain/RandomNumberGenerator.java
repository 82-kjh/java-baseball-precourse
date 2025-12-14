package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        Set<Integer> randomNum = new LinkedHashSet<>();

        while (randomNum.size() < 3) {
            randomNum.add(Randoms.pickNumberInRange(1, 9));
        }

        // 각 자리별 숫자 비교를 위해서 List 사용
        return new ArrayList<>(randomNum);
    }
}
