/**
 * Task No13 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task13 {
	private static char[] a, b; // A - the number suggested by Petya, and B - the option proposed by Vasya

	public static void main(String[] args) {
		// If file "INPUT.txt" successfully read - true
		if (readInputFile())
			writeOutputFile();
	}

	private static int[] getBullsAndCows() { // Method for getting Bulls and Cows
		int[] result = new int[2]; // 0 - Bulls, 1 - Cows

		for (int i = 0; i < 4; i++) // Enumeration of the number A
			for (int j = 0; j < 4; j++) // Enumeration of the number B
				if (a[i] == b[j] && i == j) // If numbers and indexes equal
					result[0]++; // + Bull
				else if (a[i] == b[j] && i != j) // Else if numbers equal and indexes not equal
					result[1]++; // + Cow
		
		return result;
	}

	private static boolean readInputFile() { // Method for read file "INPUT.txt"
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file "INPUT.txt"
			String[] temp = scanner.nextLine().split(" "); // Read input string and convert in array
			a = temp[0].toCharArray(); // Set A
			b = temp[1].toCharArray(); // Set B
            
            System.out.println("File \"INPUT.txt\" successfully read"); // Show message when file "INPUT.txt" successfully read
			return true;
        } catch (FileNotFoundException e) {
            System.out.println("File \"INPUT.txt\" not found"); // Show message when file "INPUT.txt" not found
			return false;
        }
	}

	private static boolean writeOutputFile() { // Method for write file "OUTPUT.txt"
		try (PrintWriter printWriter = new PrintWriter(new File("OUTPUT.txt"))) { // Try to open file "OUTPUT.txt" 
			int[] temp = getBullsAndCows(); // Temp int array for print result
			printWriter.print(temp[0]); // Print Bulls
			printWriter.print(" "); // Print delimiter
			printWriter.print(temp[1]); // Print Cows

			System.out.println("File \"OUTPUT.txt\" successfully written"); // Show message when file "OUTPUT.txt" successfully written
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File \"OUTPUT.txt\" not found"); // Show message when file "OUTPUT.txt" not found
			return false;
		}
	}
}