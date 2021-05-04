package view;

public class MoveTryCount {
	private static final int MOVE_TRY_COUNT_MIN = 0;
	private final int count;

	private MoveTryCount(int count) {
		validateNotNegative(count);
		this.count = count;
	}

	private void validateNotNegative(int count) {
		if (count < MOVE_TRY_COUNT_MIN) {
			throw new IllegalArgumentException("전진 시도 횟수는 음수가 될 수 없습니다.");
		}
	}

	public static MoveTryCount of(int count) {
		return new MoveTryCount(count);
	}

	public int getCount() {
		return count;
	}
}
