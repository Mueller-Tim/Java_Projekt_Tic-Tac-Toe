package tictactoe;

import java.util.Objects;

/**
 * OutputManager is responsible for printing information to the console.
 * When an object gets initialised, the current language will be set. 
 * Default value is English, although this can be changed via a constructor argument.
 * 
 */
public class OutputManager {

	private String currentLanguage;

	private final String GREETING_ENG = "Welcome to TicTacToe! For help type \"help\"";
	private final String INPUT_REQUEST_ENG = "please choose a field: ";
	private final String HELP_ENG = "The Player needs to input the field to set his symbol for example \"A1\".\n" +
			"The first player who has a line of three same symbols wins the game.\n" +
			"To switch language type \"switch\" for the input.";
	private final String ERROR_INVALID_INPUT_ENG = "ERROR: This was an invalid input!";
	private final String ERROR_ILLEGAL_INPUT_ENG = "ERROR: %s is already occupied!\n";
	private final String VICTORY_ENG = "won the game!";
	private final String DRAW_ENG = "it's a draw!";
	private final String CHANGE_LANGUAGE_ENG = "Language is switched to english.";
	private final String GREETING_DE = "Willkommen in TicTacToe! Für Hilfe gib \"hilfe\" ein";
	private final String INPUT_REQUEST_DE = "bitte wähle ein Feld: ";
	private final String HELP_DE = "Der Spieler muss ein Feld eingeben, um sein Symbol zu setzten, zum Beispiel \"A1\".\n"
			+ "Der erste Spieler, welcher eine Linie von drei gleichen Symbolen hat, gewinnt das Spiel.\n"
			+ "Um die Sprache zu wechseln, gib \"wechseln\" in die Eingabe.";
	private final String ERROR_INVALID_INPUT_DE = "ERROR: Das war eine falsche Eingabe!";
	private final String ERROR_ILLEGAL_INPUT_DE = "ERROR: %s ist schon besetzt!\n";
	private final String VICTORY_DE = "gewinnt das Spiel!";
	private final String DRAW_DE = "Es ist ein Unentschieden!";
	private final String CHANGE_LANGUAGE_DE = "Sprache wurde zu Deutsch gewechselt.";

	/**
	 * Default constructor with language set to English.
	 */
	public OutputManager() {
		currentLanguage = "ENG";
	}

	/**
	 * Constructor with parameter to set language.
	 * Default value is English.
	 * @param language
	 * @exception NullPointerException
	 */
	public OutputManager(String language) {
		Objects.requireNonNull(language);
		language = language.toUpperCase();
		if (language.equals("ENG") || language.equals("DE")) {
			currentLanguage = language;
		} else {
			System.out.println(language + " as language is not supported.");
			currentLanguage = "ENG";
		}
	}

	/**
	 * set a diffrent current language
	 * @param language
	 * @exception NullPointerException
	 */
	public void setCurrentLanguage(String language) {
		Objects.requireNonNull(language);
		if (language.equals("ENG") || language.equals("DE")) {
			currentLanguage = language;
		}
	}

	/**
	 * Print the greeting text.
	 */
	public void printGreeting() {
		if (currentLanguage.equals("ENG")) {
			System.out.println(GREETING_ENG);
			printHelpMenu();
		} else {
			System.out.println(GREETING_DE);
			printHelpMenu();
		}
	}

	/**
	 * Print the input request text.
	 * @param player
	 */
	public void printInputRequest(int player) {
		if (currentLanguage.equals("ENG")) {
			System.out.print(mapStringToPlayerValue(player) + ", " + INPUT_REQUEST_ENG);
		} else {
			System.out.print(mapStringToPlayerValue(player) + ", " + INPUT_REQUEST_DE);
		}
	}

	/**
	 * Print the help text.
	 */
	public void printHelpMenu() {
		if (currentLanguage.equals("ENG")) {
			System.out.println(HELP_ENG);
		} else {
			System.out.println(HELP_DE);
		}
	}

	/**
	 * Print the invalid input error text.
	 */
	public void printErrorInvalidInput() {
		if (currentLanguage.equals("ENG")) {
			System.out.println(ERROR_INVALID_INPUT_ENG);
		} else {
			System.out.println(ERROR_INVALID_INPUT_DE);
		}
	}

	/**
	 * Print the illegal input error text.
	 * @param input
	 */
	public void printErrorIllegalInput(String input) {
		if (currentLanguage.equals("ENG")) {
			System.out.format(ERROR_ILLEGAL_INPUT_ENG, input);
		} else {
			System.out.format(ERROR_ILLEGAL_INPUT_DE, input);
		}
	}

	/**
	 * Print the victory text with the winning player.
	 * @param winnerPlayer
	 */
	public void printVictory(int winnerPlayer) {
		if (currentLanguage.equals("ENG")) {
			System.out.println(mapStringToPlayerValue(winnerPlayer) + " " + VICTORY_ENG);
		} else {
			System.out.println(mapStringToPlayerValue(winnerPlayer) + " " + VICTORY_DE);
		}
	}
	
	/**
	 * Print the draw text.
	 */	
	public void printDraw() {
		if (currentLanguage.equals("ENG")) {
			System.out.println(DRAW_ENG);
		} else {
			System.out.println(DRAW_DE);
		}
	}

	/**
	 * Switch the game language and print out the change language text.
	 */
	public void switchLanguage() {
		if (currentLanguage.equals("ENG")) {
			setCurrentLanguage("DE");
			System.out.println(CHANGE_LANGUAGE_DE);
		} else {
			setCurrentLanguage("ENG");
			System.out.println(CHANGE_LANGUAGE_ENG);
		}
	}
	
	/** 
	 * Print PlayingField
	 */
	public void printPlayingField(PlayingField playingField) {
		System.out.println("    A   B   C");
		System.out.println("  -------------");
		System.out.println("1 | " + mapStringToPlayerValue(playingField.getFieldValue("A1"))+" | " + mapStringToPlayerValue(playingField.getFieldValue("B1")) +
				" | " + mapStringToPlayerValue(playingField.getFieldValue("C1")) + " |");
		System.out.println("  -------------");
		System.out.println("2 | " + mapStringToPlayerValue(playingField.getFieldValue("A2"))+" | " + mapStringToPlayerValue(playingField.getFieldValue("B2")) +
				" | " + mapStringToPlayerValue(playingField.getFieldValue("C2")) + " |");
		System.out.println("  -------------");
		System.out.println("3 | " + mapStringToPlayerValue(playingField.getFieldValue("A3"))+" | " + mapStringToPlayerValue(playingField.getFieldValue("B3")) +
				" | " + mapStringToPlayerValue(playingField.getFieldValue("C3")) + " |");
		System.out.println("  -------------");
		
	}

	private String mapStringToPlayerValue(int value){
		if (value == 1){
			return "X";
		}
		else if (value == 0){
			return " ";
		}
		else{
			return "O";
		}
	}
	
}
