/**
 * It's a Task No5 from asmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList; // Import ArrayList for task
import java.util.List; // Import List for task

class Task5 {
	private static int n; // N - Count of elements in array
	private static int[] originalArr; // Original array
	private static List<Integer> evenList = new ArrayList(); // Even dates array
	private static List<Integer> oddList = new ArrayList(); // Odd dates array


	public static void main(String[] args) {
		readInputFile();
		dateDistrib();
		writeOutputFile();
	}

	private static String getResult() { // Is Vasya an excellent student?
		if (evenList.size() > oddList.size()) // If even dates more than odd dates
			return "YES";
		else if (evenList.size() < oddList.size()) // If odd dates more than even dates
			return "NO";
		else // If even dates == odd dates
			return "YES";
	}

	private static void dateDistrib() { // Method for distribution dates into Lists
		for (int date : originalArr) // Iterating over the elements of an original array
			if (date % 2 == 0) // If date even
				evenList.add(date);
			else // If date odd
				oddList.add(date);
	}

	private static void readInputFile() { // Read INPUT.txt
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file
			n = scanner.nextInt(); // Set N
			originalArr = new int[n]; // Declaring an array consisting of N numbers

			for (int i = 0; i < n; i++) // Set original array
				originalArr[i] = scanner.nextInt();

            System.out.println("File read successfully"); // Show message when successfully
        } catch (FileNotFoundException e) {
            System.out.println("File not found"); // Show message when file not found
        }
	}

	private static void writeOutputFile() { // Write OUTPUT.txt
		try (PrintWriter printWriter = new PrintWriter(new File("OUTPUT.txt"))) { // Try to open file
			for (int date : oddList) // Write elements from odd List
				printWriter.print(date + " ");
			printWriter.println();
			
			for (int date : evenList) // Write elements from even List
				printWriter.print(date + " ");
			printWriter.println();
			
			printWriter.println(getResult()); // Write result

			System.out.println("File written successfully"); // Show message when successfully
		} catch (FileNotFoundException e) {
			System.out.println("File not found"); // Show message when file not found
		}
	}
}