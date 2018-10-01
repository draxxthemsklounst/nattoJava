package algorithm;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;

public class gui extends JPanel implements ActionListener, FocusListener{
	
	private JFrame window;
	private JLabel textFieldLabel;
	private JTextField SizeArray;
	private JComboBox<String> comboBox;
	private JButton runButton;
	
	public gui() {
		window = new JFrame();
		window.setContentPane(this);
		window.setTitle("Natto");
		window.getContentPane().setPreferredSize(new Dimension(1280,720));
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setLayout(new BorderLayout());
		window.setLayout(new FlowLayout());
		
		draw draw = new draw();
		draw.setVisible(true);
		this.add(draw);
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		
	
		textFieldLabel = new JLabel("Array Size");
		this.add(textFieldLabel);
		
		SizeArray = new JTextField("Enter Array Size");
		SizeArray.addFocusListener(this);
		this.add(SizeArray);
		
		String[] comboBoxSelection = {"Iterative Bubble Sort","Recursive Bubble Sort","Selection Sort","Iterative Insertion Sort","Recursive Insertion Sort","Merge Sort","Quick Sort"};
		comboBox = new JComboBox<String>(comboBoxSelection);
		comboBox.setSelectedIndex(1);
		comboBox.addActionListener(this);
		this.add(comboBox);
		
		runButton = new JButton("Run");
		runButton.setActionCommand("run");
		this.add(runButton);
		
		GroupLayout layout = new GroupLayout(window);
		this.setLayout(layout);
		
		window.add(this);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
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
