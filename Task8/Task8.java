/**
 * It's a Task No8 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task8 {
	private static int[] numbers = new int[3]; // Array of numbers (0 - A, 1 - B, 3 - C)

	public static void main(String[] args) {
		readInputFile();
		writeOutputFile();
	}

	private static String getResult() { // Return YES if A * B = C else return NO
		if (numbers[0] * numbers [1] == numbers[2])
			return "YES";
		else
			return "NO";
	}

	private static void readInputFile() { // Read INPUT.txt
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file
			for (int i = 0; i < 3; i++)
				numbers[i] = scanner.nextInt(); // Set numbers
            System.out.println("File read successfully"); // Show message when successfully
        } catch (FileNotFoundException e) {
            System.out.println("File not found"); // Show message when file not found
        }
	}

	private static void writeOutputFile() { // Write OUTPUT.txt
		try (PrintWriter printWriter = new PrintWriter(new File("OUTPUT.txt"))) { // Try to open file
			printWriter.println(getResult()); // Write result
			System.out.println("File written successfully"); // Show message when successfully
		} catch (FileNotFoundException e) {
			System.out.println("File not found"); // Show message when file not found
		}
	}
}