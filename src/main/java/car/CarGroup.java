package car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarGroup {

	private final List<Car> cars;

	public CarGroup(List<String> carNames) {
		this.cars = Collections.unmodifiableList(mapCars(carNames));
	}

	private List<Car> mapCars(List<String> names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			CarName carName = CarName.of(name);
			cars.add(new Car(carName));
		}
		return cars;
	}

	public List<Car> getCars() {
		return cars;
	}
}
