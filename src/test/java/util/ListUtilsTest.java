package util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListUtilsTest {

	@Test
	@DisplayName("함수를 반복해 결과값을 리스트에 담아 리턴해야 한다.")
	public void mapRepeatTimesTest() {
		List<Integer> result = ListUtils.map(5, () -> 1);
		assertThat(result).containsExactly(1, 1, 1, 1, 1);
	}

	@Test
	@DisplayName("리스트에 매핑할 함수를 적용해 새로운 리스트를 리턴해야 한다.")
	public void mapTest() {
		List<String> result = ListUtils.map(Arrays.asList(1, 2, 3), String::valueOf);
		assertThat(result).containsExactly("1", "2", "3");
	}

	@Test
	@DisplayName("리스트를 필터링한 결과를 리턴해야 한다.")
	public void filterTest() {
		List<Integer> result = ListUtils.filter(Arrays.asList(1, 2, 3), num -> num > 2);
		assertThat(result).containsExactly(3);
	}

}
