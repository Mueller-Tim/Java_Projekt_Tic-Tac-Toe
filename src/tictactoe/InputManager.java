package tictactoe;

import java.util.Scanner;

/**
 * 
 * The InputManager is responsible for reading, validating and returning user input from the console.
 *
 */
public class InputManager {

	private Scanner scanner;

	/**
	 * Default constructor
	 * instantiates new scanner
	 * 
	 */
	public InputManager() {
		scanner = new Scanner(System.in);
	}

	/**
	 * returns a validated user input
	 * @return String input
	 */
	public String getInput() {
		String userInput = scanner.next().toUpperCase();
		userInput = changeInputIfGerman(userInput);
		String input = isValid(userInput) ? userInput : "ERROR";
		return input;
	}

	/**
	 * close this objects scanner
	 */
	public void closeScanner() {
		scanner.close();
	}

	private boolean isValid(String needsValidation) {

		if (needsValidation.equals("HELP") || needsValidation.equals("SWITCH")) {
			return true;
		} else if (needsValidation.length() == 2) {
			if (needsValidation.charAt(0) == 'A' || needsValidation.charAt(0) == 'B' || needsValidation.charAt(0) == 'C') {
				if (needsValidation.charAt(1) == '1' || needsValidation.charAt(1) == '2' || needsValidation.charAt(1) == '3') {
					return true;
				}
			}
		}
		return false;
	}

	private String changeInputIfGerman(String userInput){
		if (userInput.equals("HILFE")){
			return "HELP";
		} else if (userInput.equals("WECHSELN")){
			return "SWITCH";
		}
		return userInput;
	}

}