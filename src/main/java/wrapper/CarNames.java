package wrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import utils.CarNamesGenerator;

public class CarNames {
	private final List<CarName> names;

	private CarNames() {
		this.names = new LinkedList<>();
	}

	public static CarNames of() {
		return new CarNames();
	}

	public static CarNames inputOf(Scanner scanner) {
		final CarNamesGenerator generator = CarNamesGenerator.of();
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String input = scanner.next();
		while (!generator.isValidInput(input)) {
			System.out.println("잘못 입력하셨습니다.");
			input = scanner.next();
		}
		return generator.assignNames(input.split(","));
	}

	public void add(CarName carName) {
		names.add(carName);
	}

	public List<CarName> get() {
		return names;
	}

	@Override
	public String toString() {
		List<String> strings = new LinkedList<>();

		for (CarName carName : names) {
			strings.add(carName.toString());
		}

		String[] toStringArray = strings.toArray(new String[0]);
		return String.join(",", toStringArray) + "가 최종 우승했습니다.";
	}
}
