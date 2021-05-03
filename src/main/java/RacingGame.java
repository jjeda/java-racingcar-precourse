import java.util.Scanner;

import domain.Car;
import domain.Cars;
import wrapper.CarName;
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
		final Cars cars = Cars.of();
		for (CarName carName : carNames.get()) {
			cars.addCar(Car.of(carName));
		}
		return cars;
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
		final RacingGame racingGame = RacingGame.of();

		final Cars cars = racingGame.readyGame();

		racingGame.progressRacing(cars);

		racingGame.finishGame(cars);
	}
}
