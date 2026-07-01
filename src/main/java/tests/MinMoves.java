package tests;

import java.util.ArrayList;
import java.util.List;


public class MinMoves {

	/*
	 * Complete the 'minMoves' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */

	public static int minMoves(List<Integer> arr) {
		
		//print  
		System.out.println("input: " + arr);
		
		// Write your code here
		/*
            We can just get a count of one and zeros to swap left. And take the min of the two values. 
		 */
		int moves = 0;
	    int leftOnes = 0;
	    int leftZeros = 0;

	    int swapsZeros = 0; 
	    int swapsOnes = 0; 
	    
	    for (int i = 0; i < arr.size() ; i++) {
	    	int val = arr.get(i);
	        if (val == 1) {
	            // This 1 contributes to future (1,0) inversions
	        	leftOnes++;

	            // This 1 is currently after some zeros → (0,1) inversions
	        	swapsOnes += leftZeros;
	        } else { // x == 0
	            // This 0 contributes to future (0,1) inversions
	        	leftZeros++;

	            // This 0 is currently after some ones → (1,0) inversions
	        	swapsZeros += leftOnes;
	        }
	    }
	    
		moves = Math.min(swapsOnes, swapsZeros);
		return moves;
	}

	public static void main(String args[]) {
		
		//Inputs [0111101], [0101011], [101010], [0,0,1,0,1,0,1,1]
		
		List<Integer> arr1 = List.of(0,1,1,1,1,0,1);
		List<Integer> arr2 = List.of(0,1,0,1,0,1,1);
		List<Integer> arr3 = List.of(1,0,1,0,1,0);
		List<Integer> arr4 = List.of(0,0,1,0,1,0,1,1);
		
		ArrayList<List<Integer>> expectedInputs = new ArrayList<>();
		expectedInputs.add(arr1);
		expectedInputs.add(arr2);
		expectedInputs.add(arr3);
		expectedInputs.add(arr4);
		

		
		System.out.println(" min Moves are:");
		for (List<Integer> input : expectedInputs) {
			System.out.println("input: " + input + " | min moves: " + minMoves(input));
		}
	}
}