package tests;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Scratch {
	
	
	public static void main(String args[]) {
		//tradition loop
		/*for (int i = 0; i < 5; i++) {
			System.out.println("Hello, I am a traditional loop:" + i);
		}
		
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		for (String arg : list) {
			System.out.println("Hello, I am a for each loop:" + arg);
		}
		
		list.forEach((item) -> {
			System.out.println("Hello, I am a lambda loop:" + item);
		});
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("cat");
		list2.add("dog");
		list2.add("bird");
		list2.add("fish");
		list2.add("horse");
		list2.add("Lizard");
		
		List<String> threeletterwords = list2.stream().filter((word) -> word.length() == 3)
				.collect(Collectors.toList());
		
		System.out.println("Three letter words from list 2 are:");
		threeletterwords.forEach((word) -> { System.out.println(word); });
		
		//Test conditional
		if (list2.contains("cat")) {
			System.out.println("Cat is in the list");
		} else if(list2.contains("dog")) {
			System.out.println("Dog is in the list");
		} else {
			System.out.println("Cat, and Dog, are not in the list");
		}
		
		

		
	   	int unsignedInt = 1294967295; // Example: Maximum value for a 32-bit unsigned integer
	    int unsignedInt2 = 5250; // Example: Maximum value for a 32-bit signed integer
	    int unsignedInt3 = 1073741823; // Example: Maximum value for a 30-bit signed integer
	    int unsignedInt4 = 329123; // Example: Maximum value for a 30-bit signed integer
	
	    String bits = getBits(unsignedInt);
	    String bits2 = getBits(unsignedInt2);
	    String bits3 = get30Bits(unsignedInt3);
	    String bits4 = get30Bits(unsignedInt4);
	    System.out.println(bits);
	    System.out.println(bits2);
	    System.out.println(bits3);
	    System.out.println(bits4);
	    */
	    
	    int[] arr = {1, 3, 6, 4, 1, 2};
	    int[] arr2 = {1, 2, 3};
	    int[] arr3 = {-1, -3};
	    
	    System.out.println(smallestPositive(arr));
	    System.out.println(smallestPositive(arr2));
	    System.out.println(smallestPositive(arr3));
	}

	public static String getBits(int n) {
	    StringBuilder binary = new StringBuilder();
	    for (int i = 31; i >= 0; i--) {
	        // Check if the i-th bit is set using right bit shift and bitwise AND
	        int bit = (n >>> i) & 1;
	        binary.append(bit);
	    }
	    return binary.toString();
	}
	
	public static String get30Bits(int n) {
	    if (n < 0 || n >= (1 << 30)) {
	        throw new IllegalArgumentException("Number must be between 0 and 2^30 - 1");
	    }
	
	    StringBuilder binary = new StringBuilder();
	    for (int i = 29; i >= 0; i--) {
	        binary.append((n >> i) & 1);
	    }
	    return binary.toString();
	}
	
    public int oddOccurancesProblem(int[] arr) {
        // Implement your solution here
        int oddDuck = 0;
        HashMap<Integer, Integer> buckets = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            buckets.put(arr[i], (buckets.get(arr[i])==null)?1:buckets.get(arr[i]) + 1);
        }
        oddDuck = buckets.entrySet().stream()
                    .filter(entry -> entry.getValue()%2 != 0)
                    .findFirst()
                    .map(Map.Entry::getKey)
                    .orElse(-1);

        return oddDuck;
    }
    
    
    /*Example test:   [1, 3, 6, 4, 1, 2]
    		Output:
    		[Ljava.lang.Integer;@262b2c86
    		WRONG ANSWER (got 7 expected 5)

    		Example test:   [1, 2, 3]
    		Output:
    		[Ljava.lang.Integer;@262b2c86
    		OK

    		Example test:   [-1, -3]
    		Output:
    		[Ljava.lang.Integer;@262b2c86
    		OK
    		
    		This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
    		*/
    		
    		
	public static int smallestPositive(int[] arr) {
		// Implement your solution here
        if (arr == null || arr.length == 0 || arr.length > 100000) {
            return 1;
        }

		ArrayList<Integer> numsAsList = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));

		Collections.sort(numsAsList);
		Integer[] sortedInts = numsAsList.toArray(new Integer[arr.length]);
		for(int i = 0; i < sortedInts.length; i++) {
			System.out.println(sortedInts[i]);
		}
		int smallest = 1;
		for (int i = 0; i < sortedInts.length; i++) {
			if (i == sortedInts.length - 1) {
				smallest = sortedInts[i] + 1;
			} else {
				if (sortedInts[i] != sortedInts[i+1] && sortedInts[i + 1] != sortedInts[i] + 1 && sortedInts[i] > 0) {
					smallest = sortedInts[i] + 1;
					break;
				}
			}
		}
		if (smallest <= 0)
			smallest = 1;
		return smallest;
	}
	

	public int bridgeProblem(int weightLimit, int[] weight) {
	        // Implement your solution here
	        Bridge myBridge = new Bridge(weightLimit);

	        int turnAwayCount=0;
	        for(int i = 0; i < weight.length; i++){
	            if(!myBridge.atCarCapacity()){
	                if(!myBridge.enterBridge(weight[i])){
	                    turnAwayCount++;
	                }
	            } else{
	                myBridge.leaveBridge();
	                i=i-1;
	            }
	        }
	        return turnAwayCount;
	    }
}

class Bridge {
    private ArrayDeque<Integer> road;
    private int roadCapacity;
    private int weightLimit;

    public Bridge(int weightLimit){
        road = new ArrayDeque(2);
        roadCapacity = 2;
        this.weightLimit = weightLimit;
    }

    public boolean enterBridge(int weight){     
        if (!road.isEmpty()){
            if(road.peek() + weight > weightLimit)
                return false;
            else 
                road.add(weight);       
        }else{
            road.add(weight);
        }
        return true;
    }

    public Integer leaveBridge(){
        return road.remove();
    }

    public boolean atCarCapacity(){
        if(road.size() < roadCapacity)
            return false;

        return true; 
    }

    public void printBridge(){
        System.out.println(road);
    }
}
