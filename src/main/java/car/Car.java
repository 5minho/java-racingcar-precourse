package car;

import static car.CarPosition.*;

public class Car implements Comparable<Car> {
	private final CarName name;
	private CarPosition position;

	Car(CarName name) {
		this.name = name;
		this.position = INITIAL_POSITION;
	}

	public int getPosition() {
		return position.getPosition();
	}

	public String getName() {
		return name.getName();
	}

	void moveForward(MoveCondition moveCondition) {
		if (moveCondition.isSatisfied()) {
			this.position = position.movedForward();
		}
	}

	boolean equalPosition(Car otherCar) {
		return this.position.equals(otherCar.position);
	}

	@Override
	public int compareTo(Car otherCar) {
		return this.position.compareTo(otherCar.position);
	}
}
