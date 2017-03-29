package permutation;

import java.util.Scanner;

public class Handler {
	
	String input;
	
	char[] inputCharArray;
	int[] indexesOfInputStringAsCharArray;
	
	Scanner sc = new Scanner(System.in);
	
	void begin(){
		System.out.println("Enter in the string you want to permutate\n");
		input = sc.next();
		convertInputToArray();	
		process(indexesOfInputStringAsCharArray);
	}


	
	void process(int[] input){
		
		printInput();
		
		for (int i = input.length - 1; i > 0; i--){
			if (input[i] > input[i - 1]){
				for (int x = 0; x < (i - 1); x++){
					
				}
			}
		}
		return;
		
	}
	
	public void convertInputToArray() {
		inputCharArray = input.toCharArray();
		indexesOfInputStringAsCharArray = new int[inputCharArray.length];
		for (int i = 0; i < inputCharArray.length; i++){
			indexesOfInputStringAsCharArray[i] = i;
		}
	}
	
	public void printInput() {
		String output = "";
		for (int index : indexesOfInputStringAsCharArray){
			output += inputCharArray[index];
			System.out.println(index);
		}
		System.out.println(output);
	}

	public static void main(String[] args) {
		Handler handler = new Handler();
		handler.begin();
	}
}
