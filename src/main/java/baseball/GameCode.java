package baseball;

public enum GameCode {
    RESTART("1"),
    EXIT("2");

    private final String code;

    GameCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
