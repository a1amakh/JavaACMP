/**
 * It's a Task No4 from asmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task4 {
	private static int k; // K

	public static void main(String[] args) {
		readInputFile();
		writeOutputFile();
	}

	private static int getResult() { // The result of difference received by Vasya
		return (k * 100) + 90 + (9 - k);
		/*
		Let k = 2
		
		k * 100 = 200
		200 + 90 = 290
		9 - k = 7
		290 + 7 = 297

		Result is 297
		*/
	}

	private static void readInputFile() {
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to read
			k = scanner.nextInt(); // Set K
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