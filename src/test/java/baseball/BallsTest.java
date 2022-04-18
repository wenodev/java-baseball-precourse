package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    @DisplayName("integer array로 생성합니다.")
    @Test
    void construct_intArray(){
        Balls balls = new Balls(Arrays.asList(1,2,3));

        assertThat(balls.getValues().size()).isEqualTo(3);
        assertThat(balls.getValues().get(0)).isEqualTo(new Ball(1,1));
    }

    @DisplayName("string으로 생성합니다.")
    @Test
    void construct_string(){
        Balls balls = new Balls("123");

        assertThat(balls.getValues().size()).isEqualTo(3);
        assertThat(balls.getValues().get(0)).isEqualTo(new Ball(1,1));
    }
}
