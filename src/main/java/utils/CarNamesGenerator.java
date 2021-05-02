package utils;

import java.util.LinkedList;
import java.util.List;

import wrapper.CarName;
import wrapper.CarNames;

public class CarNamesGenerator {
	private static final int MIN_STRING_LENGTH = 1;
	private static final int MAX_STRING_LENGTH = 5;

	private CarNamesGenerator() {
	}

	public static CarNamesGenerator of() {
		return new CarNamesGenerator();
	}

	public boolean isValidInput(String input) {
		if (!input.contains(",") || input.charAt(input.length() - 1) == ',') {
			return false;
		}

		String[] separatedString = input.split(",");
		List<Boolean> check = new LinkedList<>();
		for (String string : separatedString) {
			check.add(isValidString(string));
		}
		return !check.contains(Boolean.FALSE);
	}

	private boolean isValidString(String string) {
		int length = string.length();
		return length >= MIN_STRING_LENGTH && length <= MAX_STRING_LENGTH;
	}

	public CarNames assignNames(String[] inputNames) {
		final CarNames carNames = CarNames.of();

		for (String name : inputNames) {
			final CarName carName = CarName.of(name);
			carNames.add(carName);
		}
		return carNames;
	}
}
