package permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Handler {

	protected void begin() {
		/*
		 * This method is called when the user wishes to being the process of
		 * printing every possible permutation of a given string.
		 * 
		 * The method 1. Receives user input.
		 * 
		 * 2. Converts that input to a sorted char array
		 * 
		 * 3. Invokes the process method, passing in the sorted char array
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter in the string you want to permutate\n");
		String input = sc.next();
		sc.close();
		char[] inputCharArray = input.toCharArray();
		Arrays.sort(inputCharArray);
		do {
			inputCharArray = process(inputCharArray);
		} while (inputCharArray != null);
	}

	protected char[] process(char[] input) {
		/*
		 * This method is intended to handle the overall process and implement
		 * my algorithm to generate every possible permutation.
		 * 
		 * 1. Print out char[] input parameter (a permutation of the input
		 * string)
		 * 
		 * 2. Update input array to the next permutation
		 * 
		 * 3. Return the Input array
		 */
		System.out.println(String.valueOf(input));
		// Searches for a time where a char is greater than the one to its left
		for (int i = input.length - 1; i > 0; i--) {
			if (input[i] > input[i - 1]) {
				input = swapWithNextSmallestChar(input, i - 1);
				input = sortRemainder(input, i - 1);
				return input;
			}
		}
		return null;
	}

	protected char[] sortRemainder(char[] input, int majorIndex) {
		/*
		 * This method sorts portion of the input array from the majorindex + 1
		 * to the end of the input array.
		 * 
		 * 1. Creates a left over array that represents the tail end of the
		 * input array.
		 * 
		 * 2. Sorts the left over array.
		 * 
		 * 3. Inserts the sorted remainder back into the input array.
		 */
		int remainderLength = (input.length - 1) - majorIndex;
		char[] remainder = new char[remainderLength];
		remainder = Arrays.copyOfRange(input, majorIndex + 1, input.length);
		Arrays.sort(remainder);
		// Reassign sorter remainder into input array
		for (int j = 0; j < remainder.length; j++) {
			input[majorIndex + 1 + j] = remainder[j];
		}
		return input;
	}

	protected char[] swapWithNextSmallestChar(char[] input, int majorIndex) {
		/*
		 * This method method takes the value at the index: majorIndex in the
		 * input array and swaps that char with the next smallest one.
		 * 
		 * 1. Establish our major char that will definitely be swapped.
		 * 
		 * 2. Loops through the input array to the right of the majorIndex and
		 * swaps the value at majorIndex with the next smallest char.
		 */
		char majorChar = input[majorIndex];
		char nextBiggest = majorChar; // ASCII of majorNumber
		boolean done = false;
		while (!done) {
			nextBiggest++; // Increases to find next biggest
			for (int i = majorIndex + 1; i < input.length; i++) {
				if (input[i] == nextBiggest) {
					input[majorIndex] = input[i];
					input[i] = majorChar;
					done = true;
					break;
				}
			}
		}
		return input;
	}

	public static void main(String[] args) {
		Handler handler = new Handler();
		handler.begin();
	}
}