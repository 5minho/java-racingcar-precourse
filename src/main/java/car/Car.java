package car;

import static car.CarPosition.*;

public class Car {
	private final CarName name;
	private final CarPosition position;

	Car(CarName name) {
		this.name = name;
		this.position = ZERO;
	}

	public int getPosition() {
		return position.getPosition();
	}

	public String getName() {
		return name.getName();
	}
}
