package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    private static final String PATH = "D:\\Code_Life\\AdventOfCode\\inputs\\";
    
	public static List<String> loadFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = readFile(fileName)) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

	private static BufferedReader readFile(String fileName) throws FileNotFoundException {
		return new BufferedReader(new FileReader(PATH + fileName));
	}

	public static List<Integer> parseToInt(List<String> lines) {
		return lines.stream().map(Integer::parseInt).collect(Collectors.toList());
	}
}
