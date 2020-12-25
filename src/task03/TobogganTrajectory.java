package task03;

import java.util.List;

import utils.InputReader;

public class TobogganTrajectory {

	private static final String INPUT_FILE = "input-03.txt";
	private static final char TREE = '#';
	private static final int[][] MOVEMENTS = {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
	
	
	public static void main(String[] args) {
		List<String> landscape = InputReader.loadFile(INPUT_FILE);
		long treeFactor = 1L;
		for (int[] movement : MOVEMENTS) {
			treeFactor *= countCrossingTrees(landscape, movement);
		}
		System.out.println(treeFactor);
	}

	private static int countCrossingTrees(List<String> landscape, int[] movement) {
		int horizontalPlace = 0;
		int verticalPlace = 0;
		int crossingTrees = 0;
		while (verticalPlace < landscape.size()) {
			if (treeIsCrossing(landscape.get(verticalPlace), horizontalPlace)) {
				crossingTrees++;
			}
			horizontalPlace += movement[0];
			verticalPlace += movement[1];
		}
		return crossingTrees;
	}
	
	private static boolean treeIsCrossing(String landscapeLine, int place) {
		int availableSpace = landscapeLine.length();
		int reducedPlace = reducePlace(availableSpace, place);
		return treeIsOnTheSpot(landscapeLine, reducedPlace);
	}
	
	private static int reducePlace(int availableSpace, int place) {
		return place % availableSpace;
	}
	
	private static boolean treeIsOnTheSpot(String landscapeLine, int reducedPlace) {
		return landscapeLine.charAt(reducedPlace) == TREE;
	}

}
