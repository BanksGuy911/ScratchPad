package tests;

import java.util.ArrayList;
import java.util.Optional;

public class IntegerContainerProblem3 {

	private ArrayList<Integer> integers = new ArrayList<>();
	
	public IntegerContainerProblem3() {
	// TODO Auto-generated constructor
		integers = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*input:
		 *	queries = [["ADD","1"],["ADD","2"],["ADD","2"],["ADD","4"],["GET_NEXT","1"],["GET_NEXT","2"],["GET_NEXT","3"],["GET_NEXT","4"],["REMOVE","2"],["GET_NEXT","1"],["GET_NEXT","2"],["GET_NEXT","3"],["GET_NEXT","4"]] 
		 */
		
		String[][] queries = new String[][]{{"ADD","1"},{"ADD","2"},{"ADD","2"},{"ADD","4"},{"GET_NEXT","1"},{"GET_NEXT","2"},{"GET_NEXT","3"},{"GET_NEXT","4"},{"REMOVE","2"},{"GET_NEXT","1"},{"GET_NEXT","2"},{"GET_NEXT","3"},{"GET_NEXT","4"}} ;
		IntegerContainerProblem3 main = new IntegerContainerProblem3();
		String[] answers  = main.solution(queries);
		
		String answer = "[";
		for(int i = 0; i < answers.length-1; i++){
                       answer += answers[i]+ ",";
		}
		answer += answers[answers.length-1] + "]";
		System.out.println(answer);
		
		
}
	String[] solution(String[][] queries) {
	    String[] answers = new String[queries.length];	    
	    
	    for(int i = 0; i < queries.length; i++){
	        String[] query = queries[i];
	        String operation = query[0];
	        Integer value = Integer.parseInt(query[1]);
	        
	        switch(operation){
	            case "ADD":
	                integers.add(value);
	                answers[i] = "";
	            break;
	            case "EXISTS":
	                answers[i] = String.valueOf(integers.contains((Integer)value));
	            break;
	            case "REMOVE":
	                answers[i] = String.valueOf(integers.remove((Integer)value));
	            break;
	            case "GET_NEXT":                
	                Optional<Integer> next = integers.stream()
	                .filter(listItems -> listItems > value)
	                .distinct()
	                .sorted()
	                .findFirst();
	                
	                answers[i] = (next.isEmpty())?"":String.valueOf(next.get());
	            break;
	            default:
	            break;
	        }   
	    }
	    return answers;
	}

}
