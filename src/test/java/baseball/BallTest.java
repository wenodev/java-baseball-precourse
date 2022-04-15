package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2"})
    void construct(int p, int n){
        Position position = new Position(p);
        Number number = new Number(n);
        Ball ball = new Ball(position,number);

        assertThat(ball.getPosition()).isEqualTo(position);
        assertThat(ball.getNumber()).isEqualTo(number);
    }

    @DisplayName("동등성을 보장합니다.")
    @Test
    void equals(){
        Position position = new Position(1);
        Number number = new Number(1);

        assertThat(new Ball(position,number)).isEqualTo(new Ball(position,number));
    }
}
