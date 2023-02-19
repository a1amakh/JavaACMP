/**
 * It's a Task No7 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.math.BigInteger;

class Task7 {
	private static BigInteger[] heaps = new BigInteger[3]; // Heaps with gold coints

	public static void main(String[] args) {
		readInputFile();
		writeOutputFile();
	}

	private static BigInteger getResult() { // Abba gets the maximum number of coins
		BigInteger result = heaps[0]; // Maximum coins in heap

		for (BigInteger maxCoins : heaps) // Iterating over heaps to find the maximum number of coins
			if (result.max(maxCoins) == maxCoins)
				result = maxCoins;

		return result;
	}

	private static void readInputFile() { // Read INPUT.txt
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file
			for (int i = 0; i < 3; i++)
				heaps[i] = scanner.nextBigInteger(); // Set heaps
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