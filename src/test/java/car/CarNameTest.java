package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

	@ParameterizedTest
	@ValueSource(strings = "name")
	@DisplayName("차 이름은 하나의 문자열로 이루어진다.")
	public void carNameTest(String name) {
		//given
		CarName carName = CarName.of(name);
		// when then
		assertThat(carName.getName()).isEqualTo(name);
	}

	@Test
	@DisplayName("차 이름은 공백이 될 수 없다.")
	public void emptyCarNameTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> CarName.of(""));
	}

	@Test
	@DisplayName("차 이름은 5자 이상이 될 수 없다.")
	public void carNameLengthTest() {
		assertThat(CarName.of("12345").getName()).isEqualTo("12345");

		assertThatIllegalArgumentException().isThrownBy(() -> CarName.of("123456"));
	}
}
