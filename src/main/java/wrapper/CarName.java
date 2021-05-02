package wrapper;

public class CarName {
	private final String name;

	private CarName(String name) {
		this.name = name;
	}

	public static CarName of(String name) {
		return new CarName(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
