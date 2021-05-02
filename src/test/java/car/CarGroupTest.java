package car;

import static org.assertj.core.api.Assertions.*;

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
		CarGroup carGroup = new CarGroup(names);
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
		CarGroup carGroup = new CarGroup(Arrays.asList("car1", "car2"));
		// when
		List<Car> cars = carGroup.getCars();
		// then
		assertThatExceptionOfType(UnsupportedOperationException.class)
			.isThrownBy(() -> cars.add(new Car(CarName.of("Test"))));
	}

	@Test
	@DisplayName("이동조건이 만족되면 Car Group 에 있는 Car 들을 한번에 전진 시킨다.")
	public void moveForwardCarsTest() {
		CarGroup carGroup = new CarGroup(Arrays.asList("car1", "car2"));
		carGroup.moveForward(() -> true);

		List<Car> cars = carGroup.getCars();
		for (Car car : cars) {
			assertThat(car.getPosition()).isEqualTo(CAR_POSITION_ONE);
		}
	}
}
