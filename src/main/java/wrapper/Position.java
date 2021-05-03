package wrapper;

import java.util.Objects;

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

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof Position)) {
			return false;
		}
		Position position1 = (Position)object;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
