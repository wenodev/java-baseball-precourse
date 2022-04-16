package baseball;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    @RepeatedTest(100)
    void generate(){
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.generate();

        assertThat(numbers).hasSize(3);
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers.contains(0)).isFalse();
        assertThat(numbers.contains(10)).isFalse();
    }
}
