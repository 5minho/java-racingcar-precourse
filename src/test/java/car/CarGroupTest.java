package car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarGroupTest {

	@ParameterizedTest
	@CsvSource(value = {"one:two:three"}, delimiter = ':')
	public void createCarGroupTest(String testCarOne, String testCarTwo, String testCarThree) {
		List<String> names = Arrays.asList(testCarOne, testCarTwo, testCarThree);
		CarGroup carGroup = new CarGroup(names);

		List<Car> cars = carGroup.getCars();
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
		CarGroup carGroup = new CarGroup(Arrays.asList("carOne", "carTwo"));

		List<Car> cars = carGroup.getCars();

		assertThatExceptionOfType(UnsupportedOperationException.class)
			.isThrownBy(() -> cars.add(new Car(CarName.of("Test"))));
	}
}
