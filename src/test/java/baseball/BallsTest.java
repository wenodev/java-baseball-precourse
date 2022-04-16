package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    @Test
    void construct(){
        Balls balls = new Balls(1,2,3);

        assertThat(balls.getValues().size()).isEqualTo(3);
        assertThat(balls.getValues().get(0)).isEqualTo(new Ball(1,1));
    }
}
