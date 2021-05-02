import car.CarGroup;
import car.MoveCondition;

public class RacingCarGame {
	public static final int INITIAL_LOOP_COUNT = 0;
	private final MoveCondition moveCondition;

	public RacingCarGame(MoveCondition moveCondition) {
		this.moveCondition = moveCondition;
	}

	public void raceCars(CarGroup carGroup, int moveCount) {
		for (int i = INITIAL_LOOP_COUNT; i < moveCount; i++) {
			carGroup.moveForward(moveCondition);
		}
	}
}
