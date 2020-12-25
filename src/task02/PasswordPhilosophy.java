package task02;

import java.util.List;

import utils.InputReader;

public class PasswordPhilosophy {

	private static final String INPUT_FILE = "input-02.txt";
	private static final char MIN_END_CHAR = '-';
	private static final char MAX_END_CHAR = ' ';
	private static final char PASSWORD_START_CHAR = ':';
	
	public static void main(String[] args) {
		List<String> passwords = InputReader.loadFile(INPUT_FILE);
		System.out.println(countValidPasswords(passwords));
	}

	private static int countValidPasswords(List<String> passwords) {
		int validPasswords = 0;
		for (String password : passwords) {
			if (passwordIsValid(password)) {
				validPasswords++;
			}
		}
		return validPasswords;
	}
	
	private static boolean passwordIsValid(String password) {
		int min = getMin(password);
		int max = getMax(password);
		char charToCheck = getChar(password);
		String passwordDigits = getPassword(password);
		return checkPassword(min, max, charToCheck, passwordDigits);
	}
	
	private static int getMin(String password) {
		int minEnd = password.indexOf(MIN_END_CHAR);
		String strMin = password.substring(0, minEnd);
		return Integer.parseInt(strMin);
	}
	
	private static int getMax(String password) {
		int maxStart = password.indexOf(MIN_END_CHAR) + 1;
		int maxEnd = password.indexOf(MAX_END_CHAR);
		String strMax = password.substring(maxStart, maxEnd);
		return Integer.parseInt(strMax);
	}
	
	private static char getChar(String password) {
		int charIndex = password.indexOf(MAX_END_CHAR) + 1;
		return password.charAt(charIndex);
	}
	
	private static String getPassword(String password) {
		int passwordStart = password.indexOf(PASSWORD_START_CHAR) + 1;
		return password.substring(passwordStart).trim();
	}
	
	private static boolean deprecatedCheckPassword(int min, int max, char charToCheck, String passwordDigits) {
		int count = 0;
		for (char ch : passwordDigits.toCharArray()) {
			if (charToCheck == ch) {
				count++;
			}
		}
		return min <= count && max >= count;
	}
	
	private static boolean checkPassword(int index1, int index2, char charToCheck, String passwordDigits) {
		boolean charEqualsAtIndex1 = passwordDigits.charAt(index1 - 1) == charToCheck;
		boolean charEqualsAtIndex2 = passwordDigits.charAt(index2 - 1) == charToCheck;
		return charEqualsAtIndex1 ^ charEqualsAtIndex2;
	}

}
