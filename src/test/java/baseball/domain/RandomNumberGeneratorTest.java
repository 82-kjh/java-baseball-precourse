package baseball.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    // random 숫자이므로 10번 반복해서 테스트
    @RepeatedTest(10)
    void 랜덤_숫자_체크() {
        //given
        RandomNumberGenerator generator = new RandomNumberGenerator();

        //when
        List<Integer> numbers = generator.generate();

        //then
        // 3개인지
        assertThat(numbers).hasSize(3);
        // 1~9 숫자인지
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 9);
        // 중복은 없는지
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers).hasSize(3);
    }
}