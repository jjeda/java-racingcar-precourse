package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wrapper.CarName;
import wrapper.CarNames;

class CarsTest {
	private static final int REPETITION = 3;
	private static final int MORE_THAN_FOUR = 4;

	@Test
	@DisplayName("정상적으로 우승 자동차를 포함")
	void getWinners_shouldContainsWinner() {
		// given
		final Cars cars = readyTest();
		Car winner = Car.of(CarName.of("winner"));

		for (int i = 0; i < REPETITION; i++) {
			winner.go(MORE_THAN_FOUR);
		}
		cars.addCar(winner);

		// when
		Cars getWinners = cars.getWinners();
		CarNames winnerCarNames = getWinners.toCarNames();

		// then
		final List<CarName> carNames = winnerCarNames.get();
		assertTrue(carNames.contains(winner.getName()));
		assertEquals(1, carNames.size());
	}

	@Test
	@DisplayName("여러명이 우승일 경우 모두 포함")
	void getWinners_shouldContainsAllWinners() {
		// given
		final Cars cars = readyTest();
		Car winner1 = Car.of(CarName.of("winner1"));
		Car winner2 = Car.of(CarName.of("winner2"));

		for (int i = 0; i < REPETITION; i++) {
			winner1.go(MORE_THAN_FOUR);
			winner2.go(MORE_THAN_FOUR);
		}
		cars.addCar(winner1);
		cars.addCar(winner2);

		// when
		Cars getWinners = cars.getWinners();
		CarNames winnerCarNames = getWinners.toCarNames();

		// then
		final List<CarName> carNames = winnerCarNames.get();
		assertTrue(carNames.contains(winner1.getName()));
		assertTrue(carNames.contains(winner2.getName()));
		assertEquals(2, carNames.size());
	}

	private Cars readyTest() {
		Cars cars = Cars.of();
		cars.addCar(Car.of(CarName.of("car1")));
		cars.addCar(Car.of(CarName.of("car2")));
		cars.addCar(Car.of(CarName.of("car3")));

		return cars;
	}
}