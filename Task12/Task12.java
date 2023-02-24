/**
 * Task No12 from acmp.ru
 */

import java.util.Arrays;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task12 {
	private static int n; // Count of cottagers
	private static Cottager[] cottagers; // List of cottagers

	public static void main(String[] args) {
		// If file "INPUT.txt" successfully read - true
		if (readInputFile())
			writeOutputFile();
	}

	private static int countingLandedCottagers() { // Counting cottagers who landed on their plots
		int result = 0; // Result of counting cottagers who landed on their plots
		int[] tempArrLandingCoords; // Temp array for coordinates of the landing cottager
		int[] tempArrPlotCoords; // Temp array for coordinates of the plot
		int x, y, maxX, minX, maxY, minY;

		for (int i = 0; i < n; i++) {
			tempArrLandingCoords = cottagers[i].getLandingCoords();
			tempArrPlotCoords = cottagers[i].getPlotCoords();
			x = tempArrLandingCoords[0]; // Set X of the landing cottager
			y = tempArrLandingCoords[1]; // Set Y of the landing cottager
			maxX = countingMaxXOfPlot(tempArrPlotCoords); // Set max X coord of plot
			minX = countingMinXOfPlot(tempArrPlotCoords); // Set min X coord of plot
			maxY = countingMaxYOfPlot(tempArrPlotCoords); // Set max Y coord of plot
			minY = countingMinYOfPlot(tempArrPlotCoords); // Set min Y coord of plot
			
			if (x >= minX && x <= maxX && y >= minY && y <= maxY) // If the cottager got to the plot
				result++;
		}

		return result;
	}

	private static int countingMaxXOfPlot(int[] tempArrPlotCoords) { // Method for counting max X coord of plot
		int maxX = tempArrPlotCoords[0];

		for (int i = 0; i < 8; i += 2) // Step in 2 units
			if (maxX < tempArrPlotCoords[i])
				maxX = tempArrPlotCoords[i];
		
		return maxX;
	}

	private static int countingMinXOfPlot(int[] tempArrPlotCoords) { // Method for counting min X coord of plot
		int minX = tempArrPlotCoords[0];

		for (int i = 0; i < 8; i += 2) // Step in 2 units
			if (minX > tempArrPlotCoords[i])
				minX = tempArrPlotCoords[i];
		
		return minX;
	}

	private static int countingMaxYOfPlot(int[] tempArrPlotCoords) { // Method for counting max Y coord of plot
		int maxY = tempArrPlotCoords[1];

		for (int i = 1; i < 8; i += 2) // Step in 2 units
			if (maxY < tempArrPlotCoords[i])
				maxY = tempArrPlotCoords[i];
		
		return maxY;
	}

	private static int countingMinYOfPlot(int[] tempArrPlotCoords) { // Method for counting min Y coord of plot
		int minY = tempArrPlotCoords[1];

		for (int i = 1; i < 8; i += 2) // Step in 2 units
			if (minY > tempArrPlotCoords[i])
				minY = tempArrPlotCoords[i];
		
		return minY;
	}

	private static boolean readInputFile() { // Method for read file "INPUT.txt"
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file "INPUT.txt"
			int[] tempArrLandingCoords = new int[2]; // Temp array for coordinates of the landing cottager
			int[] tempArrPlotCoords = new int[8]; // Temp array for coordinates of the plot

			n = scanner.nextInt(); // Set N
			cottagers = new Cottager[n];

			for (int i = 0; i < n; i++) {
				tempArrLandingCoords[0] = scanner.nextInt(); // Set landing coords
				tempArrLandingCoords[1] = scanner.nextInt(); // Set landing coords

				for (int j = 0; j < 8; j++)
					tempArrPlotCoords[j] = scanner.nextInt(); // Set plot coords
				
				// ------------------------------------ ERROR -----------------------------------
				
				cottagers[i] = new Cottager(tempArrLandingCoords, tempArrPlotCoords); // Create new cottager with coords
			
				// ------------------------------------ ERROR -----------------------------------
			}
            
            System.out.println("File \"INPUT.txt\" successfully read"); // Show message when file "INPUT.txt" successfully read
			return true;
        } catch (FileNotFoundException e) {
            System.out.println("File \"INPUT.txt\" not found"); // Show message when file "INPUT.txt" not found
			return false;
        }
	}

	private static boolean writeOutputFile() { // Method for write file "OUTPUT.txt"
		try (PrintWriter printWriter = new PrintWriter(new File("OUTPUT.txt"))) { // Try to open file "OUTPUT.txt" 
			printWriter.println(countingLandedCottagers()); // Write result

			System.out.println("File \"OUTPUT.txt\" successfully written"); // Show message when file "OUTPUT.txt" successfully written
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File \"OUTPUT.txt\" not found"); // Show message when file "OUTPUT.txt" not found
			return false;
		}
	}
}