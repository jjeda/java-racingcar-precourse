import java.util.Scanner;

import domain.Cars;
import wrapper.CarNames;

public class RacingGame {
	private final Scanner scanner;

	private RacingGame() {
		this.scanner = new Scanner(System.in);
	}

	public static RacingGame of() {
		return new RacingGame();
	}

	private Cars readyGame() {
		final CarNames carNames = CarNames.inputOf(scanner);
		return Cars.readyOf(carNames);
	}

	private void progressRacing(Cars cars) {
		System.out.println("시도할 회수는 몇회인가요?");
		int tryCount = scanner.nextInt();

		System.out.println("실행 결과");

		while (tryCount-- > 0) {
			cars.race();
		}
	}

	public static void main(String[] args) {
		final RacingGame racingGame = RacingGame.of();

		final Cars cars = racingGame.readyGame();

		racingGame.progressRacing(cars);
	}
}
