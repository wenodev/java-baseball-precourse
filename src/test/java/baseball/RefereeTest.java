package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @DisplayName("computerBalls를 가집니다.")
    @Test
    void construct(){
        Balls computerBalls = new Balls(Arrays.asList(1,2,3));
        Referee referee = new Referee(computerBalls);

        assertThat(referee.getComputerBalls()).isEqualTo(computerBalls);
    }

    @DisplayName("3STRIKE 입니다.")
    @Test
    void judge_3strike(){
        Balls computerBalls = new Balls(Arrays.asList(1,2,3));
        Balls playerBalls = new Balls(Arrays.asList(1,2,3));
        Referee referee = new Referee(computerBalls);

        JudgeResult judgeResult = referee.judgeBalls(playerBalls);

        assertThat(judgeResult.getStrike()).isEqualTo(3);
        assertThat(judgeResult.getBall()).isEqualTo(0);
        assertThat(judgeResult.toMessage()).isEqualTo("3스트라이크");
    }

    @DisplayName("2BALL 1STRIKE 입니다.")
    @Test
    void judge_1strike_2ball(){
        Balls computerBalls = new Balls(Arrays.asList(1,2,3));
        Balls playerBalls = new Balls(Arrays.asList(2,1,3));
        Referee referee = new Referee(computerBalls);

        JudgeResult judgeResult = referee.judgeBalls(playerBalls);

        assertThat(judgeResult.getStrike()).isEqualTo(1);
        assertThat(judgeResult.getBall()).isEqualTo(2);
        assertThat(judgeResult.toMessage()).isEqualTo("2볼 1스트라이크");
    }

    @DisplayName("1BALL 1STRIKE 입니다.")
    @Test
    void judge_1strike_1ball(){
        Balls computerBalls = new Balls(Arrays.asList(5,8,9));
        Balls playerBalls = new Balls(Arrays.asList(5,9,7));
        Referee referee = new Referee(computerBalls);

        JudgeResult judgeResult = referee.judgeBalls(playerBalls);

        assertThat(judgeResult.getStrike()).isEqualTo(1);
        assertThat(judgeResult.getBall()).isEqualTo(1);
        assertThat(judgeResult.toMessage()).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("3BALL 입니다.")
    @Test
    void judge_3ball(){
        Balls computerBalls = new Balls(Arrays.asList(1,2,3));
        Balls playerBalls = new Balls(Arrays.asList(3,1,2));
        Referee referee = new Referee(computerBalls);

        JudgeResult judgeResult = referee.judgeBalls(playerBalls);

        assertThat(judgeResult.getStrike()).isEqualTo(0);
        assertThat(judgeResult.getBall()).isEqualTo(3);
        assertThat(judgeResult.toMessage()).isEqualTo("3볼");
    }

    @DisplayName("nothing")
    @Test
    void judge_nothing(){
        Balls computerBalls = new Balls(Arrays.asList(1,2,3));
        Balls playerBalls = new Balls(Arrays.asList(4,5,6));
        Referee referee = new Referee(computerBalls);

        JudgeResult judgeResult = referee.judgeBalls(playerBalls);

        assertThat(judgeResult.getStrike()).isEqualTo(0);
        assertThat(judgeResult.getBall()).isEqualTo(0);
        assertThat(judgeResult.toMessage()).isEqualTo("낫싱");
    }
}
