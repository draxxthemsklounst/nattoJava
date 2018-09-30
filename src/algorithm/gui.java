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

public class gui extends JPanel {
	
	private JFrame window;
	
	
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
		window.add(draw);
		
		optionPane fred = new optionPane();
		window.add(fred);
		
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}

	
	
}
