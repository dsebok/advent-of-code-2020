package task01;

import java.util.List;
import utils.InputReader;

public class ReportRepair {

	private static final String INPUT_FILE = "input-01.txt";
	private static final int SUM = 2020;
	
	public static void main(String[] args) {
		List<String> strNumbers = InputReader.loadFile(INPUT_FILE);
		List<Integer> numbers = InputReader.parseToInt(strNumbers);
		int[] result1 = findTwoThatAddsUp(numbers, SUM);
		int[] result2 = findThreeThatAddsUp(numbers, SUM);
		System.out.println(result1[0] * result1[1]);
		System.out.println(result2[0] * result2[1] * result2[2]);
	}

	private static int[] findTwoThatAddsUp(List<Integer> numbers, int sum) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.size(); i++) {
			int nr1 = numbers.get(i);
			for(int j = i+1; j < numbers.size(); j++) {
				int nr2 = numbers.get(j);
				if (nr1 + nr2 == sum) {
					result[0] = nr1;
					result[1] = nr2;
				}
			}
		}
		return result;
	}
	
	private static int[] findThreeThatAddsUp(List<Integer> numbers, int sum) {
		int[] result = new int[3];
		for (int i = 0; i < numbers.size(); i++) {
			int nr1 = numbers.get(i);
			for(int j = i+1; j < numbers.size(); j++) {
				int nr2 = numbers.get(j);
				for(int k = j+1; k < numbers.size(); k++) {
					int nr3 = numbers.get(k);
					if (nr1 + nr2 + nr3 == sum) {
						result[0] = nr1;
						result[1] = nr2;
						result[2] = nr3;
					}
				}
			}
		}
		return result;
	}
	
}
