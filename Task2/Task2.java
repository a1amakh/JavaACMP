/**
 * It's a Task No2 from asmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task2 {
	private static int n; // N

	public static void main(String[] args) {
		readInputFile();
		writeOutputFile();
	}

	private static long getResult() { // The result of the sum of numbers from 1 to N
		long result = 0L;

		if (n > 0) // If N > 0
			for (int i = 1; i <= n; i++) // (+) from 1 to +N
				result += i;
		else if (n < 0) // If N < 0
			for (int i = 1; i >= n; i--) // (-) from 1 to -N
				result += i;
		else if (n == 0) // If N = 0
			result += 1; // result (0) + 1 because from 1 to N (0)

		return result;
	}

	private static void readInputFile() {
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to read
			n = scanner.nextInt(); // Set N
            System.out.println("File read successfully"); // Show message when successfully
        } catch (FileNotFoundException e) {
            System.out.println("File not found"); // Show message when file not found
        }
	}

	private static void writeOutputFile() {
		try (PrintWriter printWriter = new PrintWriter(new File("OUTPUT.txt"))) { // Try to read
			printWriter.print(getResult()); // Write result
			System.out.println("File write successfully"); // Show message when successfully
		} catch (FileNotFoundException e) {
			System.out.println("File not found"); // Show message when file not found
		}
	}
}