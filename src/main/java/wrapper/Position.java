package wrapper;

public class Position {
	private int position;

	private Position() {
		this.position = 0;
	}

	public static Position of() {
		return new Position();
	}

	public int toInt() {
		return position;
	}

	public void plus() {
		position++;
	}
}
