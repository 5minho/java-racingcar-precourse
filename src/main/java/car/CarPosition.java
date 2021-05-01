package car;

import java.util.Objects;

class CarPosition {
	static final CarPosition ZERO = new CarPosition(0);
	private final int position;

	private CarPosition(int position) {
		validateNotNegative(position);
		this.position = position;
	}

	private void validateNotNegative(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("차 위치는 음수가 될 수 없습니다.");
		}
	}

	static CarPosition of(int position) {
		return new CarPosition(position);
	}

	int getPosition() {
		return position;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		CarPosition that = (CarPosition)other;
		return position == that.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
