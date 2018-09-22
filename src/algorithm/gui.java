package algorithm;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gui extends JFrame{
	private JButton searchAlgorithmsButton;
	private JButton sortingAlgorithmsButton;
	private JButton hashTableButton;
	private JButton FibonacciButton;
	//private JLabel backgroundPicture;
	
	public gui() throws IOException {
		super("Natto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1280,720);
		
		
		setLayout(new BorderLayout() );
		//setLayout(new AbsoluteLayout() );
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Mi Ra\\Downloads\\thanoscar.jpg")));
		ImageIcon sunglassesIcon = new ImageIcon("C:\\Users\\Mi Ra\\Downloads\\yeet.png");
		ImageIcon cryingEmoji = new ImageIcon("C:\\Users\\Mi Ra\\Downloads\\cryingemoji.png");
		ImageIcon um = new ImageIcon("C:\\Users\\Mi Ra\\Downloads\\um.png");

		//BufferedImage background = ImageIO.read(new File("C:\\Users\\Mi Ra\\Downloads\\thanoscar.jpg"));
		setLayout(new FlowLayout() );
		searchAlgorithmsButton = new JButton("Search Algorithms",sunglassesIcon);
		sortingAlgorithmsButton = new JButton("Sorting Algorithms", um);
		hashTableButton = new JButton("Hash Table",cryingEmoji);
		FibonacciButton = new JButton("Nth Fibonacci Calculator");
		//backgroundPicture = new JLabel(new ImageIcon(background));
		
		//add(backgroundPicture);
		add(searchAlgorithmsButton);
		add(sortingAlgorithmsButton);
		add(hashTableButton);
		add(FibonacciButton);
		
		 setSize(1279,719);
		 setSize(1280,720);
		 
		 
	}
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = gui.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
}
