package baseball.domain;

import java.util.List;

/**
 * 테스트를 용이하게 하기 위해서 인터페이스 구현
 */
@FunctionalInterface
public interface NumberGenerator {
    List<Integer> generate();
}
