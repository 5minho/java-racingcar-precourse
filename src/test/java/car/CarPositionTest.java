package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarPositionTest {

	@Test
	@DisplayName("차 위치는 integer 값을 하나로 이루어져 있다")
	public void carPositionTest() {
		int expectedPosition = 1;
		CarPosition carPosition = CarPosition.of(expectedPosition);

		assertThat(carPosition.getPosition())
			.isEqualTo(expectedPosition);
	}

	@Test
	@DisplayName("차 위치는 음수가 될 수 없다.")
	public void negativeCarPositionTest() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> CarPosition.of(-1));
	}

	@Test
	@DisplayName("차 위치 값으로 동등성을 비교한다.")
	public void carEqualityTest() {
		assertThat(CarPosition.of(0))
			.isEqualTo(CarPosition.of(0));
	}

}
