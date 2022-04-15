package baseball;

public class Referee {
    private final Ball comBall;

    public Referee(Ball comBall) {
        this.comBall = comBall;
    }

    public Ball getComBall() {
        return comBall;
    }

    public BallStatus judge(Ball playerBall) {
        if (comBall.equals(playerBall)){
            return BallStatus.STRIKE;
        }
        if (comBall.getNumber().equals(playerBall.getNumber())){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
}
