package baseball;

import java.util.List;

public class Referee {
    private final Balls computerBalls;

    public Referee(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    public Balls getComputerBalls() {
        return computerBalls;
    }

    public JudgeResult judgeBalls(Balls source) {
        JudgeResult judgeResult = new JudgeResult();
        List<Ball> playerBalls = source.getValues();
        for (Ball ball : playerBalls){
            judgeResult.report(judgeBall(ball));
        }
        return judgeResult;
    }

    public BallStatus judgeBall(Ball playerBall) {
        BallStatus ballStatus = BallStatus.NOTHING;
        for (Ball ball : computerBalls.getValues()){
            ballStatus = findStatus(playerBall, ball, ballStatus);
        }
        return ballStatus;
    }

    private BallStatus findStatus(Ball playerBall, Ball ball, BallStatus ballStatus) {
        if (ball.compare(playerBall) != BallStatus.NOTHING){
            ballStatus = ball.compare(playerBall);
        }
        return ballStatus;
    }
}
