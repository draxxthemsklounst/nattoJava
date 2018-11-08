package algorithm;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.PrintStream;
import java.util.Scanner;

public class frame extends JPanel implements ActionListener, FocusListener{
	private sortingforGUI sort;
	
	//private JFrame window;
	private sortVisual drawPanel;
	private JPanel toolbarPanel;
	private JPanel console;
	private JTextArea consoleText;
	private JScrollPane conscroll;
	private JLabel textFieldLabel;
	private JTextField SizeArray;
	private JComboBox<String> comboBox;
	private JComboBox<String> algoSelection;
	private JButton runButton;
	private final int MAXRECTANGLES = 1000;
	
	public frame() {
		init();
	}
	
	private void init() {
		drawPanel = new sortVisual(); //handles the rectangle graphics and sorting
		this.add(drawPanel);
		
		textFieldLabel = new JLabel("Array Size");
		this.add(textFieldLabel);
		textFieldLabel.addKeyListener(new KeyListener() {
			@Override
		    public void keyPressed(KeyEvent e){
		        
		    }

		    @Override
		    public void keyTyped(KeyEvent e) {
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		    	
				if(e.getKeyCode() == KeyEvent.KEY_RELEASED) {
					System.out.println("yeet");
					int arraySize = Integer.parseInt(SizeArray.getText());
					if(arraySize > 1000) {
						System.out.println("Enter a number smaller than 1,000 please.");
						return;
					}
					drawPanel.initRectPanel(arraySize);
					drawPanel.repaint();
				}
		    }
		});
		
		
		SizeArray = new JTextField("Enter Array Size");
		SizeArray.addFocusListener(this);
		this.add(SizeArray);
		
		String[] algoList = {"Search Algorithms","Sort Algorithms","Hash Table","Fibonacci"};
		algoSelection = new JComboBox<String>(algoList);
		algoSelection.setSelectedIndex(1);
		algoSelection.addActionListener(this);
		this.add(algoSelection);
		
		String[] comboBoxSelection = {"Iterative Bubble Sort","Recursive Bubble Sort","Selection Sort","Iterative Insertion Sort","Recursive Insertion Sort","Merge Sort","Quick Sort","Tim Sort"};
		comboBox = new JComboBox<String>(comboBoxSelection);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		this.add(comboBox);
		
		runButton = new JButton("Run");
		runButton.setActionCommand("run");
		this.add(runButton);
		runButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                try {
					runButtonClicked(evt);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            public void runButtonClicked(java.awt.event.MouseEvent evt) throws InterruptedException {
            	if(!drawPanel.rectInitialized()) {
            		System.out.println("Error: Rectangle Array not initialized");
            		return;
            	}
        		if( !StringUtils.isNumeric(SizeArray.getText()) || SizeArray.getText().isEmpty()) {
        			System.out.printf("Enter a valid array size (1 - %d)\n",MAXRECTANGLES);
        			return;
        		}
        		
        		switch(algoSelection.getSelectedIndex()) {
        		case 0:
        			break;
        		case 1: //must be on "sorting algorithms"
        			//int arraySize = Integer.parseInt(SizeArray.getText());
        			switch(comboBox.getSelectedIndex() ) {
        			case 0:
        				drawPanel.iterativeBubbleSort();
        				sortVisual.displayArray(drawPanel.getRectArray());
        				drawPanel.sortCompleteAnimation();
        				repaint();
        				break;
        			case 1: 
        				drawPanel.recursiveBubbleSort();
        				sortVisual.displayArray(drawPanel.getRectArray());
        				drawPanel.sortCompleteAnimation();
        				repaint();
        				break;
        			case 2:
        				drawPanel.selectionSort();
        				sortVisual.displayArray(drawPanel.getRectArray());
        				drawPanel.sortCompleteAnimation();
        				repaint();
        				break;
        			case 3:
        				drawPanel.iterativeInsertionSort();
        				sortVisual.displayArray(drawPanel.getRectArray());
        				drawPanel.sortCompleteAnimation();
        				repaint();
        				break;
        			case 4:
        				drawPanel.recursiveInsertionSort();
        				sortVisual.displayArray(drawPanel.getRectArray());
        				drawPanel.sortCompleteAnimation();
        				break;
        			case 5:
        				drawPanel.mergeSort();
        				sortVisual.displayArray(drawPanel.getRectArray());
        				drawPanel.sortCompleteAnimation();
        				break;
        			case 6:
        				drawPanel.quickSort();
        				sortVisual.displayArray(drawPanel.getRectArray());
        				drawPanel.sortCompleteAnimation();
        				break;
        			case 7:
        				drawPanel.timSort();
        				sortVisual.displayArray(drawPanel.getRectArray());
        				drawPanel.sortCompleteAnimation();
        				break;
        			case 8:
        				sortVisual.displayArray(drawPanel.getRectArray());
        				drawPanel.sortCompleteAnimation();
        				break;
        			default:
        				System.out.println("Please select a valid Sorting Algorithm. ");
        				break;
        			
        			}
        			break;
        		case 2:
        			break;
        		case 3:
        			break;
        		}
            }  
        });
		
