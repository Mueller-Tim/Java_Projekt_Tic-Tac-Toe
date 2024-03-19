package tictactoe;

/**
 * The Field class contains the value which are set by the players during the game
 */
public class Field {

	private int value;

	/**
	 * @return value of the field
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
