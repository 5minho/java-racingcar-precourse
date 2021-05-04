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

import view.dto.CarPositionDto;

public class GameViewTest {
	static final String DEFAULT_INPUT_STRING = "";
	private ByteArrayOutputStream outputStream;

	@BeforeEach
	void setUp() {
		outputStream = new ByteArrayOutputStream();
	}

	@Test
	@DisplayName("사용자들에게 경주할 자동 이름을 입력하란 메시지를 보여준다.")
	public void printInputCarNamesMessageTest() {
		// given
		GameView gameView = createGameViewWithUserInput(DEFAULT_INPUT_STRING, outputStream);
		// when
		gameView.printInputCarNamesMessage();
		// then
		assertThat(outputStream.toString()).isEqualTo(GameView.INPUT_CAR_NAMES_MESSAGE);
	}

	@ParameterizedTest
	@DisplayName("사용자들에게 경주할 자동차 이름을 입력받아 쉼표로 구분해야 한다.")
	@CsvSource(value = {"car1,car2:car1:car2", "879,&@(:879:&@("}, delimiter = ':')
	public void inputCarNamesMessageTest(String userInput, String expectedName1, String expectedName2) {
		// given
		GameView gameView = createGameViewWithUserInput(userInput, outputStream);
		// when
		List<String> carNames = gameView.inputCarNames();
		// then
		assertThat(carNames.get(0)).isEqualTo(expectedName1);
		assertThat(carNames.get(1)).isEqualTo(expectedName2);
	}

	@Test
	@DisplayName("사용자에게 전진 시도 횟수를 입력하라는 메시지를 보여준다.")
	public void printInputMoveTryCountMessageTest() {
		// given
		GameView gameView = createGameViewWithUserInput(DEFAULT_INPUT_STRING, outputStream);
		// when
		gameView.printInputMoveTryCountMessage();
		// then
		assertThat(outputStream.toString()).isEqualTo(GameView.INPUT_MOVE_TRY_COUNT_MESSAGE);
	}

	@ParameterizedTest
	@DisplayName("사용자에게 전진 시도 횟수를 입력받아야 한다.")
	@CsvSource(value = {"5:5"}, delimiter = ':')
	public void inputMoveCountTest(String userInputMoveCount, int expectedMoveCount) {
		// given
		GameView gameView = createGameViewWithUserInput(userInputMoveCount, outputStream);
		// when
		MoveTryCount moveTryCount = gameView.inputMoveTryCount();
		// then
		assertThat(moveTryCount.getCount()).isEqualTo(expectedMoveCount);
	}

	@Test
	@DisplayName("전진 시도 횟수로 음수는 입력할 수 없다.")
	public void inputMoveTryCountNegativeTest() {
		// given
		GameView gameView = createGameViewWithUserInput("-1", outputStream);
		// when, then
		assertThatIllegalArgumentException().isThrownBy(gameView::inputMoveTryCount);
	}

	@Test
	@DisplayName("자동차 하나의 이동 결과는 {이름} : {이동거리 * '-'} 형식으로 찍혀야 한다")
	public void printCarMoveResult() {
		// given
		GameView gameView = createGameViewWithUserInput(DEFAULT_INPUT_STRING, outputStream);
		CarPositionDto carPositionDto = new CarPositionDto("test", 1);
		// when
		gameView.printCarPosition(carPositionDto);
		// then
		assertThat(outputStream.toString()).isEqualTo("test : -\n");
	}

	private GameView createGameViewWithUserInput(String userInput, OutputStream outputStream) {
		InputStream byteArrayInputStream = new ByteArrayInputStream(userInput.getBytes());
		return new GameView(byteArrayInputStream, outputStream);
	}
}
