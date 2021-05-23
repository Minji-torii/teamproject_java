import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;

public class CreditAddGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the apable() {
			public void run() {
				try {
					AddGUI window = new AddGUI();
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
	public CreditAddGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		

		
		JLabel lblNewLabel_2 = new JLabel("카드번호를 입력 하면 MII와 카드 회사는 자동으로 등록됩니다");
		lblNewLabel_2.setBounds(291, 508, 365, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(291, 392, 97, 37);
		frame.getContentPane().add(lblUserName);
		
		JLabel CardNumLabel = new JLabel("Card Number :");
		CardNumLabel.setBounds(291, 347, 91, 23);
		frame.getContentPane().add(CardNumLabel);
		
		JLabel lblExpireDate = new JLabel("Expire Date (Year / Month) :");
		lblExpireDate.setBounds(291, 448, 173, 37);
		frame.getContentPane().add(lblExpireDate);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(521, 459, 17, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton checkCardRadioButton = new JRadioButton("Check card");
		checkCardRadioButton.setBounds(324, 37, 113, 23);
		frame.getContentPane().add(checkCardRadioButton);
		
		checkCardRadioButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new CheckAddGUI();
			}
		});
		
		JRadioButton creditCardRadioButton = new JRadioButton("Credit card");
		creditCardRadioButton.setBounds(561, 37, 113, 23);
		frame.getContentPane().add(creditCardRadioButton);
		creditCardRadioButton.setSelected(true);
		
		JTextField cardNumField = new JTextField();
		cardNumField.setBounds(385, 347, 239, 21);
		frame.getContentPane().add(cardNumField);
		cardNumField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(385, 400, 239, 21);
		frame.getContentPane().add(textField_1);
		
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(479, 456, 30, 22);
		frame.getContentPane().add(spinner);

		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(542, 456, 30, 22);
		frame.getContentPane().add(spinner_1);
		
		JButton addButton = new JButton("ADD");
		addButton.setBounds(765, 504, 91, 23);
		frame.getContentPane().add(addButton);
		
		addButton.addActionListener(null);
		
		JLabel cardImageLabel = new JLabel("");
		cardImageLabel.setBounds(324, 103, 300, 194);
		frame.getContentPane().add(cardImageLabel);
		ImageIcon img = new ImageIcon(this.getClass().getResource("image/credit-card-image.png"));
		cardImageLabel.setIcon(img);
		
		frame.getContentPane().setLayout(null);

		
		frame.setBounds(100, 100, 1000, 630);
		frame.setTitle("Add Credit Card");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(1000, 630));
		frame.setSize(1000, 630);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}
}
