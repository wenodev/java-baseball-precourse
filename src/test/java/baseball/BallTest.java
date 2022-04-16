package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2"})
    void construct(int position, int number){
        Ball ball = new Ball(position,number);

        assertThat(ball.getPosition()).isEqualTo(new Position(position));
        assertThat(ball.getNumber()).isEqualTo(new Number(number));
    }

    @DisplayName("동등성을 보장합니다.")
    @Test
    void equals(){
        assertThat(new Ball(1,1)).isEqualTo(new Ball(1,1));
    }
}
