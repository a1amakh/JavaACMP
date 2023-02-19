/**
 * It's a Task No1 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task1 {
	private static int a; // A
	private static int b; // B

	public static void main(String[] args) {
		readInputFile();
		writeOutputFile();
	}

	private static int getResult() { // Result of addition A + B
		return a + b;
	}

	private static void readInputFile() {
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to read
			a = scanner.nextInt(); // Set A
			b = scanner.nextInt(); // Set B
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