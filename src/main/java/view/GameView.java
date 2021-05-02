package view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameView {
	static final String CAR_NAMES_DELIMITER = ",";
	static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

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
}
