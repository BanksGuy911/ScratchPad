package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scratch {
	
	
public static void main(String args[]) {
	//tradition loop
	for (int i = 0; i < 5; i++) {
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
	
	System.out.println("Three letter workds from list 2 are:");
	threeletterwords.forEach((word) -> { System.out.println(word); });
	
	//Test conditional
	if (list2.contains("cat")) {
		System.out.println("Cat is in the list");
	} else if(list2.contains("dog")) {
		System.out.println("Dog is in the list");
	} else {
		System.out.println("Cat, and Dog, are not in the list");
	}
}

}
