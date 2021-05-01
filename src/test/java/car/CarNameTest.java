package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

	@Test
	@DisplayName("차 이름은 하나의 문자열로 이루어진다.")
	public void carNameTest() {
		String expectedCarName = "5minho";
		CarName carName = CarName.of(expectedCarName);

		assertThat(carName.getName())
			.isEqualTo(expectedCarName);
	}

	@Test
	@DisplayName("차 이름은 공백이 될 수 없다.")
	public void emptyCarNameTest() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> CarName.of(""));
	}
}
