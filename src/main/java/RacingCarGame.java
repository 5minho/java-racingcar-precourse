import java.util.List;

import car.CarGroup;
import car.MoveCondition;
import view.GameView;
import view.MoveTryCount;

public class RacingCarGame {
	public static final int INITIAL_LOOP_COUNT = 0;
	private final MoveCondition moveCondition;
	private final GameView gameView;

	public RacingCarGame(MoveCondition moveCondition, GameView gameView) {
		this.moveCondition = moveCondition;
		this.gameView = gameView;
	}

	public void run() {
		CarGroup carGroup = inputCarGroup();
		MoveTryCount moveTryCount = inputMoveTryCount();
		raceCars(carGroup, moveTryCount);
		// 우승 출력
	}

	MoveTryCount inputMoveTryCount() {
		gameView.printInputMoveTryCountMessage();
		return gameView.inputMoveTryCount();
	}

	CarGroup inputCarGroup() {
		gameView.printInputCarNamesMessage();
		List<String> carNames = gameView.inputCarNamesMessage();
		return new CarGroup(carNames);
	}

	void raceCars(CarGroup carGroup, MoveTryCount moveCount) {
		for (int i = INITIAL_LOOP_COUNT; i < moveCount.getCount(); i++) {
			carGroup.moveForward(moveCondition);
		}
	}

	public static void main(String[] args) {
		GameView gameView = new GameView(System.in, System.out);
		RacingCarGame racingCarGame = new RacingCarGame(() -> true, gameView);
		racingCarGame.run();
	}
}
