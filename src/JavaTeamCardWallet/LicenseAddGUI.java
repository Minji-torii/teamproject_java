package JavaTeamCardWallet;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LicenseAddGUI {

	private JFrame frmAddDriverLicense;
	private JTextField registrationNumField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LicenseAddGUI window = new LicenseAddGUI();
					window.frmAddDriverLicense.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LicenseAddGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddDriverLicense = new JFrame();

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(268, 304, 97, 37);
		frmAddDriverLicense.getContentPane().add(lblUserName);

		JLabel registrationLabel = new JLabel("license number :");
		registrationLabel.setBounds(268, 374, 145, 23);
		frmAddDriverLicense.getContentPane().add(registrationLabel);

		JLabel lblConditions = new JLabel("conditions :");
		lblConditions.setBounds(268, 485, 97, 37);
		frmAddDriverLicense.getContentPane().add(lblConditions);

		JRadioButton IDRadioButton = new JRadioButton("ID card");
		IDRadioButton.setBounds(200, 37, 113, 23);
		frmAddDriverLicense.getContentPane().add(IDRadioButton);

		JRadioButton PassportRadioButton = new JRadioButton("Passport");
		PassportRadioButton.setBounds(415, 37, 113, 23);
		frmAddDriverLicense.getContentPane().add(PassportRadioButton);

		JRadioButton licenseRadioButton = new JRadioButton("Driver license");
		licenseRadioButton.setSelected(true);
		licenseRadioButton.setBounds(598, 37, 113, 23);
		frmAddDriverLicense.getContentPane().add(licenseRadioButton);

		PassportRadioButton.addActionListener(new ActionListener() { // Passport 선택하기

			public void actionPerformed(ActionEvent e) {
				frmAddDriverLicense.setVisible(false);
				new PassportAddGUI();
			}
		});

		IDRadioButton.addActionListener(new ActionListener() { // ID 선택하기

			public void actionPerformed(ActionEvent e) {
				frmAddDriverLicense.setVisible(false);
				new IDAddGUI();
			}
		});

		JTextField licenseNumField = new JTextField();
		licenseNumField.setBounds(415, 375, 239, 21);
		frmAddDriverLicense.getContentPane().add(licenseNumField);
		licenseNumField.setColumns(10);

		JTextField userNameField = new JTextField();
		userNameField.setColumns(10);
		userNameField.setBounds(415, 312, 239, 21);
		frmAddDriverLicense.getContentPane().add(userNameField);

		JLabel cardImageLabel = new JLabel("");
		cardImageLabel.setBounds(303, 66, 321, 228);
		frmAddDriverLicense.getContentPane().add(cardImageLabel);
		cardImageLabel
				.setIcon(new ImageIcon(LicenseAddGUI.class.getResource("/JavaTeamCardWallet/image/Driver-imege.jpg")));

		JTextField conditionField = new JTextField();
		conditionField.setColumns(10);
		conditionField.setBounds(415, 492, 239, 23);
		frmAddDriverLicense.getContentPane().add(conditionField);

		JButton addButton = new JButton("ADD");
		addButton.setBounds(765, 504, 91, 23);
		frmAddDriverLicense.getContentPane().add(addButton);

		String outputFile = "ID.txt";
		
		addButton.addActionListener(new ActionListener() { // add 버튼 눌렀을 때

			public void actionPerformed(ActionEvent e) {
				Driverlicense newCard = new Driverlicense();
				newCard.setUserName(userNameField.getText());
				newCard.setconditions(conditionField.getText());
				newCard.setlicensenumber(licenseNumField.getText());
				newCard.setregistration(registrationNumField.getText());
				
				try { //텍스트 파일의 ID부분만 변경
					BufferedReader Reader = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile)));
					
					String line;
					String dummy="";
					
					for (int i=0; i<6; i++) {
						line = Reader.readLine();
						dummy +=(line + "\r\n" );
					}
					
					String delData1 = Reader.readLine();//수정하고자 하는 줄
					dummy+=("이름 :"+newCard.getUserName()+", 면허증등급 :"+newCard.getconditions()+", 면허번호 :"+newCard.getlicensenumber()+", 주민번호 :"+newCard.getregistration()+"\r\n");//변경
					
					while((line = Reader.readLine())!=null) {
						dummy +=(line+"\r\n" );
					}
					
					//덮어쓰기
					FileWriter Writer = new FileWriter(outputFile);
					Writer.write(dummy);
					
					Writer.close();
					Reader.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		
		JButton goBackBtn = new AnotherRoundedButton("Back");
		goBackBtn.setBounds(0, 0, 85, 58);
		frmAddDriverLicense.getContentPane().add(goBackBtn);
		goBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frmAddDriverLicense.setVisible(false);
				new MainMenu();
			}

		});

		frmAddDriverLicense.getContentPane().setLayout(null);

		JLabel lblregistration = new JLabel("registration number : ");
		lblregistration.setBounds(268, 433, 127, 15);
		frmAddDriverLicense.getContentPane().add(lblregistration);

		registrationNumField = new JTextField();
		registrationNumField.setBounds(415, 430, 239, 21);
		frmAddDriverLicense.getContentPane().add(registrationNumField);
		registrationNumField.setColumns(10);

		frmAddDriverLicense.setBounds(100, 100, 1000, 630);
		frmAddDriverLicense.setTitle("Add Driver license");
		frmAddDriverLicense.setVisible(true);
		frmAddDriverLicense.setResizable(false);
		frmAddDriverLicense.setPreferredSize(new Dimension(1000, 630));
		frmAddDriverLicense.setSize(1000, 630);
		frmAddDriverLicense.setLocationRelativeTo(null);
		frmAddDriverLicense.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
