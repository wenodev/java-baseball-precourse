package baseball;

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
}
