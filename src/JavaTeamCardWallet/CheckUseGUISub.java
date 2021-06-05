package JavaTeamCardWallet;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class CheckUseGUISub {

	private JFrame frame;
	private JTextField productNameField;
	private JTextField priceField;
	private JTextField amountField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckUseGUISub window = new CheckUseGUISub(null, null, null, null, null, null);
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
	public CheckUseGUISub(String name, String cardNum, String balance, String cardCom, String MII, String expiredDate) {
		initialize(name, cardNum, balance, cardCom, MII, expiredDate);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String cardNum, String balance, String cardCom, String MII, String expiredDate) {
		frame = new JFrame();
		
		JLabel lblUserName = new JLabel("User Name : " + name);
		lblUserName.setBounds(291, 287, 218, 37);
		frame.getContentPane().add(lblUserName);
		
		JLabel CardNumLabel = new JLabel("Card Number : " + cardNum);
		CardNumLabel.setBounds(291, 257, 333, 23);
		frame.getContentPane().add(CardNumLabel);
		
		JLabel lblBalance = new JLabel("Balance : " + balance);
		lblBalance.setBounds(291, 323, 218, 37);
		frame.getContentPane().add(lblBalance);
		
		JLabel lblCardCom = new JLabel("Card Company : " + cardCom);
		lblCardCom.setBounds(521, 287, 333, 37);
		frame.getContentPane().add(lblCardCom);
		
		JLabel lblMII = new JLabel("MII : " + MII);
		lblMII.setBounds(521, 323, 333, 37);
		frame.getContentPane().add(lblMII);
		
		JLabel lblexpiredDate = new JLabel("Expired Date : " + expiredDate);
		lblexpiredDate.setBounds(291, 370, 157, 15);
		frame.getContentPane().add(lblexpiredDate);
		
		
		JLabel cardImageLabel = new JLabel("");
		cardImageLabel.setBounds(324, 41, 300, 194);
		frame.getContentPane().add(cardImageLabel);
		ImageIcon img = new ImageIcon(this.getClass().getResource("image/credit-card-image.png"));
		cardImageLabel.setIcon(img);
		
		JButton purchaseButton = new JButton("PURCHASE");
		purchaseButton.setBounds(763, 521, 113, 23);
		frame.getContentPane().add(purchaseButton);
		

		
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Name :");
		lblNewLabel.setBounds(291, 472, 103, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPurchase = new JLabel("PURCHASE OPTION");
		lblPurchase.setBounds(291, 431, 136, 15);
		frame.getContentPane().add(lblPurchase);
		
		productNameField = new JTextField();
		productNameField.setBounds(393, 469, 96, 21);
		frame.getContentPane().add(productNameField);
		productNameField.setColumns(10);
		
		JLabel lblPriceper = new JLabel("Price (per 1) :");
		lblPriceper.setBounds(521, 472, 103, 15);
		frame.getContentPane().add(lblPriceper);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(617, 469, 96, 21);
		frame.getContentPane().add(priceField);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(291, 525, 103, 15);
		frame.getContentPane().add(lblAmount);
		
		amountField = new JTextField();
		amountField.setColumns(10);
		amountField.setBounds(393, 522, 96, 21);
		frame.getContentPane().add(amountField);
		
		String outputFile = "Check_Card.txt";
		String accountBookFile = "Account_Book.txt";
		
		purchaseButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String newBalance = Double.toString(Double.parseDouble(balance) - Double.parseDouble(priceField.getText()) * Double.parseDouble(amountField.getText()));

				System.out.println(newBalance);
				CheckCard newCard = new CheckCard();
				newCard.setUserName(name);
				newCard.setBalance(newBalance);
				newCard.InputCardNum(cardNum);
				newCard.setExpireDate(expiredDate);
				
				try { //텍스트 파일에 데이터 추가
					BufferedWriter Writer = new BufferedWriter(new FileWriter(outputFile, true));
					BufferedWriter Writer2 = new BufferedWriter(new FileWriter(accountBookFile, true));
					
					if(Double.parseDouble(priceField.getText()) * Double.parseDouble(amountField.getText()) > Double.parseDouble(balance)) {
						JOptionPane.showMessageDialog(null, "잔액 초과", "잔액 초과",JOptionPane.ERROR_MESSAGE);
						System.out.println("잔액 초과");
						Writer.append(name+",");
						Writer.append(cardNum+",");
						Writer.append(balance+",");
						Writer.append(cardCom+",");
						Writer.append(MII+",");
						Writer.append(expiredDate+"\n");
						
						Writer.close();
						frame.setVisible(false);
						new CheckUseGUISub(name, cardNum, balance, cardCom, MII, expiredDate);
					}
					
					else {
						System.out.println(newCard.getCardNumber());
						Writer.append(newCard.getUserName()+",");
						Writer.append(newCard.getCardNumber()+",");
						Writer.append(newCard.getBalance()+",");
						Writer.append(newCard.getCardCompany()+",");
						Writer.append(newCard.getMII()+",");
						Writer.append(newCard.getExpireDate()+"\n");
						
						Writer2.append(cardNum + ",");
						Writer2.append(productNameField.getText() + ",");
						Writer2.append(amountField.getText() + ",");
						Writer2.append(Double.parseDouble(priceField.getText()) * Double.parseDouble(amountField.getText()) + ",");
						Writer2.append(new Date().toString()+"\n");

						Writer.close();
						frame.setVisible(false);
						new CheckUseGUISub(name, cardNum, newBalance, cardCom, MII, expiredDate);
					}
					Writer2.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		

		frame.setBounds(100, 100, 1000, 630);
		frame.setTitle("Use Check Card");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(1000, 630));
		frame.setSize(1000, 630);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
