import java.util.Scanner;

import wrapper.CarNames;

public class RacingGame {
	private final Scanner scanner;

	private RacingGame() {
		this.scanner = new Scanner(System.in);
	}

	public static RacingGame of() {
		return new RacingGame();
	}

	public static void main(String[] args) {
		final RacingGame racingGame = RacingGame.of();
		final CarNames carNames = CarNames.inputOf(racingGame.scanner);
	}
}
