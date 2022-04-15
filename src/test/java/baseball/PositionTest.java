package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @DisplayName("1 이상 3 이하 값으로 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void construct_validValue(int value){
        Position position = new Position(value);
        assertThat(position.getValue()).isEqualTo(value);
    }

    @DisplayName("1 이상 3 이하 값이 아니면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1,0,4})
    void construct_inValidValue(int value){
        assertThatThrownBy(() -> {
            new Position(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equals(){
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }
}
