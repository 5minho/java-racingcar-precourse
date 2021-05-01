package car;

class CarName {

	private final String name;

	private CarName(String name) {
		validateNotEmpty(name);
		this.name = name;
	}

	private void validateNotEmpty(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("차 이름은 공백이 될 수 없습니다.");
		}
	}

	static CarName of(String name) {
		return new CarName(name);
	}

	String getName() {
		return name;
	}
}
