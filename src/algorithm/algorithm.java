package algorithm;

import java.io.IOException;
import java.util.Scanner;

public class algorithm {
	public static void main(String [] args) throws IOException {
		//algorithm.mainMenu();
		gui Gui = new gui();
	}
	
	private static void mainMenu() {
		boolean keepGoing = true;
		Scanner cin = new Scanner(System.in);
		while(keepGoing) {
			System.out.println("(1) Search an array\n"
							+ "(2) Sort an array\n"
							+ "(3) Hash Table\n"
							+ "(4) Nth Fibonacci finder");
			int choice = cin.nextInt();
			
			if(choice == 1) {
				searchingAlgorithms.searchArrayMenu();
			}
			else if(choice == 2) {
				sortingAlgorithms.sortArrayMenu(cin);//pass in the scanner
			}
			else if (choice == 3) {
				hashTable.hashMenu();
			}
			else if (choice == 4) {
				fib.fibMenu();
			}
			System.out.println("Do you want to perform another operation? (1)Yes or (0)No?");
			try {
				choice = cin.nextInt();
				if (choice != 1)
					keepGoing = false;
			} catch(Exception e) {
				System.out.println("Error occured.");
				keepGoing = false;
			}
			if(keepGoing == false)
				System.out.println("Exiting... ");
			
		}
		cin.close();
	}
	
	
}
