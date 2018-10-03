package algorithm;

import java.awt.BorderLayout;
import java.awt.Color;

import org.apache.commons.lang3.StringUtils;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.*;

public class frame extends JPanel implements ActionListener, FocusListener{
	private sortingforGUI sort;
	
	//private JFrame window;
	private JPanel drawPanel;
	private JPanel toolbarPanel;
	private JPanel console;
	private JTextArea consoleText;
	private JScrollPane conscroll;
	private JLabel textFieldLabel;
	private JTextField SizeArray;
	private JComboBox<String> comboBox;
	private JComboBox<String> algoSelection;
	private JButton runButton;
	
	
	
	public frame() {
		init();
	}
	
	private void init() {
		sort = new sortingforGUI();
		
		
		
		
		drawPanel = new sortVisual();
		this.add(drawPanel);
		
		//this.add(drawPanel);
		
		textFieldLabel = new JLabel("Array Size");
		this.add(textFieldLabel);
		
		SizeArray = new JTextField("Enter Array Size");
		SizeArray.addFocusListener(this);
		this.add(SizeArray);
		
		String[] algoList = {"Search Algorithms","Sort Algorithms","Hash Table","Fibonacci"};
		algoSelection = new JComboBox<String>(algoList);
		algoSelection.setSelectedIndex(1);
		algoSelection.addActionListener(this);
		this.add(algoSelection);
		
		String[] comboBoxSelection = {"Iterative Bubble Sort","Recursive Bubble Sort","Selection Sort","Iterative Insertion Sort","Recursive Insertion Sort","Merge Sort","Quick Sort"};
		comboBox = new JComboBox<String>(comboBoxSelection);
		comboBox.setSelectedIndex(1);
		comboBox.addActionListener(this);
		this.add(comboBox);
		
		runButton = new JButton("Run");
		runButton.setActionCommand("run");
		this.add(runButton);
		runButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                runButtonClicked(evt);
            }
        });
		
		toolbarPanel = new JPanel();
		toolbarPanel.add(textFieldLabel);
		toolbarPanel.add(SizeArray);
		toolbarPanel.add(comboBox);
		toolbarPanel.add(runButton);
		
		console = new JPanel();
		consoleText = new JTextArea();
		PrintStream out = new PrintStream(new CustomOutputStream(consoleText));
		
		System.setOut(out);
		//System.setOut(printStream);
		//System.setErr(printStream);
		
		conscroll = new JScrollPane();
		consoleText.setColumns(20);
		consoleText.setRows(5);
		conscroll.setViewportView(consoleText);
		console.add(conscroll);
		
		//GroupLayout for the main graphic window
		GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
        	drawPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
        	drawPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, drawPanel.getHeight(), Short.MAX_VALUE)
        );
        
        //console panel
        javax.swing.GroupLayout consoleLayout = new javax.swing.GroupLayout(console);
        console.setLayout(consoleLayout);
        consoleLayout.setHorizontalGroup(
            consoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consoleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(conscroll)
                .addContainerGap())
        );
        consoleLayout.setVerticalGroup(
            consoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consoleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(conscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );        
		        
		//GroupLayout for the toolbarPanel
        GroupLayout toolbarLayout = new javax.swing.GroupLayout(toolbarPanel);
        toolbarPanel.setLayout(toolbarLayout);
        toolbarLayout.setHorizontalGroup(
        		toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(runButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SizeArray, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(comboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            
            .addComponent(textFieldLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(algoSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        toolbarLayout.setVerticalGroup(
        		toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolbarLayout.createSequentialGroup()
                .addComponent(textFieldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(SizeArray, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(algoSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
           
                .addContainerGap())
        );
        
        //adding the 3 JPanels to the JFrame
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(drawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(console, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(drawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(console, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
		
		
		
	}
	private void runButtonClicked(java.awt.event.MouseEvent evt) {                                             
		if( !StringUtils.isNumeric(SizeArray.getText()) || SizeArray.getText().isEmpty()) {
			System.out.println("Enter an Array Size.");
			return;
		}
		if(StringUtils.isNumeric(SizeArray.getText())){
			System.out.println("Hello There");
			int arraySize = Integer.parseInt(SizeArray.getText());
			sort.iterativeBubbleSort(sort.randArray(arraySize), arraySize);
			switch(algoSelection.getSelectedIndex() ) {
			case 1: 
				
				break;
			
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			}
		}
    }  
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if("run".equals(e.getActionCommand())) {
			
			textFieldLabel.getText();
			comboBox.getSelectedItem();
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
	}
}
