package car;

class CarName {
	private static final int MAX_CAR_LENGTH = 5;
	private final String name;

	private CarName(String name) {
		validateHasText(name);
		validateLength(name);
		this.name = name;
	}

	private void validateHasText(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("차 이름은 공백이 될 수 없습니다.");
		}
	}

	private void validateLength(String name) {
		if (name.length() > MAX_CAR_LENGTH) {
			throw new IllegalArgumentException("차 이름은 5자 이상만 될 수 있습니다.");
		}
	}

	static CarName of(String name) {
		return new CarName(name);
	}

	String getName() {
		return name;
	}
}
