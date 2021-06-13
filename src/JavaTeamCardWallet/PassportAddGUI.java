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
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JList;
import javax.swing.JCheckBox;

public class PassportAddGUI {

	private JFrame frmAddPassport;
	private JTextField countryofissueField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassportAddGUI window = new PassportAddGUI();
					window.frmAddPassport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PassportAddGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddPassport = new JFrame();

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(268, 94, 97, 37);
		frmAddPassport.getContentPane().add(lblUserName);

		JLabel passportNumLabel = new JLabel("Passport number :");
		passportNumLabel.setBounds(268, 162, 145, 23);
		frmAddPassport.getContentPane().add(passportNumLabel);

		JLabel lblAddress = new JLabel("Nationality : ");
		lblAddress.setBounds(268, 223, 97, 37);
		frmAddPassport.getContentPane().add(lblAddress);

		JRadioButton IDRadioButton = new JRadioButton("ID card");
		IDRadioButton.setBounds(200, 37, 113, 23);
		frmAddPassport.getContentPane().add(IDRadioButton);

		JRadioButton PassportRadioButton = new JRadioButton("Passport");
		PassportRadioButton.setSelected(true);
		PassportRadioButton.setBounds(415, 37, 113, 23);
		frmAddPassport.getContentPane().add(PassportRadioButton);

		JRadioButton licenseRadioButton = new JRadioButton("Driver license");
		licenseRadioButton.setBounds(598, 37, 113, 23);
		frmAddPassport.getContentPane().add(licenseRadioButton);

		IDRadioButton.addActionListener(new ActionListener() { // ID 선택하기

			public void actionPerformed(ActionEvent e) {
				frmAddPassport.setVisible(false);
				new IDAddGUI();
			}
		});

		licenseRadioButton.addActionListener(new ActionListener() { // license 선택하기

			public void actionPerformed(ActionEvent e) {
				frmAddPassport.setVisible(false);
				new LicenseAddGUI();
			}
		});

		JTextField PassNumField = new JTextField();
		PassNumField.setBounds(415, 163, 239, 21);
		frmAddPassport.getContentPane().add(PassNumField);
		PassNumField.setColumns(10);

		JTextField userNameField = new JTextField();
		userNameField.setColumns(10);
		userNameField.setBounds(415, 102, 239, 21);
		frmAddPassport.getContentPane().add(userNameField);

		JTextField NationalityField = new JTextField();
		NationalityField.setColumns(10);
		NationalityField.setBounds(415, 230, 239, 23);
		frmAddPassport.getContentPane().add(NationalityField);

		JButton addButton = new JButton("ADD");
		addButton.setBounds(765, 504, 91, 23);
		frmAddPassport.getContentPane().add(addButton);

		frmAddPassport.getContentPane().setLayout(null);
		
		JLabel lblbirth = new JLabel("Birth day :");
		lblbirth.setBounds(268, 304, 97, 15);
		frmAddPassport.getContentPane().add(lblbirth);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(268, 371, 97, 15);
		frmAddPassport.getContentPane().add(lblGender);
		
		JLabel lblcountryofissue = new JLabel("country of issue :");
		lblcountryofissue.setBounds(268, 437, 113, 15);
		frmAddPassport.getContentPane().add(lblcountryofissue);
		
		JSpinner Birthday = new JSpinner();
		Birthday.setModel(new SpinnerDateModel(new Date(959223600264L), new Date(-1565375556736L), new Date(1621920443264L), Calendar.DAY_OF_WEEK));
		Birthday.setBounds(415, 301, 239, 22);
		frmAddPassport.getContentPane().add(Birthday);
		
		JCheckBox Femalebox = new JCheckBox("Female");
		Femalebox.setBounds(415, 367, 63, 23);
		frmAddPassport.getContentPane().add(Femalebox);
		
		JCheckBox Malebox = new JCheckBox("Male");
		Malebox.setBounds(502, 367, 57, 23);
		frmAddPassport.getContentPane().add(Malebox);
		
		JCheckBox Nonebox = new JCheckBox("None");
		Nonebox.setBounds(590, 367, 107, 23);
		frmAddPassport.getContentPane().add(Nonebox);
		
		countryofissueField = new JTextField();
		countryofissueField.setBounds(415, 434, 239, 21);
		frmAddPassport.getContentPane().add(countryofissueField);
		countryofissueField.setColumns(10);
		
		String outputFile = "ID.txt";
		
		addButton.addActionListener(new ActionListener() { // add 버튼 눌렀을 때

			public void actionPerformed(ActionEvent e) {
				Passport newCard = new Passport();
				String gen="";
				newCard.setUserName(userNameField.getText());
				newCard.setNationality(NationalityField.getText());
				newCard.setPassportnumber(PassNumField.getText());
				if(Femalebox.isSelected())
					gen+="Felmale ";
				if(Malebox.isSelected())
					gen+="male ";
				if(Nonebox.isSelected())
					gen+="None ";
				newCard.setgender(gen);
				newCard.setbirthday(String.valueOf(Birthday.getValue()));
				newCard.setcountryofissue(countryofissueField.getText());
				
				try { //텍스트 파일의 ID부분만 변경
					BufferedReader Reader = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile)));
					
					String line;
					String dummy="";
					
					for (int i=0; i<3; i++) {
						line = Reader.readLine();
						dummy +=(line + "\r\n" );
					}
					
					String delData1 = Reader.readLine();//수정하고자 하는 줄
					dummy+=("이름 :"+newCard.getUserName()+", 국적 :"+newCard.getNationality()+", 여권번호 :"+newCard.getPassportnumber()+"\r\n");//변경
					
					String delData2 = Reader.readLine();//수정하고자 하는 줄
					dummy+=(" 성 :"+newCard.getgender()+", 생년월일 :"+newCard.getbirthday()+", 발행국 :"+newCard.getcountryofissue()+"\r\n");//변경
					
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
		frmAddPassport.getContentPane().add(goBackBtn);
		goBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frmAddPassport.setVisible(false);
				new MainMenu();
			}

		});

		frmAddPassport.setBounds(100, 100, 1000, 630);
		frmAddPassport.setTitle("Add Passport");
		frmAddPassport.setVisible(true);
		frmAddPassport.setResizable(false);
		frmAddPassport.setPreferredSize(new Dimension(1000, 630));
		frmAddPassport.setSize(1000, 630);
		frmAddPassport.setLocationRelativeTo(null);
		frmAddPassport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
