package wrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import utils.CarNamesGenerator;

public class CarNames {
	private final List<CarName> carNames;

	private CarNames() {
		this.carNames = new LinkedList<>();
	}

	public static CarNames of() {
		return new CarNames();
	}

	public static CarNames inputOf(Scanner scanner) {
		final CarNamesGenerator generator = CarNamesGenerator.of(scanner);
		return generator.generate();
	}

	public void add(CarName carName) {
		carNames.add(carName);
	}

	public List<CarName> get() {
		return carNames;
	}

	@Override
	public String toString() {
		List<String> strings = new LinkedList<>();

		for (CarName carName : carNames) {
			strings.add(carName.toString());
		}

		String[] toStringArray = strings.toArray(new String[0]);
		return String.join(",", toStringArray) + "가 최종 우승했습니다.";
	}
}
