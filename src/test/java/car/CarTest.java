package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

	private Car testCar;

	@BeforeEach
	void setUp() {
		CarName name = CarName.of("testCar");
		testCar = new Car(name);
	}

	@Test
	@DisplayName("차를 처음 생성하면 위치가 0 이다.")
	public void carInitialPositionTest() {
		assertThat(testCar.getPosition()).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
	@DisplayName("차 이동 조건에 따라 이면 한칸 전진하거나 전진하지 않는다.")
	public void carMoveForwardIfConditionIsTrueTest(boolean pushedAccelerator, int position) {
		testCar.moveForward(() -> pushedAccelerator);

		assertThat(testCar.getPosition()).isEqualTo(position);
	}
}
