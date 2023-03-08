/**
 * Task No14 "НОК" acmp.ru
 * @author a1amakh
 */

import java.util.*;
import java.io.*;

class Task14 {
	private static long firstNumber, secondNumber, NOKFromFirstAndSecondNumbers;

	public static void main(String[] args) {
		if (InputFile.readInputFile())
			OutputFile.writeOutputFile();
	}

	private static void defineNOKFromFirstAndSecondNumbers() {
		List<Integer> multipliersOfFirstNumber = new ArrayList<>();
		List<Integer> multipliersOfSecondNumber = new ArrayList<>();
		getFactorization(multipliersOfFirstNumber);
		getFactorization(multipliersOfSecondNumber);

		// ...some codeee
	}

	private static List<Integer> getFactorization(List<Integer> multipliers) {
		List<Integer> factorization = multipliers;

		// ...some codeee

		return result;
	}

	public static void setFirstNumber(long firstNumber) {
		Task14.firstNumber = firstNumber;
	}

	public static void setSecondNumber(long secondNumber) {
		Task14.secondNumber = secondNumber;
	}

	public static long getNOKFromFirstAndSecondNumbers() {
		return NOKFromFirstAndSecondNumbers;
	}
}

class InputFile {
	private static final String INPUT_FILE_PATHNAME = "INPUT.txt";

	public static boolean readInputFile() { 
		try (Scanner reader = new Scanner(new File(INPUT_FILE_PATHNAME))) { 
			Task14.setFirstNumber(reader.nextLong());
			Task14.setSecondNumber(reader.nextLong());
            successfulMessage();
			return true;
        } catch (FileNotFoundException e) {
            errorMessage();
			return false;
        }
	}

	private static void successfulMessage() {
		System.out.println("File " + INPUT_FILE_PATHNAME + " successfully read");
	}
	
	private static void errorMessage() {
		System.out.println("File " + INPUT_FILE_PATHNAME + " not found");
	}

	
}

class OutputFile {
	private static final String OUTPUT_FILE_PATHNAME = "OUTPUT.txt";

	public static boolean writeOutputFile() {
		try (PrintWriter writer = new PrintWriter(new File(OUTPUT_FILE_PATHNAME))) {
			writer.println(Task14.getNOKFromFirstAndSecondNumbers());
			successfulMessage();
			return true;
		} catch (FileNotFoundException e) {
			errorMessage();
			return false;
		}
	}

	private static void successfulMessage() {
		System.out.println("File " + OUTPUT_FILE_PATHNAME + " successfully written");
	}
	
	private static void errorMessage() {
		System.out.println("File " + OUTPUT_FILE_PATHNAME + " not found");
	}
}