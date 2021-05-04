package car;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarGroupTest {

	private static final int CAR_POSITION_ONE = 1;

	@ParameterizedTest
	@CsvSource(value = {"one:two:three"}, delimiter = ':')
	public void createCarGroupTest(String testCarOne, String testCarTwo, String testCarThree) {
		// given
		List<String> names = Arrays.asList(testCarOne, testCarTwo, testCarThree);
		CarGroup carGroup = CarGroup.of(names);
		// when
		List<Car> cars = carGroup.getCars();
		// then
		for (int i = 0; i < cars.size(); i++) {
			assertEqualCarName(cars.get(i), names.get(i));
		}
	}

	private void assertEqualCarName(Car car, String carName) {
		assertThat(car.getName()).isEqualTo(carName);
	}

	@Test
	@DisplayName("Car Group 의 Car 들을 참조해서 변경할 수 없다.")
	public void carsUnmodifiableTest() {
		// given
		CarGroup carGroup = CarGroup.of(Arrays.asList("car1", "car2"));
		// when
		List<Car> cars = carGroup.getCars();
		// then
		assertThatExceptionOfType(UnsupportedOperationException.class)
			.isThrownBy(() -> cars.add(new Car(CarName.of("Test"))));
	}

	@Test
	@DisplayName("이동조건이 만족되면 Car Group 에 있는 Car 들을 한번에 전진 시킨다.")
	public void moveForwardCarsTest() {
		CarGroup carGroup = CarGroup.of(Arrays.asList("car1", "car2"));
		carGroup.moveForward(() -> true);

		List<Car> cars = carGroup.getCars();
		for (Car car : cars) {
			assertThat(car.getPosition()).isEqualTo(CAR_POSITION_ONE);
		}
	}

	@Test
	@DisplayName("Car Group 은 최소한 하나의 Car 가 필요하다")
	public void emptyCarTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> CarGroup.of(new ArrayList<>()));
	}

	@Test
	@DisplayName("가장 많이 전진한 차 들이 winner 이다.")
	public void winnerTest() {
		// given
		Car car1 = new Car(CarName.of("car1"));
		moveForward(car1, 2);
		Car car2 = new Car(CarName.of("car2"));
		moveForward(car2, 2);
		Car car3 = new Car(CarName.of("car3"));
		moveForward(car3, 1);
		// when
		CarGroup carGroup = CarGroup.of(car1, car2, car3);
		List<Car> winners = carGroup.getWinners();
		// then
		assertThat(winners).containsExactly(car1, car2);
	}

	private void moveForward(Car car, int times) {
		for (int i = 0; i < times; i++) {
			car.moveForward(() -> true);
		}
	}
}
