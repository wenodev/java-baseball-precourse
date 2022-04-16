package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomsTest {
    @DisplayName("1 이상 9 이하 숫자를 만듭니다.")
    @RepeatedTest(100)
    void pickNumberInRange(){
         int number = Randoms.pickNumberInRange(1,9);
         assertThat(number).isGreaterThan(0);
        assertThat(number).isLessThan(10);
    }
}

