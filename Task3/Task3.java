/**
 * It's a Task No3 from asmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task3 {
	private static int a; // A

	public static void main(String[] args) {
		readInputFile();
		writeOutputFile();
	}

	private static long getResult() { // The result of raised A to the power of 2
		return (long) Math.pow(a, 2); // Convert to long because Math.pow() return double
	}

	private static void readInputFile() {
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to read
			a = scanner.nextInt(); // Set A
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