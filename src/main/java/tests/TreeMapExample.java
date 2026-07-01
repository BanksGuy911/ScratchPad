package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeMapExample {
	
	public void example1() {
        // Create a TreeMap containing event names and their dates
    	
    	
        TreeMap<String, String> eventDates = new TreeMap<>();
        eventDates.put("Concert", "2023-06-21");
        eventDates.put("Conference", "2023-07-12");
        eventDates.put("Seminar", "2023-06-11");
        eventDates.put("Workshop", "2023-08-05");

        // TODO: Write logic to find and display the name of the event that is scheduled immediately after 'Seminar'
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        TreeMap<Date, String> orderedByDate = new TreeMap<>();
        
        for(java.util.Map.Entry<String,String> entry: eventDates.entrySet()){
            try{
                orderedByDate.put(formatter.parse(entry.getValue()), entry.getKey());
            }catch(ParseException pe){
                System.out.println(pe.getMessage());
                pe.printStackTrace();
            }
        }//end for
        
        //solution block
        String seminarKey = "Seminar";
        String seminarVal = eventDates.get(seminarKey);
        try{
            Date seminarDateKey = formatter.parse((seminarVal == null)?"":seminarVal);
            String eventAfterVal = orderedByDate.higherEntry(seminarDateKey).getValue();
            System.out.println("event immediately after is: " + eventAfterVal);
        }catch(ParseException pe){
            System.out.println("Error in solution block");
        }
	}
	
	public void example2() {
        // TODO: Initialize a TreeMap named participantScores (name -> score mapping) to track the scores of different participants (Feel free to choose any participant names and scores)
        TreeMap<String, Integer> participantScores = new TreeMap<>();
        participantScores.put("Oscar", 500);
        participantScores.put("Sabar", 50000);
        participantScores.put("Tareeq", 5000);
        participantScores.put("Betty", 25000 );
        participantScores.put("Gemma", 15000);
        participantScores.put("Hitomi", 125000);
        participantScores.put("Hayate", 200000);

        // TODO: Determine who has the highest score and print their name as the top performer
        Optional<String> starPlayer = participantScores.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey);
            
        System.out.println("our Star Player is:  " + starPlayer.orElseGet(() -> ""));  
	}
	
	public void streamSorting() {
    	HashMap<String, String> bank = new HashMap<>();
    	bank.put("1234", "abcsdf");
    	bank.put("4567", "defsdfs");
    	bank.put("78910","sfasdfsdfsadfdsafasd");
    	
    	List<String> sortedOnKey = bank.entrySet().stream()
                .sorted((entry1, entry2) -> ((Integer)entry1.getValue().length()).compareTo((Integer)entry2.getValue().length()))
    			.map(Map.Entry::getKey)
    			.collect(Collectors.toList());
    	
    	sortedOnKey.forEach(item -> System.out.println(item));
    	
	}
	
    public static void main(String[] args) {
 
    	TreeMapExample example = new TreeMapExample();
    	example.streamSorting();
    	long num = 123456789123456L;
    	System.out.println(Long.parseLong(String.valueOf(num).substring(12,13)));
    	System.out.println(String.valueOf(num % 2));
        
    }

}


