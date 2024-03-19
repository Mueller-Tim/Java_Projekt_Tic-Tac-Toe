package tictactoe;

/**
 * 
 * PlayingField is responsible for the management of setting and getting values to its individual fields
 * 
 */
public class PlayingField {

	private Field a1;
	private Field a2;
	private Field a3;
	private Field b1;
	private Field b2;
	private Field b3;
	private Field c1;
	private Field c2;
	private Field c3;

	/**
	 * Default constructor with default values for the fields
	 */
	public PlayingField() {
		a1 = new Field();
		a2 = new Field();
		a3 = new Field();
		b1 = new Field();
		b2 = new Field();
		b3 = new Field();
		c1 = new Field();
		c2 = new Field();
		c3 = new Field();
	}

	/**
	 * 
	 * Get the value of a playing field
	 * 
	 * @param input
	 * @return value of field
	 */
	public int getFieldValue(String input) {
		return getFieldWithInput(input).getValue();

	}

	/**
	 * 
	 * Set the value of a playingfield
	 * 
	 * @param input
	 */
	public void assignValueToField(String input, int value) {
		getFieldWithInput(input).setValue(value);
	}

	/**
	 * returns a field on the playing field of the matched input
	 * @param input
	 * @return matching field to input
	 */
	public Field getFieldWithInput(String input) {
		if (input.charAt(0) == 'A') {
			if (input.charAt(1) == '1') {
				return a1;
			} else if (input.charAt(1) == '2') {
				return a2;
			} else {
				return a3;
			}
		} else if (input.charAt(0) == 'B') {
			if (input.charAt(1) == '1') {
				return b1;
			} else if (input.charAt(1) == '2') {
				return b2;
			} else {
				return b3;
			}
		} else {
			if (input.charAt(1) == '1') {
				return c1;
			} else if (input.charAt(1) == '2') {
				return c2;
			} else {
				return c3;
			}
		}
	}
}
