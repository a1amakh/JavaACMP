/**
 * Task No14 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.ArrayList;

class Task14 {
	private static long a, b; // A and B

	public static void main(String[] args) {
		// If file "INPUT.txt" successfully read - true
		if (readInputFile())
			writeOutputFile();
	}

	private static long getNOK() { // Method for getting NOK from A and B
		long result = 0L;
		List<Integer> multipliersOfA = new ArrayList<>(); // Multipliers of A
		List<Integer> multipliersOfB = new ArrayList<>(); // Multipliers of B

		getFactorization(multipliersOfA);
		getFactorization(multipliersOfB);

		// ...some codeee

		return result;
	}

	private static List<Integer> getFactorization(List<Integer> multipliers) { // Method for getting factorization
		List<Integer> result = multipliers;

		// ...some codeee

		return result;
	}

	private static boolean readInputFile() { // Method for read file "INPUT.txt"
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file "INPUT.txt"
			a = scanner.nextLong(); // Set A
			b = scanner.nextLong(); // Set B
		
            System.out.println("File \"INPUT.txt\" successfully read"); // Show message when file "INPUT.txt" successfully read
			return true;
        } catch (FileNotFoundException e) {
            System.out.println("File \"INPUT.txt\" not found"); // Show message when file "INPUT.txt" not found
			return false;
        }
	}

	private static boolean writeOutputFile() { // Method for write file "OUTPUT.txt"
		try (PrintWriter printWriter = new PrintWriter(new File("OUTPUT.txt"))) { // Try to open file "OUTPUT.txt" 
			printWriter.println(getNOK()); // Print result (NOK)

			System.out.println("File \"OUTPUT.txt\" successfully written"); // Show message when file "OUTPUT.txt" successfully written
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File \"OUTPUT.txt\" not found"); // Show message when file "OUTPUT.txt" not found
			return false;
		}
	}
}