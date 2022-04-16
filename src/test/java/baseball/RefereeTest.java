package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @DisplayName("position과 number로 구성됩니다.")
    @Test
    void construct(){
        Ball comBall = new Ball(1,1);
        Referee referee = new Referee(comBall);

        assertThat(referee.getComBall()).isEqualTo(comBall);
    }

    @DisplayName("같은 Ball이라면 STRIKE 입니다.")
    @Test
    void judge_strike(){
        Ball comBall = new Ball(1,1);
        Ball playerBall = new Ball(1,1);
        Referee referee = new Referee(comBall);

        BallStatus ballStatus = referee.judge(playerBall);

        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("position은 다른고 number가 같으면 BALL 입니다.")
    @Test
    void judge_ball(){
        Ball comBall = new Ball(1,1);
        Ball playerBall = new Ball(2,1);
        Referee referee = new Referee(comBall);

        BallStatus ballStatus = referee.judge(playerBall);

        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("position과 number 둘 다 다르면 NOTHING 입니다.")
    @Test
    void judge_nothing(){
        Ball comBall = new Ball(1,1);
        Ball playerBall = new Ball(2,2);
        Referee referee = new Referee(comBall);

        BallStatus ballStatus = referee.judge(playerBall);

        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
