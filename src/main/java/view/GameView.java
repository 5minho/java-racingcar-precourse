package view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameView {
	static final String EMPTY_STRING = "";
	static final String CAR_NAMES_DELIMITER = ",";
	static final String CAR_POSITION_MARK = "-";
	static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
	static final String INPUT_MOVE_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?\n";

	private final Scanner scanner;
	private final PrintStream printStream;

	public GameView(InputStream inputStream, OutputStream outputStream) {
		this.scanner = new Scanner(inputStream);
		this.printStream = new PrintStream(outputStream);
	}

	public void printInputCarNamesMessage() {
		printStream.print(INPUT_CAR_NAMES_MESSAGE);
	}

	public List<String> inputCarNamesMessage() {
		String inputCarNames = scanner.next();
		return Arrays.asList(inputCarNames.split(CAR_NAMES_DELIMITER));
	}

	public void printInputMoveTryCountMessage() {
		printStream.print(INPUT_MOVE_TRY_COUNT_MESSAGE);
	}

	public MoveTryCount inputMoveTryCount() {
		return MoveTryCount.of(scanner.nextInt());
	}

	public void printMoveResult(CarMovingPositionDto carMovingPositionDto) {
		String positionMark = renderPositionMark(carMovingPositionDto.getPosition());
		String output = String.format("%s : %s", carMovingPositionDto.getName(), positionMark);
		printStream.println(output);
	}

	private String renderPositionMark(int position) {
		String positionMark = EMPTY_STRING;
		for (int i = 0; i < position; i++) {
			positionMark = positionMark.concat(CAR_POSITION_MARK);
		}
		return positionMark;
	}
}
