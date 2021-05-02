import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import car.Car;
import car.CarGroup;
import view.GameView;
import view.MoveTryCount;

public class RacingCarGameTest {

	@Test
	@DisplayName("차를 N 번 반복해서 전진 시킬 수 있다.")
	public void moveForwardTest() {
		// given
		final int moveCount = 5;
		CarGroup carGroup = new CarGroup(Arrays.asList("one", "two"));
		RacingCarGame racingCarGame = new RacingCarGame(() -> true, new GameView(System.in, System.out));
		// when
		racingCarGame.raceCars(carGroup, MoveTryCount.of(moveCount));
		// then
		for (Car car : carGroup.getCars()) {
			assertThat(car.getPosition()).isEqualTo(moveCount);
		}
	}
}
