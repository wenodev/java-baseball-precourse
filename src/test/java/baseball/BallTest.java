package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @DisplayName("position과 number로 구성됩니다.")
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

    @DisplayName("같은 Ball이라면 STRIKE 입니다.")
    @Test
    void judge_strike(){
        Ball computerBall = new Ball(1,1);
        Ball playerBall = new Ball(1,1);

        BallStatus ballStatus = computerBall.compare(playerBall);

        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("position은 다른고 number가 같으면 BALL 입니다.")
    @Test
    void judge_ball(){
        Ball computerBall = new Ball(1,1);
        Ball playerBall = new Ball(2,1);

        BallStatus ballStatus = computerBall.compare(playerBall);

        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("position과 number 둘 다 다르면 NOTHING 입니다.")
    @Test
    void judge_nothing(){
        Ball computerBall = new Ball(1,1);
        Ball playerBall = new Ball(2,2);

        BallStatus ballStatus = computerBall.compare(playerBall);

        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
