package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @DisplayName("1 이상 9 이하 값으로 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,7,8,9})
    void construct_validValue(int value){
        Number number = new Number(value);
        assertThat(number.getValue()).isEqualTo(value);
    }

    @DisplayName("1 이상 9 이하 값이 아니라면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void construct_inValidValue(int value){
        assertThatThrownBy(() -> {
            new Number(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
