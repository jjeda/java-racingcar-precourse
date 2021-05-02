package domain;

import wrapper.CarName;
import wrapper.Position;

public class Car implements Comparable<Car> {
	private static final int THRESHOLD_NUMBER = 4;
	private static final String INACTIVE_CAR_NAME = "Inactive Car";
	private final CarName name;
	private Position position;
	private final CarStatus carStatus;

	private Car(CarName name, CarStatus carStatus) {
		this.name = name;
		this.carStatus = carStatus;
		position = Position.of();
	}

	public static Car of(CarName name) {
		return new Car(name, CarStatus.ACTIVE);
	}

	public static Car inActiveOf() {
		return new Car(CarName.of(INACTIVE_CAR_NAME), CarStatus.INACTIVE);
	}

	public CarName getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	public boolean isActive() {
		return carStatus == CarStatus.ACTIVE;
	}

	public void printPath() {
		System.out.print(name.toString() + " : ");

		int currentPosition = position.toInt();
		while (currentPosition-- > 0) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void go(int randomNumber) {
		if (randomNumber >= THRESHOLD_NUMBER) {
			position.plus();
		}
	}

	public boolean isWinner(Position record) {
		return position == record;
	}

	@Override
	public int compareTo(Car car) {
		if (position.toInt() > car.getPosition().toInt()) {
			return 1;
		}
		return -1;
	}
}
