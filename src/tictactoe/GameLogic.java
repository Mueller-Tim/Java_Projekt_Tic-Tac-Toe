package tictactoe;

/**
 * 
 * The GameLogic class is responsible for the management of the TicTacToe game logic.
 * This includes using helper classes to get user input and printing the appropriate response, considering the input and the current state of the game
 *
 */
public class GameLogic {

	private PlayingField playingField;
	private InputManager inputManager;
	private OutputManager outputManager;
	private int player;

	public GameLogic() {
		playingField = new PlayingField();
		inputManager = new InputManager();
		outputManager = new OutputManager();
		player = 1;
	}

	/**
	 * Start new game
	 */
	public void start() {
		outputManager.printGreeting();

		do {
			outputManager.printPlayingField(playingField);
			outputManager.printInputRequest(player);
			handleInput(inputManager.getInput(), player);
		} while (!isGameOver());
		inputManager.closeScanner();
	}
	
	private void handleInput(String input, int player) {
		if (input.equals("HELP")) {
			outputManager.printHelpMenu();
		} else if (input.equals("SWITCH")) {
			outputManager.switchLanguage();
		} else if (input.equals("ERROR")) {
			outputManager.printErrorInvalidInput();
		} else if (isMoveLegal(input)) {
			updateField(input, player);
		} else {
			outputManager.printErrorIllegalInput(input);
		}
	}


	private void updateField(String input, int player) {
		playingField.assignValueToField(input, player);

		if (player == 1) {
			this.player = -1;
		} else {
			this.player = 1;
		}
	}


	private boolean isMoveLegal(String input) {
		if (playingField.getFieldValue(input) == 0) {
			return true;
		} else {
			return false;
		}

	}

	private boolean isGameDraw() {
		if ((playingField.getFieldValue("A1") != 0) && (playingField.getFieldValue("A2") != 0)
				&& (playingField.getFieldValue("A3") != 0) && (playingField.getFieldValue("B1") != 0)
				&& (playingField.getFieldValue("B2") != 0) && (playingField.getFieldValue("B3") != 0)
				&& (playingField.getFieldValue("C1") != 0) && (playingField.getFieldValue("C2") != 0)
				&& (playingField.getFieldValue("C3") != 0)) {
			return true;
		}

		return false;
	}

	private boolean isGameWon() {
		if ((playingField.getFieldValue("A1") == playingField.getFieldValue("A2")) && (playingField.getFieldValue("A1") == playingField.getFieldValue("A3"))
				&& (playingField.getFieldValue("A1") != 0)) {
			return true;
		}

		if ((playingField.getFieldValue("B1") == playingField.getFieldValue("B2")) && (playingField.getFieldValue("B1") == playingField.getFieldValue("B3"))
				&& (playingField.getFieldValue("B1") != 0)) {
			return true;
		}

		if ((playingField.getFieldValue("C1") == playingField.getFieldValue("C2")) && (playingField.getFieldValue("C1") == playingField.getFieldValue("C3"))
				&& (playingField.getFieldValue("C1") != 0)) {
			return true;
		}

		if ((playingField.getFieldValue("A1") == playingField.getFieldValue("B1")) && (playingField.getFieldValue("A1") == playingField.getFieldValue("C1"))
				&& (playingField.getFieldValue("A1") != 0)) {
			return true;
		}

		if ((playingField.getFieldValue("A2") == playingField.getFieldValue("B2")) && (playingField.getFieldValue("A2") == playingField.getFieldValue("C2"))
				&& (playingField.getFieldValue("A2") != 0)) {
			return true;
		}

		if ((playingField.getFieldValue("A3") == playingField.getFieldValue("B3")) && (playingField.getFieldValue("A3") == playingField.getFieldValue("C3"))
				&& (playingField.getFieldValue("A3") != 0)) {
			return true;
		}

		if ((playingField.getFieldValue("A1") == playingField.getFieldValue("B2")) && (playingField.getFieldValue("A1") == playingField.getFieldValue("C3"))
				&& (playingField.getFieldValue("A1") != 0)) {
			return true;
		}

		if ((playingField.getFieldValue("C1") == playingField.getFieldValue("B2")) && (playingField.getFieldValue("C1") == playingField.getFieldValue("A3"))
				&& (playingField.getFieldValue("C1") != 0)) {
			return true;
		}

		return false;
	}

	private boolean isGameOver() {

		if (isGameWon()) {
			outputManager.printPlayingField(playingField);
			if (player == 1) {
				player = -1;
			} else {
				player = 1;
			}
			outputManager.printVictory(player);
			return true;
		}

		if (isGameDraw()) {
			outputManager.printPlayingField(playingField);
			outputManager.printDraw();
			return true;
		}

		return false;
	}

}
