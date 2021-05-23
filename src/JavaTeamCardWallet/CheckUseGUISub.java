import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class CheckUseGUISub {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckUseGUISub window = new CheckUseGUISub();
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
	public CheckUseGUISub(String name, String cardNum, String balance, String cardCom, String MII) {
		initialize(name, cardNum, balance, cardCom, MII);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String cardNum, String balance, String cardCom, String MII) {
		frame = new JFrame();
		
		JLabel lblUserName = new JLabel("User Name : " + name);
		lblUserName.setBounds(291, 304, 218, 37);
		frame.getContentPane().add(lblUserName);
		
		JLabel CardNumLabel = new JLabel("Card Number : " + cardNum);
		CardNumLabel.setBounds(291, 271, 333, 23);
		frame.getContentPane().add(CardNumLabel);
		
		JLabel lblBalance = new JLabel("Balance : " + balance);
		lblBalance.setBounds(291, 348, 218, 37);
		frame.getContentPane().add(lblBalance);
		
		JLabel lblCardCom = new JLabel("Card Company : " + cardCom);
		lblCardCom.setBounds(521, 304, 333, 37);
		frame.getContentPane().add(lblCardCom);
		
		JLabel lblMII = new JLabel("MII : " + MII);
		lblMII.setBounds(521, 348, 333, 37);
		frame.getContentPane().add(lblMII);
		
		JLabel cardImageLabel = new JLabel("");
		cardImageLabel.setBounds(324, 41, 300, 194);
		frame.getContentPane().add(cardImageLabel);
		ImageIcon img = new ImageIcon(this.getClass().getResource("image/credit-card-image.png"));
		cardImageLabel.setIcon(img);
		
		JButton addButton = new JButton("PURCHASE");
		addButton.setBounds(763, 521, 113, 23);
		frame.getContentPane().add(addButton);
		
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Name :");
		lblNewLabel.setBounds(291, 472, 103, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPurchase = new JLabel("PURCHASE OPTION");
		lblPurchase.setBounds(291, 431, 136, 15);
		frame.getContentPane().add(lblPurchase);
		
		textField = new JTextField();
		textField.setBounds(393, 469, 96, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPriceper = new JLabel("Price (per 1) :");
		lblPriceper.setBounds(521, 472, 103, 15);
		frame.getContentPane().add(lblPriceper);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(617, 469, 96, 21);
		frame.getContentPane().add(textField_1);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(291, 525, 103, 15);
		frame.getContentPane().add(lblAmount);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(393, 522, 96, 21);
		frame.getContentPane().add(textField_2);
		

		frame.setBounds(100, 100, 1000, 630);
		frame.setTitle("Add Check Card");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(1000, 630));
		frame.setSize(1000, 630);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
