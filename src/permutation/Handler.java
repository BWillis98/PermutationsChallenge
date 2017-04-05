package permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Handler {
	
	String input;
	
	char[] inputCharArray;
	
	int[] indexesOfInputStringAsCharArray;
	
	Scanner sc = new Scanner(System.in);
	
	private void begin(){
		System.out.println("Enter in the string you want to permutate\n");
		input = sc.next();
		
		convertInputToArray();	
		process(indexesOfInputStringAsCharArray);
	}

	private void process(int[] input){
		printInputParameter();
		
		// Searches for a time where a number is bigger than the one that's to its left.
		for (int i = input.length - 1; i > 0; i--){
			if (input[i] > input[i - 1]){
				updateIndexesArray(i - 1);
				process(indexesOfInputStringAsCharArray);
			}
		}
		return;
	}
	
	private void updateIndexesArray(int indexOfMajorChangingNumber) {
		// Shorter variable names
		int majorIndex = indexOfMajorChangingNumber;
		int majorNumber = indexesOfInputStringAsCharArray[majorIndex];
		
		// Guaranteed for there to be a next smallest b/c current method only gets called if there is.
		swapWithNextSmallestNumber(majorIndex, majorNumber);
		sortRemainder(majorIndex);
	}
	
	public void sortRemainder(int majorIndex) {
		int remainderLength = (indexesOfInputStringAsCharArray.length - 1) - majorIndex;
		int[] leftOverArrayToSort = new int[remainderLength];
		leftOverArrayToSort = getRemainder(majorIndex, leftOverArrayToSort);
		Arrays.sort(leftOverArrayToSort);
		assignRemainderToIndexArray(majorIndex, leftOverArrayToSort);
	}

	public void assignRemainderToIndexArray(int majorIndex, int[] leftOverArrayToSort) {
		for (int i = majorIndex + 1, j = 0; i < indexesOfInputStringAsCharArray.length; i++, j++){
			 indexesOfInputStringAsCharArray[i] = leftOverArrayToSort[j];
		}
	}

	public int[] getRemainder(int majorIndex, int[] leftOverArrayToSort) {
		for (int i = majorIndex + 1, j = 0; i < indexesOfInputStringAsCharArray.length; i++, j++){
			leftOverArrayToSort[j] = indexesOfInputStringAsCharArray[i];
		}
		return leftOverArrayToSort;
	}

	public void swapWithNextSmallestNumber(int majorIndex, int majorNumber) {
		boolean done = false;
		int nextBiggest = majorNumber;
		while (!done){
			nextBiggest++;
			for (int i = majorIndex + 1; i < indexesOfInputStringAsCharArray.length; i++){
				if (indexesOfInputStringAsCharArray[i] == nextBiggest){
					indexesOfInputStringAsCharArray[majorIndex] = indexesOfInputStringAsCharArray[i];
					indexesOfInputStringAsCharArray[i] = majorNumber;
					done = true;
				}
			}
		}
	}

	private void convertInputToArray() {
		inputCharArray = input.toCharArray();
		indexesOfInputStringAsCharArray = new int[inputCharArray.length];
		for (int i = 0; i < inputCharArray.length; i++){
			indexesOfInputStringAsCharArray[i] = i;
		}
	}
	
	
	private void printInputParameter() {
		String output = "";
		for (int index : indexesOfInputStringAsCharArray){
			output += inputCharArray[index];
		}
		System.out.println(output);
	}
	

	public static void main(String[] args) {
		Handler handler = new Handler();
		handler.begin();
	}
}