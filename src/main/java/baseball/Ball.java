package baseball;

public class Ball {
    private final Position position;
    private final Number number;

    public Ball(Position position, Number number) {
        this.position = position;
        this.number = number;
    }

    public Position getPosition() {
        return position;
    }

    public Number getNumber() {
        return number;
    }
}
