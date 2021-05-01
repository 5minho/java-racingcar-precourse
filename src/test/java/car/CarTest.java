package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("차를 처음 생성하면 위치가 0 이다.")
	public void carInitialPositionTest() {
		CarName name = CarName.of("5minho");
		Car car = new Car(name);

		assertThat(car.getPosition()).isEqualTo(0);
		assertThat(car.getName()).isEqualTo("5minho");
	}
}
