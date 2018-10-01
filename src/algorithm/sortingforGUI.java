package algorithm;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class sortingforGUI extends sortingAlgorithms{
	public static void sortArrayMenu(Scanner scanner, PrintStream out) {
		int Which, howMany;
		System.setOut(out);
		
		System.out.println("How many elements?");
		howMany = scanner.nextInt();
		
		System.out.println("What type of sort would you like to execute?");
		System.out.println("(1) - Iterative Bubble Sort ");
		System.out.println("(2) - Recursive Bubble Sort ");
		System.out.println("(3) - Selection Sort ");
		System.out.println("(4) - Iterative Insertion Sort ");
		System.out.println("(5) - Recursive Insertion Sort ");
		System.out.println("(6) - Recursive Merge Sort ");
		System.out.println("(7) - Quicksort ");
		System.out.println("(8) - Array.Sort (java.util.Arrays) ");
		Which = scanner.nextInt();
		
		if(Which == 1) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			float startTime = System.nanoTime();
			sortingAlgorithms.iterativeBubbleSort(temp, howMany);
			float endTime = System.nanoTime();
			float milliduration = (endTime - startTime) / 1000000; //milliseconds
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.printf("Execution time: %f milliseconds or %f seconds \n",milliduration,milliduration/1000);
		}
		else if (Which ==2) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			float startTime = System.nanoTime();
			sortingAlgorithms.recursiveBubbleSort(temp, howMany);
			float endTime = System.nanoTime();
			float milliduration = (endTime - startTime) / 1000000; //milliseconds
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.printf("Execution time: %f milliseconds or %f seconds \n",milliduration,milliduration/1000);
		}
		else if (Which == 3) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			float startTime = System.nanoTime();
			sortingAlgorithms.selectionSort(temp,howMany);
			float endTime = System.nanoTime();
			float milliduration = (endTime - startTime) / 1000000; //milliseconds
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.printf("Execution time: %f milliseconds or %f seconds \n",milliduration,milliduration/1000);
		}
		else if(Which == 4) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			float startTime = System.nanoTime();
			sortingAlgorithms.iterativeInsertionSort(temp, 0,howMany);
			float endTime = System.nanoTime();
			float milliduration = (endTime - startTime) / 1000000; //milliseconds
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.printf("Execution time: %f milliseconds or %f seconds \n",milliduration,milliduration/1000);
		}
		else if(Which == 5) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			float startTime = System.nanoTime();
			sortingAlgorithms.recursiveInsertionSort(temp, howMany, 0);
			float endTime = System.nanoTime();
			float milliduration = (endTime - startTime) / 1000000; //milliseconds
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.printf("Execution time: %f milliseconds or %f seconds \n",milliduration,milliduration/1000);
		}
		else if(Which == 6) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			float startTime = System.nanoTime();
			sortingAlgorithms.mergeSort(temp, 0, howMany-1);
			float endTime = System.nanoTime();
			float milliduration = (endTime - startTime) / 1000000; //milliseconds
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.printf("Execution time: %f milliseconds or %f seconds \n",milliduration,milliduration/1000);
		}
		else if(Which ==7) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			float startTime = System.nanoTime();
			sortingAlgorithms.quickSort(temp);
			float endTime = System.nanoTime();
			float milliduration = (endTime - startTime) / 1000000; //milliseconds
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.printf("Execution time: %f milliseconds or %f seconds \n",milliduration,milliduration/1000);
		}
		else if(Which ==8) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			float startTime = System.nanoTime();
			//sortingAlgorithms.timSort(temp,howMany);
			Arrays.sort(temp);
			float endTime = System.nanoTime();
			float milliduration = (endTime - startTime) / 1000000; //milliseconds
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.printf("Execution time: %f milliseconds or %f seconds \n",milliduration,milliduration/1000);
		}
	}
}
