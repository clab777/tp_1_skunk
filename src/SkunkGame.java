import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class SkunkGame {

	private JFrame frame;
	private JTextField textField;
	private String[] imagesList = {"./images/skunk.png", "./images/two.png", "./images/three.png", "./images/four.png", 
			"./images/five.png", "./images/six.png"};
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkunkGame window = new SkunkGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SkunkGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(117, 45, 120, 125);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(311, 45, 120, 125);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("Roll");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RolledDie die1 = new RolledDie();
				RolledDie die2 = new RolledDie();
				
				int num1 = die1.roll();
				int num2 = die2.roll();
				
				/* Die 1 Image */
				ImageIcon imc1 = new ImageIcon(imagesList[num1-1]);
				Image image1 = imc1.getImage();
				Image newimage1 = image1.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH) ;
				imc1 = new ImageIcon(newimage1);
				lblNewLabel.setIcon(new ImageIcon(newimage1));
				
				/* Die 2 image */
				ImageIcon imc2 = new ImageIcon(imagesList[num2-1]);
				Image image2 = imc2.getImage();
				Image newimage2 = image2.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH) ;
				imc2 = new ImageIcon(newimage2);
				label.setIcon(new ImageIcon(newimage2));
			}
		});
		btnNewButton.setBounds(214, 253, 96, 79);
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		
		
		
		
		
		
	}
	
		
}
