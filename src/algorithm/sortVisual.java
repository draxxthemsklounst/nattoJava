package algorithm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

public class sortVisual extends JPanel{
	private static final int HEIGHT = 500;
	private static final int WIDTH = 1000;
	private int DefaultMaxInt = WIDTH/10;
	private boolean Init;
	private BufferedImage img;
	private Graphics2D gr;
	
	public sortVisual() {
		
		this.setSize(new Dimension(WIDTH,HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		Init = true;
		
		img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		gr = (Graphics2D) img.getGraphics();
		this.repaint();
	}
	
	public void publicDraw() {
		draw();
	}
	public void update() {
		
	}
	public void draw() {
		gr.setColor(Color.RED);
		gr.fillRect(0, HEIGHT-50,50, 50);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,0,0,this);
		
		if(Init) {
			Init = false;
			
		}
		
	}
	
	public void initArray(int howMany) {
		
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);//clears screen
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		int[] temp = randArray(howMany);
		Random rand = new Random();
		
		for(int i=0;i<howMany;i++) {
			float R = rand.nextFloat();
			float G = rand.nextFloat();
			float B = rand.nextFloat();
			Color randomColor = new Color(R,G,B);
			g.setColor(randomColor);
			
			int rectHeight= (int)((float)temp[i]/(float)100 * (float)HEIGHT);
			int Y = HEIGHT-(int)(((float)temp[i]/(float)100) * (float)HEIGHT);
			if(howMany <= 10) {
				int X =i*DefaultMaxInt;
				
				g.fillRect(X, Y, DefaultMaxInt, rectHeight);
			}
			else {
				int rectWidth = (int)((float)WIDTH / (float)howMany);
				//int leftOver = (int)(((float)WIDTH - ((float)rectWidth * (float)howMany)) / (float)howMany);
				int X = i*(rectWidth);
				if(i == howMany-1) {
					g.fillRect(X, Y, WIDTH-X, rectHeight);
					break;
				}
				g.fillRect(X, Y, rectWidth, rectHeight);
			}
		}
		g.dispose();
		repaint();
	}
	protected static void quickSort(int [] arr) {
		quickSort(arr,0,arr.length -1);
	}
	private static void quickSort(int [] arr, int begin, int end) {
		if (begin >= end)
			return;
		int wall = partition(arr,begin,end);
		quickSort(arr,begin,wall-1);
		quickSort(arr,wall,end);
	}
	private static int partition(int[] arr, int begin, int end) {
		
		int pivot = arr[end];
		
		while(begin < end) {
			if(arr[begin] > pivot && arr[end] <= pivot) {
				swap(arr,begin,end);
				begin++;
				end--;
			}
			if(arr[begin] <= pivot)
				begin++;
			if( arr[end] > pivot ) 
				end--; 
		}
		return begin;
	}
	
	private static void swap(int[] p, int a, int b) {
		int c = p[a];
		p[a] = p[b];
		p[b] = c;
	}

	protected static void iterativeBubbleSort(int arr[], int howMany) {
		for(int i = 0; i < howMany - 1; i ++) {
			for(int j = 0; j < howMany - 1 - i; j++ ) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	protected static void recursiveBubbleSort(int arr[], int howMany) {
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
	protected static void selectionSort(int[] arr, int howMany) {
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
	protected static void iterativeInsertionSort(int[] arr, int begin, int end) {
		int sortedIndex;
		for(int i = begin; i < end; i++) {
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
	protected static void recursiveInsertionSort(int[] arr, int howMany, int sortedIndex) {
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

	protected static void mergeSort(int[] arr, int begin, int end) {
		if(begin < end) {
			int middle = (begin + end)/ 2;
			mergeSort(arr,begin,middle);
			mergeSort(arr,middle+1,end);
			merge(arr,begin,middle,end);
		}
	}
	/*private static void merge(int[] arr, int begin, int middle, int end) {
		int half1 [] = new int[middle-begin+1]; //cloning the two "halves" of input array
		int half2 [] = new int[end-middle];
		
		int index1 = 0;
		for(int i = begin; i < middle+1; i++) { //copying first half and second half into the clones
			half1[index1] = arr[i];
			index1++;
		}
		int index2 = 0;
		for(int j = middle+1; j < end+1; j++) {
			half2[index2] = arr[j];
			index2++;
		}
		index1 = 0; //index for each item "transferred" from clone to sorted array
		index2 = 0;
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
*/
	private static void merge(int arr[], int l, int m, int r)
	{
	    // original array is broken in two parts
	    // left and right array
	    int len1 = m - l + 1;
	    int len2 = r - m;
	    int left[] = new int[len1];
	    int right[] = new int[len2];
	    for (int i = 0; i < len1; i++)
	        left[i] = arr[l + i];
	    for (int i = 0; i < len2; i++)
	        right[i] = arr[m + 1 + i];
	 
	    int i = 0;
	    int j = 0;
	    int k = l;
	 
	    // after comparing, we merge those two array
	    // in larger sub array
	    while (i < len1 && j < len2)
	    {
	        if (left[i] <= right[j])
	        {
	            arr[k] = left[i];
	            i++;
	        }
	        else
	        {
	            arr[k] = right[j];
	            j++;
	        }
	        k++;
	    }
	 
	    // copy remaining elements of left, if any
	    while (i < len1)
	    {
	        arr[k] = left[i];
	        k++;
	        i++;
	    }
	 
	    // copy remaining element of right, if any
	    while (j < len2)
	    {
	        arr[k] = right[j];
	        k++;
	        j++;
	    }
	}
	private static void timSort(int arr[], int n) {
		int RUN = 32;
		 for (int i = 0; i < n; i+=RUN) {
			 	int min = (i+31) > (n-1) ? (n-1) : (i+31);
		        iterativeInsertionSort(arr, i, min);
		 }
		    // start merging from size RUN (or 32). It will merge
		    // to form size 64, then 128, 256 and so on ....
		    for (int size = RUN; size < n; size = 2*size)
		    {
		        // pick starting point of left sub array. We
		        // are going to merge arr[left..left+size-1]
		        // and arr[left+size, left+2*size-1]
		        // After every merge, we increase left by 2*size
		        for (int left = 0; left < n; left += 2*size)
		        {
		            // find ending point of left sub array
		            // mid+1 is starting point of right sub array
		            int mid = left + size - 1;
		            int right = (left + (2*size) - 1) < (n-1) ? (left + (2*size) - 1) : (n-1);
		            // merge sub array arr[left.....mid] &
		            // arr[mid+1....right]
		            merge(arr, left, mid, right);
		        }
		    }
	}
	
	protected static void displayArray(int arr[], int howMany)
	{
		for(int i = 0;i<howMany;i++)
		{
			System.out.printf("%d\t", arr[i]);
			if( (i+1)%10 == 0 )
				System.out.println();
		}
		System.out.println();
	}
	protected static int[] randArray(int howMany)
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
