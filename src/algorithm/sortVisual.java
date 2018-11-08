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
	private static final int DefaultMaxAmount = 10;
	private int DefaultWidth = WIDTH/DefaultMaxAmount;
	private boolean Init;
	private boolean rectInitFlag;
	private boolean sortComplete;
	private BufferedImage img;
	private Graphics2D gr;
	private rectangles[] rectOnScreen;
	private final Color SWITCHING_COLOR = Color.RED;
	private final Color FINISHED_COLOR = Color.GREEN;
	private final Color DEFAULT_COLOR = Color.WHITE;
	
	public sortVisual() {
		this.setSize(new Dimension(WIDTH,HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		Init = true;
		sortComplete = false;
		rectInitFlag = false;
		
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
	public boolean rectInitialized() {
		return rectInitFlag;
	}
	//creates an array of rect objects
	public rectangles[] rectArrayInit(int howMany) { 
		rectangles [] rectArray = new rectangles[howMany];
		int[] temp = randArray(howMany);
		
		sortVisual.displayArray(temp);
		
		for(int i=0;i<howMany;i++) {
			rectArray[i] = new rectangles();
			rectArray[i].setValue(temp[i]);
			rectArray[i].setHeight((int)((float)temp[i]/(float)100 * (float)HEIGHT));
			rectArray[i].setY(HEIGHT-(int)(((float)temp[i]/(float)100) * (float)HEIGHT));
			if(howMany <= 10) {
				rectArray[i].setX(i*DefaultWidth);
				rectArray[i].setWidth(DefaultWidth);
			}
			else {
				int rectWidth = (int) ( (float)WIDTH/(float)howMany );
				rectArray[i].setWidth(rectWidth);
				rectArray[i].setX(i*rectWidth);
			}
		}
		rectInitFlag = true;
		return rectArray;
	}
	//paints the panel with updated rectangle objects
	public void paintRect() {
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);//clears screen
		
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, WIDTH, HEIGHT);
		
		for(int i=0;i<rectOnScreen.length;i++) {
			g.setColor( rectOnScreen[i].getColor());
			g.fillRect(
					rectOnScreen[i].getX(), 
					rectOnScreen[i].getY(), 
					rectOnScreen[i].getWidth(), 
					rectOnScreen[i].getHeight());
			}
			
			g.dispose();
			this.paintImmediately(0, 0, WIDTH, HEIGHT);
	}
	
	
	public void sortCompleteAnimation() {
		Graphics2D g = (Graphics2D) img.getGraphics();
		
		for(int i=0;i<rectOnScreen.length;i++) {
			g.setColor(Color.green);
			g.fillRect(
					rectOnScreen[i].getX(), 
					rectOnScreen[i].getY(), 
					rectOnScreen[i].getWidth(), 
					rectOnScreen[i].getHeight());
			/*
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			this.paintImmediately(0, 0, WIDTH, HEIGHT);
			
			}
			g.dispose();
	}
	
	
	public void initRectPanel(int howMany) {
		rectOnScreen = rectArrayInit(howMany);//creates rectangles array
		paintRect();//paints with the given array
	}
	
	protected void quickSort() {
		quickSort(rectOnScreen,0,rectOnScreen.length-1);
	}
	private void quickSort(rectangles [] arr, int begin, int end) {
		if (begin >= end)
			return;
		int wall = partition(arr,begin,end);
		quickSort(arr,begin,wall-1);
		quickSort(arr,wall,end);
	}
	/*
	private int partition(rectangles[] arr, int begin, int end) {
		
		int pivot = arr[end].getValue();
		int i = begin - 1;
		
		while(begin < end-1) {
			if(arr[begin].getValue() > pivot && arr[end].getValue() <= pivot) {
				//swap(arr,begin,end);
				swapRect(begin,end);
				begin++;
				end--;
			}
			if(arr[begin].getValue() <= pivot)
				begin++;
			if( arr[end].getValue() > pivot ) 
				end--; 
		}
		return begin;
	}*/
	
	private int partition (rectangles arr[], int low, int high) { 
	    int pivot = arr[high].getValue();    // pivot 
	    int i = (low - 1);  // Index of smaller element 
	  
	    for (int j = low; j <= high- 1; j++) { 
	        // If current element is smaller than or 
	        // equal to pivot 
	        if (arr[j].getValue() <= pivot) { 
	            i++;    // increment index of smaller element 
	            swapRect(i,j); 
	        } 
	    } 
	   // swap(&arr[i + 1], &arr[high]); 
	    swapRect(i+1,high);
	    return (i + 1); 
	} 
	private static void swap(int[] p, int a, int b) {
		int c = p[a];
		p[a] = p[b];
		p[b] = c;
	}

	private void swapRect(int i, int j) {
		rectOnScreen[i].setColor(Color.RED);
		paintRect();
		rectOnScreen[j].setColor(Color.GREEN);
		rectangles.swap(rectOnScreen,i,j);
		//Thread.sleep(1);
		paintRect();
		rectOnScreen[i].setColor(Color.white);
		rectOnScreen[j].setColor(Color.white);
		paintRect();
	}
	protected void iterativeBubbleSort() throws InterruptedException {
		
		for(int i = 0; i < rectOnScreen.length - 1; i ++) {
			for(int j = 0; j < rectOnScreen.length - 1 - i; j++ ) {
				if(rectOnScreen[j].getValue() > rectOnScreen[j+1].getValue()) {
					swapRect(j,j+1);
				}
			}
		}
		
	}
	protected void recursiveBubbleSort() {
		recursiveBubbleSort(rectOnScreen,rectOnScreen.length);
	}
	protected void recursiveBubbleSort(rectangles[] arr, int howMany) {
		if(howMany == 1) {
			
			return;
		}
		for(int i = 0; i < howMany-1; i++) {
			if(arr[i].getValue() > arr[i+1].getValue()) {
				swapRect(i,i+1);
			}
		}
		recursiveBubbleSort(arr,howMany-1);
	}
	private void selectionSort(rectangles [] r,int left,int right) {
		for(int i = left ; i < right; i++) {
			int smallestIndex = i;
			for(int j = i+1; j<right; j++) {
				if(rectOnScreen[j].getValue()<=rectOnScreen[smallestIndex].getValue()) {
					smallestIndex = j;
				}
			}
			swapRect(i,smallestIndex);
		}
	}
	protected void selectionSort() {
		for(int i = 0; i < rectOnScreen.length - 1; i++) {
			int smallestIndex = i;
			for(int j = i+1; j<rectOnScreen.length; j++) {
				if(rectOnScreen[j].getValue()<=rectOnScreen[smallestIndex].getValue()) {
					smallestIndex = j;
				}
			}
			
			swapRect(i,smallestIndex);
		}
		
	}
	protected void iterativeInsertionSort() {
		int sortedIndex;
		for(int i = 0; i < rectOnScreen.length; i++) {
			sortedIndex = i;
			for(int j = 0; j<sortedIndex; j++) {
				if(rectOnScreen[sortedIndex].getValue() <= rectOnScreen[j].getValue()) {
					swapRect(sortedIndex,j);
				}
			}
		}
		
	}
	protected void recursiveInsertionSort() {
		recursiveInsertionSort(rectOnScreen,0);
		
	}
	protected void recursiveInsertionSort(rectangles[] arr, int sortedIndex) {
		if(sortedIndex == rectOnScreen.length) {
			return;
		}
		for(int j = 0; j<sortedIndex; j++) {
			if(arr[sortedIndex].getValue() <= arr[j].getValue()) {
				swapRect(sortedIndex,j);
			}
		}
		sortedIndex++;
		recursiveInsertionSort(arr, sortedIndex);
	}

	protected void mergeSort() {
		mergeSort(rectOnScreen,0,rectOnScreen.length - 1);
		
	}
	protected void mergeSort(rectangles[] arr, int begin, int end) {
		if(begin < end) {
			int middle = (begin + end)/ 2;
			mergeSort(arr,begin,middle);
			mergeSort(arr,middle+1,end);
			merge(arr,begin,middle,end);
		}
	}
	
	private void merge(rectangles [] arr, int begin, int middle, int end) {
		rectangles half1 [] = new rectangles[middle-begin+1]; //cloning the two "halves" of input array
		rectangles half2 [] = new rectangles[end-middle];
		
		int index1 = 0;
		for(int i = begin; i < middle; i++) { //copying first half and second half into the clones
			//half1[index1] = arr[i];
			half1[index1] = new rectangles();
	    	rectangles.swapRectComponent(half1, arr, index1, i);
			index1++;
		}
		int index2 = 0;
		for(int j = begin+middle+1; j < end+1; j++) {
			//half2[index2] = arr[j];
			half2[index2] = new rectangles();
	    	rectangles.swapRectComponent(half2, arr, index2, j);
			index2++;
		}
		index1 = 0; //index for each item "transferred" from clone to sorted array
		index2 = 0;
		for(int j = begin; j< end+1; j++) {
			
			if(index1 < half1.length && index2 >= half2.length) {
				//arr[j] = half1[index1];
				rectangles.swapRectComponent(half1, arr, index1, j);
				index1++;
			}
			else if(index1 >= half1.length && index2 < half2.length) {
				//arr[j] = half2[index2];
				rectangles.swapRectComponent(half2, arr, index2, j);
				index2++;
			}
			
			else if(half1[index1].getValue() <= half2[index2].getValue() && index1 < half1.length && index2 < half2.length) {
				//arr[j] = half1[index1];
				rectangles.swapRectComponent(half1, arr, index1, j);
				index1++;
				
			}
			else if(half1[index1].getValue() > half2[index2].getValue() && index1 < half1.length && index2 < half2.length) {
				//arr[j] = half2[index2];
				rectangles.swapRectComponent(half2, arr, index2, j);
				
				index2++;
			}
			paintRect();
			
		}
	}

	
	private void timMerge(rectangles arr[], int l, int m, int r)
	{
	    // original array is broken in two parts
	    // left and right array
	    int len1 = m - l + 1;
	    int len2 = r - m;
	    rectangles[] left = new rectangles[len1];
	    rectangles[] right = new rectangles[len2];
	    for (int i = 0; i < len1; i++) {
	        //left[i] = arr[l + i].getValue();
	    	left[i] = new rectangles();
	    	rectangles.swapRectComponent(left, arr, i, l+i);
	    }
	    for (int i = 0; i < len2; i++) {
	        //right[i] = arr[m + 1 + i].getValue();
	    	right[i] = new rectangles();
	        rectangles.swapRectComponent(right, arr, i, m+l+i);
	    }
	    int i = 0;
	    int j = 0;
	    int k = l;
	 
	    // after comparing, we merge those two array
	    // in larger sub array
	    while (i < len1 && j < len2) {
	        if (left[i].getValue() <= right[j].getValue()) {
	            rectangles.swapRectComponent(arr, left, k, i);
	            paintRect();
	            i++;
	        }
	        else {
	            rectangles.swapRectComponent(arr, right, k, j);
	            paintRect();
	            j++;
	        }
	        k++;
	    }
	 
	    // copy remaining elements of left, if any
	    while (i < len1) {
	    	rectangles.swapRectComponent(arr, left, k, i);
	    	paintRect();
	        k++;
	        i++;
	    }
	 
	    // copy remaining element of right, if any
	    while (j < len2) {
	    	rectangles.swapRectComponent(arr, right, k, j);
	    	paintRect();
	        k++;
	        j++;
	    }
	}
	public void timSort() {
		timSort(rectOnScreen);
	}
	private void timSort(rectangles arr[]) {
		int RUN = 32;
		 for (int i = 0; i < arr.length; i+=RUN) {
			 	int min = (i+31) > (arr.length-1) ? (arr.length-1) : (i+31);
		        selectionSort(arr, i, min);
		 }
		    // start merging from size RUN (or 32). It will merge
		    // to form size 64, then 128, 256 and so on ....
		    for (int size = RUN; size < arr.length; size *= 2)
		    {
		        // pick starting point of left sub array. We
		        // are going to merge arr[left..left+size-1]
		        // and arr[left+size, left+2*size-1]
		        // After every merge, we increase left by 2*size
		        for (int left = 0; left < arr.length; left += 2*size)
		        {
		            // find ending point of left sub array
		            // mid+1 is starting point of right sub array
		            int mid = left + size - 1;
		            int right = (left + 2*size - 1) < (arr.length - 1) ? (left + 2*size - 1) : (arr.length - 1);
		            // merge sub array arr[left.....mid] &
		            // arr[mid+1....right]
		            
		            timMerge(arr, left, mid, right);
		        }
		    }
	}
	
	protected static void displayArray(int arr[])
	{
		for(int i = 0;i<arr.length;i++)
		{
			System.out.printf("%d\t", arr[i]);
			if( (i+1)%10 == 0 )
				System.out.println();
		}
		System.out.println();
	}
	protected static void displayArray(rectangles arr[])
	{
		for(int i = 0;i<arr.length;i++)
		{
			System.out.printf("%d\t", arr[i].getValue());
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
	public rectangles[] getRectArray() {
		return rectOnScreen;
	}
	
}
