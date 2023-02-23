/**
 * Task No11 from acmp.ru
 * 
 * This task is solved with the help of Bonacci N-numbers
 * The next number is obtained from the sum of the N previous numbers.
 * What do I want to say? In the case of Fibonacci numbers, we add the previous two numbers to get the third one. 
 * And so on until we get the desired value.
 * In the case of Tribonacci numbers, we add the previous three to get the fourth, and so on.
 * If we reduce this to a task, then the value of K (the maximum number of steps jumped over at a time) 
 * will be this very number N in Bonacci numbers (Fibonacci, Tribonacci, and so on). The number N (the number of steps 
 * of the ladder) will be the number we need in the Bonacci numbers.
 * 
 * I solved the task by using lists to easily add and remove elements. I don't know if this is the right solution, 
 * but that's what I thought.
 * It turns out that initially we initialize two blocks in the Sheet, this is our starting point (Fibonacci solution).
 * If the number of steps at a time is more than two, namely the number K is greater than 2 (let's say 3), 
 * then add 0 to the beginning of the List to add the first 3 elements. And so on as K increases.
 * As soon as the sum of the values in the Sheet is calculated, it is added to the end of the Sheet, 
 * and the zero (initial) element is removed (discarded).
 * 
 * Consider an example with Fibonacci numbers (K = 2, N = 7):
 * Start list: 1, 1
 * Sheet after sum: 1, 1, 2
 * Remove null element: 1, 2
 * Sheet after sum: 1, 2, 3
 * Remove null element: 2, 3
 * Sheet after sum: 2, 3, 5
 * And so on until the number 21, which will be the answer to this example.
 * Numbers of Fibonacci: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.List; // For task 
import java.util.ArrayList; // For task
import java.math.BigInteger; // For task

class Task11 {
	private static int k; // Maximum number of stairs that a hare can climb in one jump
	private static int n; // Total number of stairs

	public static void main(String[] args) {
		// If file "INPUT.txt" successfully read - true
		if (readInputFile())
			writeOutputFile();
	}

	// Getting result of task >
	// > The number of possible options for different routes of the hare to the top rung of the stairs
	private static BigInteger calcCountOfRouts() {
		BigInteger result = BigInteger.ZERO; // Result

		// If K == 1 (1-Bonacci) then result = 1
		// And else if K != 0 (N-Bonacci)
		if (k == 1)
			result = BigInteger.ONE;
		else if (k != 0)
			result = nBonacci(n);

		return result;
	}

	// Getting number of N-Bonacci
	private static BigInteger nBonacci(int n) {
		List<BigInteger> nBonacciList = new ArrayList<>(); // N-Bonacci List
		
		// Adding ZEROs if K > 2 (Tribonacci, etc.)
		if (k > 2)
			for (int i = 1; i <= k - 2; i++)
				nBonacciList.add(BigInteger.ZERO);

		// Adding starting ONEs
		nBonacciList.add(BigInteger.ONE);
		nBonacciList.add(BigInteger.ONE);
		
		// Adding a sum and removing a zero element
		for (int i = 1; i < n; i++) {
			nBonacciList.add(sumOfNBonacciList(nBonacciList)); // Add
			nBonacciList.remove(0); // Remove
		}

		return nBonacciList.get(k - 1); // Getting the last element from List
	}

	// Getting the sum of elements in N-Bonacci List
	private static BigInteger sumOfNBonacciList(List<BigInteger> nBonacciList) {
		BigInteger sum = BigInteger.ZERO; // Sum of elements in N-Bonacci List

		for (BigInteger number : nBonacciList)
			sum = sum.add(number);
		
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