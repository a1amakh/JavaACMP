/**
 * It's a Task No10 from acmp.ru
 * 
 * A * X^3 + B * X^2 + C * X + D = 0 - quadratic equation
 * A != 0 (if A == 0 - nonquadratic equation)
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.SortedSet; // For task
import java.util.TreeSet; // For task

class Task10 {
	private static int[] intCoefficients = new int[4]; // Integer coefficients of the cubic equation
	// A - 0, B - 1, C - 2, D - 3 (indices)
	private static SortedSet<Integer> equationRoots = new TreeSet<Integer>(); // Sorted set for equation roots

	public static void main(String[] args) {
		readInputFile();
		calculateRoots();
		writeOutputFile();
	}

	private static void calculateRoots() { // Method for calculate roots
		for (int i = -100; i <= 100; i++) 
			if (calculateEquation(i) == 0)
				equationRoots.add(i);
	}

	private static double calculateEquation(int x) { // Method for calculate equation
		double result = 
			intCoefficients[0] * Math.pow(x, 3) // A * X^3
			+ intCoefficients[1] * Math.pow(x, 2) // B * X^2
			+ intCoefficients[2] * x // C * X
			+ intCoefficients[3]; // D
		return result;
	}

	private static void readInputFile() { // Read INPUT.txt
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file
			for (int i = 0; i < 4; i++)
				intCoefficients[i] = scanner.nextInt(); // Set coefficients in array
            
            System.out.println("File read successfully"); // Show message when successfully
        } catch (FileNotFoundException e) {
            System.out.println("File not found"); // Show message when file not found
        }
	}

	private static void writeOutputFile() { // Write OUTPUT.txt
		try (PrintWriter printWriter = new PrintWriter(new File("OUTPUT.txt"))) { // Try to open file
			for (int root : equationRoots) {
				printWriter.print(root); // Write root
				printWriter.print(" "); // Write " "
			}

			System.out.println("File written successfully"); // Show message when successfully
		} catch (FileNotFoundException e) {
			System.out.println("File not found"); // Show message when file not found
		}
	}
}