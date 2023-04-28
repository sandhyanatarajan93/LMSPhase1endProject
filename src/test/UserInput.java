package test;

import java.util.Scanner;

public class UserInput {
	
	
	
	
	public static String UserInputSearch() {
		
		String searchvalue;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the search value:");
		
		searchvalue = scanner.nextLine();
		
		return searchvalue;
		
	}
	

}
