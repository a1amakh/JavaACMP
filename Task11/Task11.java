/**
 * Task No11 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.List; // For task (fibonacci)
import java.util.ArrayList; // For task (fibonacci)

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
			result = fibonacci(n);

		return result;
	}

	// Numbers of fibonacci: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	// private static int fibonacci(int n) { // Recursive method of fibonacci numbers
	// 	if (n == 1 || n == 2)
	// 		return 1;
	// 	else 
	// 		return fibonacci(n - 1) + fibonacci(n - 2);
	// }

	private static int fibonacci(int n) { // TEMP
		List<Integer> fibonacciList = new ArrayList<>();
		
		if (k > 2)
			for (int i = 1; i <= k - 2; i++)
				fibonacciList.add(0);

		fibonacciList.add(1);
		fibonacciList.add(1);
		
		for (int i = 1; i < n; i++) {
			fibonacciList.add(sumOfListFibonacci(fibonacciList));
			fibonacciList.remove(0);
		}

		return fibonacciList.get(k - 1);
	}

	private static int sumOfListFibonacci(List<Integer> fibonacciList) {
		int sum = 0;

		for (int number : fibonacciList)
			sum += number;
		
		return sum;
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