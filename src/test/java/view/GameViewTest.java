package view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameViewTest {
	static final String DEFAULT_INPUT_STRING = "";
	private ByteArrayOutputStream outputStream;

	@BeforeEach
	void setUp() {
		outputStream = new ByteArrayOutputStream();
	}

	@Test
	@DisplayName("사용자들에게 경주할 자동 이름을 입력하란 메시지를 보여준다.")
	public void printInputCarNamesMessage() {
		// given
		GameView gameView = createGameView(DEFAULT_INPUT_STRING, outputStream);
		// when
		gameView.printInputCarNamesMessage();
		// then
		assertThat(outputStream.toString()).isEqualTo(GameView.INPUT_CAR_NAMES_MESSAGE);
	}

	@ParameterizedTest
	@DisplayName("사용자들에게 경주할 자동차 이름을 입력받아 쉼표로 구분해야 한다.")
	@CsvSource(value = {"car1,car2:car1:car2", "879,&@(:879:&@("}, delimiter = ':')
	public void inputCarNamesMessage(String userInput, String expectedName1, String expectedName2) {
		// given
		GameView gameView = createGameView(userInput, outputStream);
		// when
		List<String> carNames = gameView.inputCarNamesMessage();
		// then
		assertThat(carNames.get(0)).isEqualTo(expectedName1);
		assertThat(carNames.get(1)).isEqualTo(expectedName2);
	}

	private GameView createGameView(String userInput, OutputStream outputStream) {
		InputStream byteArrayInputStream = new ByteArrayInputStream(userInput.getBytes());
		return new GameView(byteArrayInputStream, outputStream);
	}
}
