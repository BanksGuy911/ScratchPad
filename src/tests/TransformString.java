package tests;

public class TransformString {
	
	/*Interview problem
		Given N Integer:
		produce a String that is composed on N 'a' characters
		Transform the string as follows:
			1) for every matching character, replace the pair with the next character in the alphabet: ex;
			    aaaaaaaaaaa -> bbbbba -> ccba -> dba 
			    
			2) Constraints
			 	if N = 1, return "a"
			 	zz cannot be transformed since its at the end of the alphabet
			 	N can be any integer from 1 - max
	*/
	public String transformWRec(Integer n) {
		if (n == 1) return "a";//base case		
		
		String input = "";
		for (int i = 0; i < n; i++) {
			input += "a";
		}
		
		return transformRecursive(input,"", 0);
	}
	
	public String transformWIter(Integer n) {
		if (n == 1) return "a";//base case		
		
		String input = "";
		for (int i = 0; i < n; i++) {
			input += "a";
		}
		
		String result = transformIterative(input);
		while (result.matches(".*(.)\\1.*")) {
			System.out.println("result: " + result);
			result = transformIterative(result);
		}
		return result;
	}
	
	private String transformRecursive(String input, String modified, int index) {
		//System.out.println("input String: " + input);
		//System.out.println("modified String: " + modified);
		//System.out.println("index is: " + index);
		if (index == input.length() - 1) {
			modified = modified + input.charAt(index);
			if(!modified.matches(".*(.)\\1.*"))
				return modified;
			else
				return transformRecursive(modified, "", 0);
		}
		if (index == input.length()) {
			if(!modified.matches(".*(.)\\1.*"))
				return modified;
			else
				return transformRecursive(modified, "", 0);
		}
		if (input.charAt(index) != 'z' && input.charAt(index) == input.charAt(index + 1)) {
			modified += (char) (input.charAt(index) + 1);
			index += 2;
		} else {
			modified += input.charAt(index);
			index++;
		}
		return transformRecursive(input, modified, index);
	}
	
	private String transformIterative(String input) {
		String result = "";

		// iterate through the input string
		int index = 0;
		while (index < input.length()) {
			if (index == input.length() - 1) {
				result = result + input.charAt(index);
				break;
			} else if (index == input.length()) {
				break;
			} else {
				System.out.println("index: " + index);
				if (input.charAt(index) != 'z' && input.charAt(index) == input.charAt(index + 1)) {
					result += (char) (input.charAt(index) + 1);
					index += 2;
				} else {
					result += input.charAt(index);
					index++;
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
	    TransformString ip = new TransformString();
	    int n = 11;
		String result = ip.transformWRec(n);
		String result2 = ip.transformWIter(n);
		System.out.println("Result of recursive method is: ");
		System.out.println(result);
		System.out.println("Result of iterative method is:");
		System.out.println(result2);
	}
}
