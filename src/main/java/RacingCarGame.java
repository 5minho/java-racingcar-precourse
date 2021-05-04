import static util.ListUtils.*;

import java.util.List;
import java.util.Random;

import car.Car;
import car.CarGroup;
import car.MoveCondition;
import car.RandomNumberComparingCondition;
import view.GameView;
import view.MoveTryCount;
import view.dto.CarGroupPositionDto;
import view.dto.CarRaceResultDto;

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

	private CarGroup inputCarGroup() {
		gameView.printInputCarNamesMessage();
		return CarGroup.of(gameView.inputCarNames());
	}

	private MoveTryCount inputMoveTryCount() {
		gameView.printInputMoveTryCountMessage();
		return gameView.inputMoveTryCount();
	}

	CarRaceResultDto raceCars(CarGroup carGroup, MoveTryCount moveTryCount) {
		List<CarGroupPositionDto> carGroupPositions = map(moveTryCount.getCount(), () -> movedForward(carGroup));
		List<String> winnerNames = map(carGroup.getWinners(), Car::getName);
		return new CarRaceResultDto(carGroupPositions, winnerNames);
	}

	private CarGroupPositionDto movedForward(CarGroup carGroup) {
		carGroup.moveForward(moveCondition);
		return RacingCarDtoConverter.toCarGroupPositionDto(carGroup);
	}

	public static void main(String[] args) {
		GameView gameView = new GameView(System.in, System.out);
		MoveCondition moveCondition = new RandomNumberComparingCondition(new Random());
		RacingCarGame racingCarGame = new RacingCarGame(moveCondition, gameView);
		racingCarGame.run();
	}
}
