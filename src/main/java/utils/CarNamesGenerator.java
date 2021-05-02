package utils;

import java.util.Scanner;

import wrapper.CarName;
import wrapper.CarNames;

public class CarNamesGenerator {
	private final Scanner scanner;

	private CarNamesGenerator(Scanner scanner) {
		this.scanner = scanner;
	}

	public static CarNamesGenerator of(Scanner scanner) {
		return new CarNamesGenerator(scanner);
	}

	public CarNames generate() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String input;
		while (!isValidInput(input = scanner.next())) {
			System.out.println("잘못 입력하셨습니다.");
		}
		final String[] inputNames = input.split(",");

		return assignNames(inputNames);
	}

	private boolean isValidInput(String input) {
		return true;
	}

	private CarNames assignNames(String[] inputNames) {
		final CarNames carNames = CarNames.of();

		for (String name : inputNames) {
			final CarName carName = CarName.of(name);
			carNames.add(carName);
		}
		return carNames;
	}
}
