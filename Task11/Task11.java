/**
 * Task No11 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task11 {
	private static int k; // Maximum number of stairs that a hare can climb in one jump
	private static int n; // Total number of stairs

	public static void main(String[] args) {
		if (readInputFile()) // If file "INPUT.txt" successfully read - true
			writeOutputFile();
	}

	private static int calcCountOfRouts() {
		int result = 0;

		if (k == 1)
			result = 1;
		else
			result = fibonacci(n + 1);

		return result;
	}

	// Numbers of fibonacci: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	private static int fibonacci(int n) { // Recursive method of fibonacci numbers
		if (n == 1 || n == 2)
			return 1;
		else 
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	private static boolean readInputFile() { // Method for read file "INPUT.txt"
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file "INPUT.txt"
			k = scanner.nextInt(); // Set K
			n = scanner.nextInt(); // Set N
            
            System.out.println("File \"INPUT.txt\" successfully read"); // Show message when file "INPUT.txt" successfully read
			return true;
        } catch (FileNotFoundException e) {
            System.out.println("File \"INPUT.txt\" not found"); // Show message when file "INPUT.txt" not found
			return false;
        }
	}

	private static boolean writeOutputFile() { // Method for write file "OUTPUT.txt"
		try (PrintWriter printWriter = new PrintWriter(new File("OUTPUT.txt"))) { // Try to open file "OUTPUT.txt" 
			printWriter.println(calcCountOfRouts()); // Write count of routs

			System.out.println("File \"OUTPUT.txt\" successfully written"); // Show message when file "OUTPUT.txt" successfully written
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File \"OUTPUT.txt\" not found"); // Show message when file "OUTPUT.txt" not found
			return false;
		}
	}
}