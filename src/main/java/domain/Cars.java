package domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import wrapper.CarNames;
import wrapper.Position;

public class Cars {
	private static final int UPPER_BOUND = 10;
	private final List<Car> cars;
	private final Random random;

	private Cars() {
		this.cars = new LinkedList<>();
		this.random = new Random();
	}

	public static Cars of() {
		return new Cars();
	}

	public void addCar(Car car) {
		if (!car.isActive()) {
			return;
		}
		cars.add(car);
	}

	public void printBoard() {
		for (Car car : cars) {
			final int randomNumber = random.nextInt(UPPER_BOUND);
			car.go(randomNumber);
			car.printPath();
		}
		System.out.println("\n");
	}

	public Cars getWinners() {
		final Cars winnerCars = Cars.of();
		final Position record = findWinnerRecord();

		for (Car car : cars) {
			winnerCars.addCar(determineWinner(car, record));
		}
		return winnerCars;
	}

	private Position findWinnerRecord() {
		final Car winner = Collections.max(cars);
		return winner.getPosition();
	}

	private Car determineWinner(Car car, Position record) {
		if (car.isWinner(record)) {
			return car;
		}
		return Car.inActiveOf();
	}

	public CarNames toCarNames() {
		final CarNames carNames = CarNames.of();
		for (Car car : cars) {
			carNames.add(car.getName());
		}
		return carNames;
	}
}
