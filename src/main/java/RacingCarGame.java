import java.util.List;

import car.CarGroup;
import car.MoveCondition;
import view.CarGroupPositionDto;
import view.CarRaceResultDto;
import view.GameView;
import view.MoveTryCount;

public class RacingCarGame {
	private final MoveCondition moveCondition;
	private final GameView gameView;

	public RacingCarGame(MoveCondition moveCondition, GameView gameView) {
		this.moveCondition = moveCondition;
		this.gameView = gameView;
	}

	public void run() {
		CarGroup carGroup = inputCarGroup();
		MoveTryCount moveTryCount = inputMoveTryCount();
		CarRaceResultDto carRaceResultDto = raceCars(carGroup, moveTryCount);
		gameView.printCarRaceResult(carRaceResultDto);
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

	CarRaceResultDto raceCars(CarGroup carGroup, MoveTryCount moveTryCount) {
		List<CarGroupPositionDto> carGroupMoves = moveTryCount.repeatToAdd(
			() -> {
				carGroup.moveForward(moveCondition);
				return CarDtoConverter.toDto(carGroup);
			}
		);
		return new CarRaceResultDto(carGroupMoves);
	}

	public static void main(String[] args) {
		GameView gameView = new GameView(System.in, System.out);
		RacingCarGame racingCarGame = new RacingCarGame(() -> true, gameView);
		racingCarGame.run();
	}
}
