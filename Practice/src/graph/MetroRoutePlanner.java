package graph;

import java.util.*;

public class MetroRoutePlanner {

	public static int minLineChanges(List<List<String>> metroLines, String source, String destination) {
		if (source.equals(destination))
			return 0;

		// Map station -> List of metro line indices it belongs to
		Map<String, List<Integer>> stationToLines = new HashMap<>();
		for (int i = 0; i < metroLines.size(); i++) {
			for (String station : metroLines.get(i)) {
				stationToLines.computeIfAbsent(station, k -> new ArrayList<>()).add(i);
			}
		}

		// If source or destination not present in any line
		if (!stationToLines.containsKey(source) || !stationToLines.containsKey(destination)) {
			return -1;
		}

		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visitedLines = new HashSet<>();

		// Start BFS from all lines containing the source
		for (int line : stationToLines.get(source)) {
			queue.offer(line);
			visitedLines.add(line);
		}

		int level = 0; // number of line changes

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int currentLine = queue.poll();

				// If destination is found in this line, return number of changes
				if (metroLines.get(currentLine).contains(destination)) {
					return level;
				}

				//level based traversal
				// Try all stations of this line to find connecting lines
				for (String station : metroLines.get(currentLine)) {
					for (int neighborLine : stationToLines.get(station)) {
						if (!visitedLines.contains(neighborLine)) {
							queue.offer(neighborLine);
							visitedLines.add(neighborLine);
						}
					}
				}
			}
			level++; // One level up = one line change
		}

		return -1; // Destination not reachable
	}

	// Sample usage
	public static void main(String[] args) {
		List<List<String>> metroLines = Arrays.asList(Arrays.asList("A", "B", "C", "D"), Arrays.asList("C", "E", "F"),
				Arrays.asList("G", "H", "I", "J", "K"), Arrays.asList("F", "J"));

		String source = "A";
		String destination = "K";

		int result = minLineChanges(metroLines, source, destination);
		System.out.println("Minimum metro line changes: " + result); // Output: 2
	}
}