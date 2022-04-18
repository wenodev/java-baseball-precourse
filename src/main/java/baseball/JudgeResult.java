package baseball;

import java.util.Objects;

public class JudgeResult {
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final int ANSWER = 3;

    private int strike;
    private int ball;

    public JudgeResult() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus status) {
        if (status.equals(BallStatus.STRIKE)){
            strike++;
        }
        if (status.equals(BallStatus.BALL)){
            ball++;
        }
    }

    public String toMessage(){
        StringBuilder stringBuilder = new StringBuilder();
        if (strike == 0 && ball== 0){
            return NOTHING_MESSAGE;
        }
        if (ball > 0){
            stringBuilder.append(ball).append(BALL_MESSAGE);
        }
        if (strike > 0){
            stringBuilder.append(strike).append(STRIKE_MESSAGE);
        }
        return stringBuilder.toString().trim();
    }

    public boolean isAnswer() {
        return strike == ANSWER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JudgeResult that = (JudgeResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
