package view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MoveTryCount {
	public static final int INITIAL_LOOP_COUNT = 0;
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

	public <R> List<R> repeatToAdd(Supplier<R> supplier) {
		List<R> list = new ArrayList<>();
		for (int i = INITIAL_LOOP_COUNT; i < count; i++) {
			list.add(supplier.get());
		}
		return list;
	}
}
