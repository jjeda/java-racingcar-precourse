package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wrapper.CarName;
import wrapper.Position;

class CarTest {
	private static final int REPETITION = 3;
	private static final int MORE_THAN_FOUR = 4;

	@Test
	@DisplayName("차의 상태가 ACTIVE 일 경우 true 리턴")
	void isActive_shouldReturnTrue_whenCarStatusActive() {
		// given
		final CarName carName = CarName.of("car");
		final Car car = Car.of(carName);

		// when
		boolean isActive = car.isActive();

		// then
		assertTrue(isActive);
	}

	@Test
	@DisplayName("차의 상태가 ACTIVE 가 아닐 경우 false 리턴")
	void isActive_shouldReturnFalse_whenCarStatusInActive() {
		// given
		Car inActiveCar = Car.inActiveOf();

		// when
		boolean isActive = inActiveCar.isActive();

		// then
		assertFalse(isActive);
	}

	@Test
	@DisplayName("랜덤 숫자가 4이상일 경우 전진")
	void go_shouldMoveForward_whenRandomNumberMoreThanFour() {
		// given
		final CarName carName = CarName.of("car");
		final Car car = Car.of(carName);
		int prevPosition = car.getPosition().toInt();

		// when
		car.go(MORE_THAN_FOUR);
		int currentPosition = car.getPosition().toInt();

		// then
		assertNotEquals(prevPosition, currentPosition);
		assertEquals(0, prevPosition);
		assertEquals(1, currentPosition);
	}

	@Test
	@DisplayName("랜덤 숫자가 3 이하일 경우 정지")
	void go_shouldStop_whenRandomNumberlessThanThree() {
		// given
		final CarName carName = CarName.of("car");
		final Car car = Car.of(carName);
		int lessThanThree = 3;
		int prevPosition = car.getPosition().toInt();

		// when
		car.go(lessThanThree);
		int currentPosition = car.getPosition().toInt();

		// then
		assertEquals(prevPosition, currentPosition);
		assertEquals(0, currentPosition);
	}

	@Test
	@DisplayName("자신이 승자일 경우 true 리턴")
	void isWinner_shouldReturnTrue_whenTheRecordIsTheSame() {
		// given
		final CarName carName = CarName.of("car");
		final Car car = Car.of(carName);
		final Position record = Position.of();

		// when
		for (int i = 0; i < REPETITION; i++) {
			record.plus();
			car.go(MORE_THAN_FOUR);
		}
		boolean isWinner = car.isWinner(record);

		// then
		assertTrue(isWinner);
		assertEquals(car.getPosition(), record);
	}

	@Test
	@DisplayName("자신이 승자가 아닐 경우 flase 리턴")
	void isWinner_shouldReturnFalse_whenTheRecordIsNotSame() {
		// given
		final CarName carName = CarName.of("car");
		final Car car = Car.of(carName);
		final Position record = Position.of();

		// when
		for (int i = 0; i < REPETITION; i++) {
			record.plus();
		}
		boolean isWinner = car.isWinner(record);

		// then
		assertFalse(isWinner);
		assertNotEquals(car.getPosition(), record);
	}
}