package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeResultTest {

    @DisplayName("strike와 ball 정보를 수정한다.")
    @Test
    void report(){
        JudgeResult judgeResult = new JudgeResult();

        judgeResult.report(BallStatus.STRIKE);

        assertThat(judgeResult.getStrike()).isEqualTo(1);
        assertThat(judgeResult.getBall()).isEqualTo(0);
    }

}