		toolbarPanel = new JPanel();
		toolbarPanel.add(textFieldLabel);
		toolbarPanel.add(SizeArray);
		toolbarPanel.add(comboBox);
		toolbarPanel.add(runButton);
		
		console = new JPanel();
		consoleText = new JTextArea();
		consoleText.setEditable(false);
		PrintStream out = new PrintStream(new CustomOutputStream(consoleText));
		System.setOut(out);
		conscroll = new JScrollPane();
		consoleText.setColumns(20);
		consoleText.setRows(5);
		conscroll.setViewportView(consoleText);
		console.add(conscroll);
		
		//GroupLayout for the main graphic window
		GroupLayout drawPanelLayout = new GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
        	drawPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
        	drawPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        
        //console panel
        GroupLayout consoleLayout = new GroupLayout(console);
        console.setLayout(consoleLayout);
        consoleLayout.setHorizontalGroup(
            consoleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(consoleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(conscroll)
                .addContainerGap())
        );
        consoleLayout.setVerticalGroup(
            consoleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(consoleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(conscroll, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );        
		        
		//GroupLayout for the toolbarPanel
        GroupLayout toolbarLayout = new GroupLayout(toolbarPanel);
        toolbarPanel.setLayout(toolbarLayout);
        toolbarLayout.setHorizontalGroup(
        		toolbarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(runButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SizeArray, GroupLayout.Alignment.TRAILING)
            .addComponent(comboBox, GroupLayout.Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            
            .addComponent(textFieldLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(algoSelection, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        toolbarLayout.setVerticalGroup(
        		toolbarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, toolbarLayout.createSequentialGroup()
                .addComponent(textFieldLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(SizeArray, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(algoSelection, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
           
                .addContainerGap())
        );
        
        //adding the 3 JPanels to the JFrame
        GroupLayout layout = new GroupLayout(this);
       this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(drawPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toolbarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(console, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(toolbarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(drawPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(console, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(!algoSelection.getSelectedItem().equals("Sort Algorithms")) {
			comboBox.setVisible(false);
			repaint();
		}
		else {
			comboBox.setVisible(true);
			repaint();
		}
		if(StringUtils.isNumeric(SizeArray.getText())) {
			int arraySize = Integer.parseInt(SizeArray.getText());
			if(arraySize > MAXRECTANGLES) {
				System.out.printf("Enter a number smaller than %d please.\n",MAXRECTANGLES);
				return;
			}
			drawPanel.initRectPanel(arraySize);
			drawPanel.repaint();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(SizeArray.getText().trim().equals("Enter Array Size")) 
			SizeArray.setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(SizeArray.getText().trim().equals("")) 
			SizeArray.setText("Enter Array Size");
		if( StringUtils.isNumeric(SizeArray.getText()) && !SizeArray.getText().isEmpty()) {
			int arraySize = Integer.parseInt(SizeArray.getText());
			if(arraySize > MAXRECTANGLES) {
				System.out.println("Enter a number smaller than 1,000 please.");
				return;
			}
			drawPanel.initRectPanel(arraySize);
			drawPanel.repaint();
		}
	}

}
