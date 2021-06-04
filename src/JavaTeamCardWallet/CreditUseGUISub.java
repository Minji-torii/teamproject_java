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

public class CreditUseGUISub {

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
					CreditUseGUISub window = new CreditUseGUISub(null, null, null, null, null, null, null, null);
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
	public CreditUseGUISub(String name, String cardNum, String creditScore, String limit, String cardCom, String MII, String expiredDate, String totalUse) {
		initialize(name, cardNum, creditScore, limit, cardCom, MII, expiredDate, totalUse);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String cardNum, String creditScore, String limit, String cardCom, String MII, String expiredDate, String totalUse) {
		frame = new JFrame();
		
		JLabel lblUserName = new JLabel("User Name : " + name);
		lblUserName.setBounds(291, 287, 218, 37);
		frame.getContentPane().add(lblUserName);
		
		JLabel CardNumLabel = new JLabel("Card Number : " + cardNum);
		CardNumLabel.setBounds(291, 257, 333, 23);
		frame.getContentPane().add(CardNumLabel);
		
		JLabel lblLimit = new JLabel("Limit : " + limit);
		lblLimit.setBounds(291, 323, 218, 37);
		frame.getContentPane().add(lblLimit);
		
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
		
		JLabel lblTotalUse = new JLabel("Total Use : " + totalUse);
		lblTotalUse.setBounds(520, 358, 218, 37);
		frame.getContentPane().add(lblTotalUse);
		
		String outputFile = "Credit_Card.txt";
		String accountBookFile = "Account_Book.txt";
		
		purchaseButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				CreditCard newCard = new CreditCard();
				newCard.setUserName(name);
				newCard.InputCardNum(cardNum);
				newCard.setExpireDate(expiredDate);
				newCard.setCreditScore(Double.parseDouble(creditScore));
				newCard.setLimit(Double.parseDouble(limit));
				newCard.setTotalUse(Double.parseDouble(totalUse));
				
				try { //텍스트 파일에 데이터 추가
					BufferedWriter Writer = new BufferedWriter(new FileWriter(outputFile, true));
					BufferedWriter Writer2 = new BufferedWriter(new FileWriter(accountBookFile, true));
					
					if(Double.parseDouble(priceField.getText()) * Double.parseDouble(amountField.getText()) + Double.parseDouble(totalUse) > Double.parseDouble(limit)) { //한도초과
						JOptionPane.showMessageDialog(null, "한도 초과", "한도 초과",JOptionPane.ERROR_MESSAGE);
						System.out.println("한도 초과");
						Double newCreditScore = Double.parseDouble(creditScore) - 100; //신용점수 하락
						newCard.setCreditScore(newCreditScore);
						newCard.calLimit();
						
						Writer.append(newCard.getUserName()+",");
						Writer.append(newCard.getCardNumber()+",");
						Writer.append(newCard.getCreditScore()+",");
						Writer.append(newCard.getLimit()+",");
						Writer.append(newCard.getCardCompany()+",");
						Writer.append(newCard.getMII()+",");
						Writer.append(newCard.getExpireDate()+",");
						Writer.append(newCard.getTotalUse()+"\n");
						
						Writer.close();
						
						String finalCreditScore = Double.toString(newCreditScore);
						String finalLimit = Double.toString(newCard.getLimit());
						
						frame.setVisible(false);
						new CreditUseGUISub(name, cardNum, finalCreditScore, finalLimit, cardCom, MII, expiredDate, totalUse);
					}
					
					else {
						//System.out.println(newCard.getCardNumber());
						String newTotalUse = Double.toString(Double.parseDouble(totalUse) + Double.parseDouble(priceField.getText()) * Double.parseDouble(amountField.getText()));
						System.out.println(newTotalUse);
						
						Double newCreditScore = Double.parseDouble(creditScore) + 10;
						newCard.setCreditScore(newCreditScore);
						newCard.calLimit();
						newCard.setTotalUse(Double.parseDouble(newTotalUse));
						
						Writer.append(newCard.getUserName()+",");
						Writer.append(newCard.getCardNumber()+",");
						Writer.append(newCard.getCreditScore()+",");
						Writer.append(newCard.getLimit()+",");
						Writer.append(newCard.getCardCompany()+",");
						Writer.append(newCard.getMII()+",");
						Writer.append(newCard.getExpireDate()+",");
						Writer.append(newCard.getTotalUse()+"\n");
						
						Writer2.append(cardNum + ",");
						Writer2.append(productNameField.getText() + ",");
						Writer2.append(amountField.getText() + ",");
						Writer2.append(Double.parseDouble(priceField.getText()) * Double.parseDouble(amountField.getText()) + ",");
						Writer2.append(new Date().toString()+"\n");

						Writer.close();
						
						String finalCreditScore = Double.toString(newCreditScore);
						String finalLimit = Double.toString(newCard.getLimit());
						
						frame.setVisible(false);
						new CreditUseGUISub(name, cardNum, finalCreditScore, finalLimit, cardCom, MII, expiredDate, newTotalUse);
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
		frame.setTitle("Use Credit Card");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(1000, 630));
		frame.setSize(1000, 630);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
