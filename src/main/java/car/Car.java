package car;

import static car.CarPosition.*;

public class Car {
	private final CarName name;
	private CarPosition position;

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

	void moveForward(Accelerator accelerator) {
		if (accelerator.pushed()) {
			this.position = position.movedForward();
		}
	}
}
