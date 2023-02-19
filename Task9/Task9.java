/**
 * It's a Task No9 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task9 {
	private static int n; // Count of numbers in input numbers array
	private static int[] numbers; // Input numbers array

	public static void main(String[] args) {
		readInputFile();
		writeOutputFile();
	}

	private static int sumOfPosElements() { // Sum of positive elements
		int result = 0; // Result

		for (int num : numbers)
			if (num > 0)
				result += num; // Sum

		return result;
	}

	private static int prodOfNumbersBetweenMaxMin() { // Product of numbers between max and min numbers
		int[] indices = findMaxMin(); // Indices array
		int result = 1; // Result

		for (int i = indices[0] + 1; i < indices[1]; i++)
			result *= numbers[i]; // Prod

		return result;
	}

	/* The method returns an array of indices in the format [MAX, MIN]
	But if index MAX more than index MIN
	Method reverse returns array
	for example: [9, 1] -> return [1, 9]
	*/
	private static int[] findMaxMin() { // Method for find MAX and MIN indices in numbers array
		int[] indices = new int[2]; // 0 - index MAX, 1 - index MIN
		int maxNum = numbers[0]; // Temp for indices
		int minNum = numbers[0]; // Temp for indices
		int temp; // Temp

		for (int i = 0; i < n; i++) {
			if (maxNum < numbers[i]) { // If MAX less than number
				indices[0] = i;
				maxNum = numbers[i];
			} 

			if (minNum > numbers[i]) { // If MIN more than number
				indices[1] = i;
				minNum = numbers[i];
			}
		}

		if (indices[0] > indices[1]) { // Reverse array, if FIRST INDEX > SECOND INDEX (9 > 1)
			temp = indices[1];
			indices[1] = indices[0];
			indices[0] = temp;
		}

		return indices;
	}

	private static void readInputFile() { // Read INPUT.txt
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file
			n = scanner.nextInt(); // Set N
			numbers = new int[n]; // Array initialization

			for (int i = 0; i < n; i++)
				numbers[i] = scanner.nextInt(); // Set numbers array
            
            System.out.println("File read successfully"); // Show message when successfully
        } catch (FileNotFoundException e) {
            System.out.println("File not found"); // Show message when file not found
        }
	}

	private static void writeOutputFile() { // Write OUTPUT.txt
		try (PrintWriter printWriter = new PrintWriter(new File("OUTPUT.txt"))) { // Try to open file
			printWriter.print(sumOfPosElements()); // Write sum
			printWriter.print(" "); // Write " "
			printWriter.print(prodOfNumbersBetweenMaxMin()); // Write prod

			System.out.println("File written successfully"); // Show message when successfully
		} catch (FileNotFoundException e) {
			System.out.println("File not found"); // Show message when file not found
		}
	}
}