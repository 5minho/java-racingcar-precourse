package car;

import static java.util.Collections.*;
import static util.ListUtils.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarGroup {
	private final List<Car> cars;

	private CarGroup(List<Car> cars) {
		validateHasCar(cars);
		this.cars = Collections.unmodifiableList(cars);
	}

	private void validateHasCar(List<Car> cars) {
		if (cars == null || cars.isEmpty()) {
			throw new IllegalArgumentException("CarGroup 은 최소한 하나의 Car 가 필요합니다.");
		}
	}

	public static CarGroup of(List<String> carNames) {
		List<Car> cars = map(carNames, (carName) -> new Car(CarName.of(carName)));
		return new CarGroup(cars);
	}

	static CarGroup of(Car... cars) {
		return new CarGroup(Arrays.asList(cars));
	}

	public List<Car> getCars() {
		return cars;
	}

	public void moveForward(MoveCondition moveCondition) {
		for (Car car : cars) {
			car.moveForward(moveCondition);
		}
	}

	public List<Car> getWinners() {
		Car fastestCar = max(cars);
		return filter(cars, fastestCar::equalPosition);
	}
}
