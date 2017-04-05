package permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Handler {

	private void begin() {
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
		char[] inputCharArray = input.toCharArray();
		Arrays.sort(inputCharArray);
		do {
			inputCharArray = process(inputCharArray);
		} while (inputCharArray != null);
	}

	private char[] process(char[] input) {
		/*
		 * This method is intended to handle the overall process and implement
		 * my algorithm to generate every possible permutation.
		 * 
		 * 1. Print out char[] input parameter (a permutation of the input
		 * string)
		 * 
		 * 2. Update input array to the next permutation
		 * 
		 * 3. Call this method again, passing in the next permutation.
		 */
		System.out.println(String.valueOf(input));
		// Searches for a time where a char is greater than the one to its left
		for (int i = input.length - 1; i > 0; i--) {
			if (input[i] > input[i - 1]) {
				input = updateInputArray(input, i - 1);
				return input;
			}
		}
		return null;
	}

	private char[] updateInputArray(char[] input, int indexOfMajorChangingChar) {
		/*
		 * It is guaranteed for there to be a char that is smaller than the char
		 * in the input array at the index: indexOfMajorChangingChar b/c current
		 * method only gets called if there is. *See process for proof of this*
		 * 
		 * This method:
		 * 
		 * 1. Swaps the major changing char with the smallest char to it's right
		 * in the string.
		 * 
		 * 2. Sorts everything to the right of the major changing char.
		 */
		//
		input = swapWithNextSmallestChar(input, indexOfMajorChangingChar);
		sortRemainder(input, indexOfMajorChangingChar);
		return input;
	}

	public char[] sortRemainder(char[] input, int majorIndex) {
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
		char[] leftOverArray = new char[remainderLength];
		leftOverArray = Arrays.copyOfRange(input, majorIndex + 1, input.length);
		Arrays.sort(leftOverArray);
		return assignRemainderToInputArray(input, majorIndex, leftOverArray);
	}

	public char[] assignRemainderToInputArray(char[] input, int majorIndex, char[] leftOverArray) {
		for (int j = 0; j < leftOverArray.length; j++) {
			input[majorIndex + 1 + j] = leftOverArray[j];
		}
		return input;
	}

	public char[] swapWithNextSmallestChar(char[] input, int majorIndex) {
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