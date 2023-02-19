/**
 * It's a Task No6 from acmp.ru
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Task6 {
	private static String str; // str - Input string (for example, C7-D5)
	private static char[] temp = new char[5]; // Temp char array for calculate result
	private static final String NO = "NO"; // Constant NO
	private static final String YES = "YES"; // Constant YES
	private static final String ERROR = "ERROR"; // Constant ERROR

	public static void main(String[] args) {
		readInputFile();
		writeOutputFile();
	}

	private static String getResult() { // The result of the correct move of the knight
		temp = str.toCharArray(); // Converts input string to a character array.

		// If length of temp array less than 5 charactres || third char != '-'
		if (temp.length < 5 || temp[2] != '-') 
			return ERROR;
		// If letters in symbols ASCII less than 65 && more than 72
		else if (temp[0] > 72 || temp[0] < 65 || temp[3] > 72 || temp[3] < 65) 
			return ERROR;
		// If nums in symbols ASCII less than 49 && more than 56
		else if (temp[1] < 49 || temp[1] > 56 || temp[4] < 49 || temp[4] > 56) 
			return ERROR;
		// If the coordinates of the first cell are equal to the coordinates of the second cell
		// char + 2 && num + 1 or num - 1
		else if (temp[0] + 2 == temp[3] && (temp[1] + 1 == temp[4] || temp[1] - 1 == temp[4]))
			return YES;
		// char - 2 && num + 1 or num - 1
		else if (temp[0] - 2 == temp[3] && (temp[1] + 1 == temp[4] || temp[1] - 1 == temp[4]))
			return YES;
		// char + 1 && num + 2 or num - 2
		else if (temp[0] + 1 == temp[3] && (temp[1] + 2 == temp[4] || temp[1] - 2 == temp[4]))
			return YES;
		// char - 1 && num + 2 or num - 2
		else if (temp[0] - 1 == temp[3] && (temp[1] + 2 == temp[4] || temp[1] - 2 == temp[4]))
			return YES;
		else
			return NO;
	}

	private static void readInputFile() { // Read INPUT.txt
		try (Scanner scanner = new Scanner(new File("INPUT.txt"))) { // Try to open file
			str = scanner.nextLine(); // Set str (input string)
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