package car;

import java.util.Random;

public class RandomNumberComparingCondition implements MoveCondition {
	static final int RANDOM_UPPER_BOUND = 10;
	static final int SATISFIED_NUMBER_LOWER_BOUND = 3;
	private final Random random;

	public RandomNumberComparingCondition(Random random) {
		this.random = random;
	}

	@Override
	public boolean isSatisfied() {
		return random.nextInt(RANDOM_UPPER_BOUND) > SATISFIED_NUMBER_LOWER_BOUND;
	}
}
