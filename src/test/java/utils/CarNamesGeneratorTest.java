package utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import wrapper.CarName;
import wrapper.CarNames;

class CarNamesGeneratorTest {

	private final CarNamesGenerator carNamesGenerator = CarNamesGenerator.of();

	@Test
	@DisplayName("정상적인 String 을 받았을 때 true 리턴")
	void isValidInput_shouldReturnTrue() {
		// given
		String commaSeparatedString = "a,b,c";

		// when
		boolean isValid = carNamesGenerator.isValidInput(commaSeparatedString);

		// then
		assertTrue(isValid);
	}

	@Test
	@DisplayName("comma 가 없을 때 false 리턴")
	void isValidInput_shouldReturnFalse_notIncludedComma() {
		// given
		String noCommaString = "abc";

		// when
		boolean isValid = carNamesGenerator.isValidInput(noCommaString);

		// then
		assertFalse(isValid);
	}

	@Test
	@DisplayName("comma 가 중간에 있지 않을 때 false 리턴")
	void isValidInput_shouldReturnFalse_unExpectedComma() {
		// given
		String unExpectedCommaString = ",abc";

		// when
		boolean isValid = carNamesGenerator.isValidInput(unExpectedCommaString);

		// then
		assertFalse(isValid);
	}

	@ParameterizedTest
	@DisplayName("comma 로 구분되는 문자열이 공백인 경우 false 리턴")
	@ValueSource(strings = {",abc", "abc,", "a,,bc", "a,bcdefg"})
	void isValidInput_shouldReturnFalse_unExpectedLength(String unExpectedString) {
		// given value source

		// when
		boolean isValid = carNamesGenerator.isValidInput(unExpectedString);

		// then
		assertFalse(isValid);
	}

	@Test
	@DisplayName("comma 로 구분되는 문자열이 5자를 초과하는 경우 false 리턴")
	void isValidInput_shouldReturnFalse_unExpectedLength2() {
		// given
		String longerString = "abcdef";
		String unExpectedString = longerString + ",g";

		// when
		assertTrue(longerString.length() > 5);
		boolean isValid = carNamesGenerator.isValidInput(unExpectedString);

		// then
		assertFalse(isValid);
	}

	@Test
	@DisplayName("정상적으로 자동차 이름을 부여")
	void assignNames_() {
		// given
		String[] strings = {"name1", "name2"};

		// when
		CarNames carnames = carNamesGenerator.assignNames(strings);

		// then
		final List<CarName> list = carnames.get();
		assertEquals(strings.length, list.size());
		assertEquals(strings[0], list.get(0).toString());
		assertEquals(strings[1], list.get(1).toString());
	}
}