package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import wrapper.CarName;
import wrapper.CarNames;

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

	public static Cars readyOf(CarNames carNames) {
		final Cars readyCars = new Cars();

		for (CarName carName : carNames.get()) {
			readyCars.addCar(Car.of(carName));
		}

		return readyCars;
	}

	private void addCar(Car car) {
		if (!car.isActive()) {
			return;
		}
		cars.add(car);
	}

	public void race() {
		for (Car car : cars) {
			final int randomNumber = random.nextInt(UPPER_BOUND);
			car.go(randomNumber);
		}
	}
}
