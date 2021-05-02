package car;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RandomNumberComparingConditionTest {

	static class MockRandom extends Random {
		private final int fixedNumber;

		MockRandom(int fixedNumber) {
			this.fixedNumber = fixedNumber;
		}

		@Override
		public int nextInt(int bound) {
			return fixedNumber;
		}
	}

	@ParameterizedTest
	@DisplayName("랜덤 숫자가 4 이상일 때만 전진 할 수 있다.")
	@CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
	public void randomMoveConditionTest(int randomNum, boolean isMoreThanFour) {
		Random random = new MockRandom(randomNum);
		RandomNumberComparingCondition randomNumberComparingCondition = new RandomNumberComparingCondition(random);
		boolean canMove = randomNumberComparingCondition.isSatisfied();
		assertThat(canMove).isEqualTo(isMoreThanFour);
	}

}
