/**
 * Task No12 from acmp.ru
 */

import java.util.Arrays;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Cottager { // Cottager
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

class Plot { // Plot
	private int id; // ID of Plot
	private int[] plotCoords; // Plot coordinates

	public Plot(int id, int[] plotCoords) { // Construction for Class Plot
		this.id = id;
		this.plotCoords = plotCoords;
	}

	// ----------------------------------------- ERROR ------------------------------------------
	public double calcSquare() { // Method for calculate square of plot
		// S = | A (Y1 - Y2) * B (X1 - X4) |

		// S = (|(х1 - х2)(у1 + у2) + (х2 - х3)(у2 + у3) + (х3 - х4)(у3 + у4) + (х4 - х1)(у4 + у1)|) / 2
		
		double a, b, result;

		a = plotCoords[1] - plotCoords[3]; // Y1 - Y2
		b = plotCoords[0] - plotCoords[6]; // X1 - X4
		result = Math.abs(a * b); // Square

		return result;
	}
	// ----------------------------------------- ERROR ------------------------------------------

	public int[] getPlotCoords() { // Getter for getting plot coords
		return plotCoords;
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

		for (int i = 0; i < n; i++) {

			System.out.println(plots[i].calcSquare());
			System.out.println(calcSumOfTriangleSquares(i));

			if (plots[i].calcSquare() == calcSumOfTriangleSquares(i)) // If squares equal
				result++;
		}

		return result;
	}

	private static double calcSumOfTriangleSquares(int i) { // Method for calculate sum of triangle squares
		double result = 0;
		int[] tempLandingCoords = cottagers[i].getLandingCoords();
		int[] tempPlotCoords = plots[i].getPlotCoords();

		result += 0.5 * Math.abs( // First triangle
			// (X2 - X)	* (Y1 - Y) - (X1 - X) * (Y2 - Y) 
			(tempPlotCoords[2] - tempLandingCoords[0]) * (tempPlotCoords[1] - tempLandingCoords[1]) -
			(tempPlotCoords[0] - tempLandingCoords[0]) * (tempPlotCoords[3] - tempLandingCoords[1])
		);
		result += 0.5 * Math.abs( // Second triangle
			// (X3 - X) * (Y2 - Y) - (X2 - X) * (Y3 - Y)
			(tempPlotCoords[4] - tempLandingCoords[0]) * (tempPlotCoords[3] - tempLandingCoords[1]) -
			(tempPlotCoords[2] - tempLandingCoords[0]) * (tempPlotCoords[5] - tempLandingCoords[1])
		); 
		result += 0.5 * Math.abs( // Third triangle
			// (X4 - X) * (Y3 - Y) - (X3 - X) * (Y4 - Y)
			(tempPlotCoords[6] - tempLandingCoords[0]) * (tempPlotCoords[5] - tempLandingCoords[1]) -
			(tempPlotCoords[4] - tempLandingCoords[0]) * (tempPlotCoords[7] - tempLandingCoords[1])
		); 
		result += 0.5 * Math.abs( // Fourth triangle
			// (X1 - X) * (Y4 - Y) - (X4 - X) * (Y1 - Y)
			(tempPlotCoords[0] - tempLandingCoords[0]) * (tempPlotCoords[7] - tempLandingCoords[1]) -
			(tempPlotCoords[6] - tempLandingCoords[0]) * (tempPlotCoords[1] - tempLandingCoords[1])
		); 

		return result;
	}

	private static boolean readInputFile() { // Method for read file "INPUT.txt"
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file "INPUT.txt"
			int[] tempLandingCoords; // Temp array for coordinates of the landing cottager
			int[] tempPlotCoords; // Temp array for coordinates of the plot

			n = scanner.nextInt(); // Set N
			cottagers = new Cottager[n]; // Create Cottager arr with length N
			plots = new Plot[n];

			for (int i = 0; i < n; i++) {
				tempLandingCoords = new int[2];
				tempPlotCoords = new int[8];

				tempLandingCoords[0] = scanner.nextInt(); // Set landing coords
				tempLandingCoords[1] = scanner.nextInt(); // Set landing coords

				for (int j = 0; j < 8; j++)
					tempPlotCoords[j] = scanner.nextInt(); // Set plot coords						
				
				cottagers[i] = new Cottager(i, tempLandingCoords); // Create new cottager with coords
				plots[i] = new Plot(i, tempPlotCoords); // Create new plot with coords
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