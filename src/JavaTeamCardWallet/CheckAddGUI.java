package JavaTeamCardWallet;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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

public class CheckAddGUI {

	private JFrame frame;

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
	public CheckAddGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		

		
		JLabel lblNewLabel_2 = new JLabel("카드번호를 입력 하면 MII와 카드 회사는 자동으로 등록됩니다");
		lblNewLabel_2.setBounds(291, 554, 365, 15);
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
		
		JLabel lblBalance = new JLabel("Balance :");
		lblBalance.setBounds(291, 495, 97, 37);
		frame.getContentPane().add(lblBalance);
		
		JLabel lblWon = new JLabel("WON");
		lblWon.setBounds(636, 497, 97, 37);
		frame.getContentPane().add(lblWon);
		
		JRadioButton checkCardRadioButton = new JRadioButton("Check card");
		checkCardRadioButton.setBounds(324, 37, 113, 23);
		frame.getContentPane().add(checkCardRadioButton);
		checkCardRadioButton.setSelected(true);
		
		JRadioButton creditCardRadioButton = new JRadioButton("Credit card");
		creditCardRadioButton.setBounds(561, 37, 113, 23);
		frame.getContentPane().add(creditCardRadioButton);
		
		creditCardRadioButton.addActionListener(new ActionListener() { //credit card 선택하기
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new CreditAddGUI();
			}
		});
		
		JTextField cardNumField = new JTextField();
		cardNumField.setBounds(385, 347, 239, 21);
		frame.getContentPane().add(cardNumField);
		cardNumField.setColumns(10);
		
		JTextField userNameField = new JTextField();
		userNameField.setColumns(10);
		userNameField.setBounds(385, 400, 239, 21);
		frame.getContentPane().add(userNameField);
		
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(479, 456, 30, 22);
		frame.getContentPane().add(spinner);

		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(542, 456, 30, 22);
		frame.getContentPane().add(spinner_1);
		
		JLabel cardImageLabel = new JLabel("");
		cardImageLabel.setBounds(324, 103, 300, 194);
		frame.getContentPane().add(cardImageLabel);
		ImageIcon img = new ImageIcon(this.getClass().getResource("image/credit-card-image.png"));
		cardImageLabel.setIcon(img);

		
		JTextField balanceField = new JTextField();
		balanceField.setColumns(10);
		balanceField.setBounds(385, 505, 239, 21);
		frame.getContentPane().add(balanceField);
		
		JButton addButton = new JButton("ADD");
		addButton.setBounds(765, 504, 91, 23);
		frame.getContentPane().add(addButton);
		
		String outputFile = "Check_Card.txt";
		
		//PrintWriter outputStream = null;

		
		addButton.addActionListener(new ActionListener() { //add 버튼 눌렀을 때

			public void actionPerformed(ActionEvent e) {
				CheckCard newCard = new CheckCard();
				newCard.setUserName(userNameField.getText());
				newCard.setBalance(balanceField.getText());
				newCard.InputCardNum(cardNumField.getText());
				newCard.setExpireDate(spinner.getValue().toString() + "/" + spinner_1.getValue().toString());
				
				try { //텍스트 파일에 데이터 추가
					BufferedWriter Writer = new BufferedWriter(new FileWriter(outputFile, true));
					System.out.println(newCard.getCardNumber());
					Writer.append(newCard.getUserName()+",");
					Writer.append(newCard.getCardNumber()+",");
					Writer.append(newCard.getBalance()+",");
					Writer.append(newCard.getCardCompany()+",");
					Writer.append(newCard.getMII()+",");
					Writer.append(newCard.getExpireDate()+"\n");

					Writer.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		});
		
		
		frame.getContentPane().setLayout(null);
		
		JButton goBackBtn = new JButton("Back");
		goBackBtn.setBounds(0, 0, 85, 58);
		frame.getContentPane().add(goBackBtn);
		goBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new MainMenu();
			}

		});

		
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
