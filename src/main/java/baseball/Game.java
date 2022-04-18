package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String INPUT_GUIDE_MESSAGE = "3개의 연속된 숫자를 입력하세요.";
    private static final String ANSWER_GUIDE_MESSAGE = "정답입니다. 새로운 게임은 1번, 게임 종료는 2번 입력하세요.";
    private static final String INVALID_GAME_CODE_MESSAGE = "1 혹은 2를 입력해야 합니다.";

    private Referee referee;
    private NumberGenerator numberGenerator;

    public Game(NumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
        init();
    }

    private void init() {
        GameCode code;
        do {
            code = start();
        } while (code.equals(GameCode.RESTART));
    }

    private GameCode start() {
        referee = new Referee(new Balls(numberGenerator.generate()));
        play();
        return end();
    }

    private void play() {
        JudgeResult judgeResult;
        do {
            View.print(INPUT_GUIDE_MESSAGE);
            Balls playerBalls = getPlayerBalls();
            judgeResult = referee.judgeBalls(playerBalls);
            View.print(judgeResult.toMessage());
        } while (!judgeResult.isAnswer());
    }

    private Balls getPlayerBalls() {
        return new Balls(Console.readLine());
    }

    private GameCode end() {
        View.print(ANSWER_GUIDE_MESSAGE);
        return getGameExitCode();
    }

    private GameCode getGameExitCode() {
        String input = Console.readLine();
        if (GameCode.RESTART.getCode().equals(input)) {
            return GameCode.RESTART;
        }
        if (GameCode.EXIT.getCode().equals(input)) {
            return GameCode.EXIT;
        }
        throw new IllegalThreadStateException(INVALID_GAME_CODE_MESSAGE);
    }
}
