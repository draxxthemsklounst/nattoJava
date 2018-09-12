package algorithm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class sortingAlgorithms {
	public static void sortArrayMenu() {
		Scanner scanner = new Scanner(System.in);
		int Which, howMany;
		
		System.out.println("How many elements?");
		howMany = scanner.nextInt();
		
		
		
		System.out.println("What type of sort would you like to execute?");
		System.out.println("(1) - Iterative Bubble Sort ");
		System.out.println("(2) - Recursive Bubble Sort ");
		System.out.println("(3) - Selection Sort ");
		System.out.println("(4) - Iterative Insertion Sort ");
		System.out.println("(5) - Recursive Insertion Sort ");
		System.out.println("(6) - Merge Sort ");
		Which = scanner.nextInt();
		
		if(Which == 1) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			sortingAlgorithms.iterativeBubbleSort(temp, howMany);
			sortingAlgorithms.displayArray(temp, howMany);
		}
		else if (Which ==2) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			sortingAlgorithms.recursiveBubbleSort(temp, howMany);
			sortingAlgorithms.displayArray(temp, howMany);
		}
		else if (Which == 3) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			sortingAlgorithms.selectionSort(temp,howMany);
			sortingAlgorithms.displayArray(temp, howMany);
		}
		else if(Which == 4) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			sortingAlgorithms.iterativeInsertionSort(temp, howMany);
			sortingAlgorithms.displayArray(temp, howMany);
		}
		else if(Which == 5) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			sortingAlgorithms.recursiveInsertionSort(temp, howMany,0);
			sortingAlgorithms.displayArray(temp, howMany);
		}
		else if(Which == 6) {
			int temp[] = randArray(howMany);
			sortingAlgorithms.displayArray(temp, howMany);
			System.out.println("Sorting...");
			sortingAlgorithms.mergeSort(temp, 0, howMany-1);
			sortingAlgorithms.displayArray(temp, howMany);
		}
		scanner.close();
	}
	
	
	private static void iterativeBubbleSort(int arr[], int howMany)
	{
		
		for(int i = 0; i < howMany - 1; i ++)
		{
			for(int j = 0; j < howMany - 1 - i; j++ )
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	private static void recursiveBubbleSort(int arr[], int howMany)
	{
		if(howMany == 1)
			return;
		for(int i = 0; i < howMany-1; i++) {
			if(arr[i] > arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		recursiveBubbleSort(arr,howMany-1);
	}
	private static void selectionSort(int[] arr, int howMany) {
		for(int i = 0; i < howMany - 1; i++) {
			int smallestIndex = i;
			for(int j = i+1; j<howMany; j++) {
				if(arr[j]<=arr[smallestIndex])
					smallestIndex = j;
			}
			int swap = arr[i];
			arr[i] = arr[smallestIndex];
			arr[smallestIndex] = swap;
		}
	}
	private static void iterativeInsertionSort(int[] arr, int howMany) {
		int sortedIndex;
		for(int i = 0; i < howMany; i++) {
			sortedIndex = i;
			for(int j = 0; j<sortedIndex; j++) {
				if(arr[sortedIndex] <= arr[j]) {
					int swap = arr[sortedIndex];
					arr[sortedIndex] = arr[j];
					arr[j] = swap;
				}
			}
		}
	}
	private static void recursiveInsertionSort(int[] arr, int howMany, int sortedIndex) {
		if(sortedIndex == howMany)
			return;
		for(int j = 0; j<sortedIndex; j++) {
			if(arr[sortedIndex] <= arr[j]) {
				int swap = arr[sortedIndex];
				arr[sortedIndex] = arr[j];
				arr[j] = swap;
			}
		}
		sortedIndex++;
		recursiveInsertionSort(arr, howMany, sortedIndex);
	}

	private static void mergeSort(int[] arr, int begin, int end) {
		if(begin < end) {
			int middle = (begin + end)/ 2;
			mergeSort(arr,begin,middle);
			mergeSort(arr,middle+1,end);
			merge(arr,begin,middle,end);
		}
	}
	private static void merge(int[] arr, int begin, int middle, int end) {
		int half1 [] = new int[middle-begin+1]; //cloning the two "halves" of input array
		int half2 [] = new int[end-middle];
		
		int tempindex1 = 0;
		for(int i = begin; i < middle+1; i++) { //copying first half and second half into the clones
			half1[tempindex1] = arr[i];
			tempindex1++;
		}
		int tempindex2 = 0;
		for(int j = middle+1; j < end+1; j++) {
			half2[tempindex2] = arr[j];
			tempindex2++;
		}
		int index1 = 0; //index for each item "transferred" from clone to sorted array
		int index2 = 0;
		for(int j = begin; j< end+1; j++) {
			
			if(index1 < half1.length && index2 >= half2.length) {
				arr[j] = half1[index1];
				index1++;
			}
			else if(index1 >= half1.length && index2 < half2.length) {
				arr[j] = half2[index2];
				index2++;
			}
			
			else if(half1[index1] <= half2[index2] && index1 < half1.length && index2 < half2.length) {
				arr[j] = half1[index1];
				index1++;
				
			}
			else if(half1[index1] > half2[index2] && index1 < half1.length && index2 < half2.length) {
				arr[j] = half2[index2];
				index2++;
			}
			
		}
	}

	private static void displayArray(int arr[], int howMany)
	{
		for(int i = 0;i<howMany;i++)
		{
			System.out.printf("%d\t", arr[i]);
			if( (i+1)%10 == 0 )
				System.out.println();
		}
		System.out.println();
	}
	private static int[] randArray(int howMany)
	{
		Random randInstance = new Random();
		int randomArr[] = new int[howMany];
		for(int i = 0; i < howMany; i++)
		{
			randomArr[i] = randInstance.nextInt(100)+1;
		}
		return randomArr;
			
	}
}
