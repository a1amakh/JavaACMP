/**
 * Task No12 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Cottager {
	private int id; // ID of Cottager
	private int[] landingCoords; // Landing coordinates of the cottager

	public Cottager(int id, int[] landingCoords) { // Construction for Class Cottager
		this.id = id;
		this.landingCoords = landingCoords;
	}

	public int[] getLandingCoords() { // Getter for getting landing coords
		return landingCoords;
	}
}

class Plot {
	private int id; // ID of Plot
	private int[] plotCoords; // Plot coordinates

	public Plot(int id, int[] plotCoords) { // Construction for Class Plot
		this.id = id;
		this.plotCoords = plotCoords;
	}
}

class Task12 {
	private static int n; // Count of cottagers
	private static Cottager[] cottagers; // Array of cottagers
	private static Plot[] plots; // Array of plots

	public static void main(String[] args) {
		// If file "INPUT.txt" successfully read - true
		if (readInputFile())
			writeOutputFile();
	}

	private static int countingLandedCottagers() { // Counting cottagers who landed on their plots
		int result = 0; // Result of counting cottagers who landed on their plots



		return result;
	}

	private static boolean readInputFile() { // Method for read file "INPUT.txt"
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file "INPUT.txt"
			int[] tempArrLandingCoords; // Temp array for coordinates of the landing cottager
			int[] tempArrPlotCoords; // Temp array for coordinates of the plot

			n = scanner.nextInt(); // Set N
			cottagers = new Cottager[n]; // Create Cottager arr with length N
			plots = new Plot[n];

			for (int i = 0; i < n; i++) {
				tempArrLandingCoords = new int[2];
				tempArrPlotCoords = new int[8];

				tempArrLandingCoords[0] = scanner.nextInt(); // Set landing coords
				tempArrLandingCoords[1] = scanner.nextInt(); // Set landing coords

				for (int j = 0; j < 8; j++)
					tempArrPlotCoords[j] = scanner.nextInt(); // Set plot coords						
				
				cottagers[i] = new Cottager(i, tempArrLandingCoords); // Create new cottager with coords
				plots[i] = new Plot(i, tempArrPlotCoords); // Create new plot with coords
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