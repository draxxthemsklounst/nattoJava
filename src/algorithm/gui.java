package algorithm;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
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

public class gui extends JPanel implements ActionListener, FocusListener{
	private JLabel textFieldLabel;
	private JFrame window;
	private JTextField SizeArray;
	private JComboBox<String> comboBox;
	private JButton runButton;
	
	public gui() {
		window = new JFrame();
		window.setContentPane(this);
		window.setTitle("Natto");
		window.getContentPane().setPreferredSize(new Dimension(800,600));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());
		
		Canvas canvas = new Canvas();
		canvas.setSize(800, 550);
		canvas.setBackground(Color.gray);
		canvas.setVisible(true);
		window.add(canvas);
		
		textFieldLabel = new JLabel("Array Size");
		window.add(textFieldLabel);
		
		SizeArray = new JTextField("Enter Array Size");
		SizeArray.addFocusListener(this);
		window.add(SizeArray);
		
		String[] comboBoxSelection = {"Iterative Bubble Sort","Recursive Bubble Sort","Selection Sort","Iterative Insertion Sort","Recursive Insertion Sort","Merge Sort","Quick Sort"};
		comboBox = new JComboBox<String>(comboBoxSelection);
		comboBox.setSelectedIndex(1);
		comboBox.addActionListener(this);
		window.add(comboBox);
		
		runButton = new JButton("Run");
		window.add(runButton);
		
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == comboBox) {
			JComboBox<String> cb = (JComboBox<String>)e.getSource();
			String msg = (String)cb.getSelectedItem();
			switch (msg) {
			case "Iterative Bubble Sort": 
				break;
			case "Recursive Bubble Sort":
				break;
			case "Selection Sort":
				break;
			case "Iterative Insertion Sort":
				break;
			case "Recursive Insertion Sort":
				break;
			case "Merge Sort":
				break;
			case "Quick Sort":
				break;
			default: 
				break;
			}
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
