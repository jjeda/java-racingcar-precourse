import java.util.Scanner;

import domain.Cars;
import wrapper.CarNames;

public class RaringGame {
	private final Scanner scanner;

	private RaringGame() {
		this.scanner = new Scanner(System.in);
	}

	public static RaringGame of() {
		return new RaringGame();
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
			cars.printBoard();
		}
	}

	private void finishGame(Cars cars) {
		final Cars winners = cars.getWinners();
		final CarNames winnerCarNames = winners.toCarNames();
		System.out.println(winnerCarNames.toString());
	}

	public static void main(String[] args) {
		final RaringGame racingGame = RaringGame.of();

		final Cars cars = racingGame.readyGame();

		racingGame.progressRacing(cars);

		racingGame.finishGame(cars);
	}
}
