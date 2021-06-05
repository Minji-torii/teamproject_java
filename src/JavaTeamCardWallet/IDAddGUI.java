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

public class IDAddGUI {
	
	private JFrame frmAddIdCard;
	
	//임시 테스트 용 (passport, licence에서 이동하려면 지워야 함)
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IDAddGUI window = new IDAddGUI();
					window.frmAddIdCard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
    /**
     * Creates new form IDAddGUI
     */
    public IDAddGUI() {
    	initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initialize() {
    	frmAddIdCard = new JFrame();
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(268, 304, 97, 37);
		frmAddIdCard.getContentPane().add(lblUserName);
		
		JLabel registrationLabel = new JLabel("Registration number :");
		registrationLabel.setBounds(268, 380, 145, 23);
		frmAddIdCard.getContentPane().add(registrationLabel);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(268, 444, 97, 37);
		frmAddIdCard.getContentPane().add(lblAddress);
		
		JRadioButton IDRadioButton = new JRadioButton("ID card");
		IDRadioButton.setBounds(200, 37, 113, 23);
		frmAddIdCard.getContentPane().add(IDRadioButton);
		IDRadioButton.setSelected(true);
		
		JRadioButton PassportRadioButton = new JRadioButton("Passport");
		PassportRadioButton.setBounds(415, 37, 113, 23);
		frmAddIdCard.getContentPane().add(PassportRadioButton);
		
		JRadioButton licenseRadioButton = new JRadioButton("Driver license");
		licenseRadioButton.setBounds(598, 37, 113, 23);
		frmAddIdCard.getContentPane().add(licenseRadioButton);
		
		PassportRadioButton.addActionListener(new ActionListener() { //Passport 선택하기
			
			public void actionPerformed(ActionEvent e) {
				frmAddIdCard.setVisible(false);
				new PassportAddGUI();
			}
		});
		
		licenseRadioButton.addActionListener(new ActionListener() { //license 선택하기
			
			public void actionPerformed(ActionEvent e) {
				frmAddIdCard.setVisible(false);
				new LicenseAddGUI();
			}
		});
		
		JTextField cardNumField = new JTextField();
		cardNumField.setBounds(415, 381, 239, 21);
		frmAddIdCard.getContentPane().add(cardNumField);
		cardNumField.setColumns(10);
		
		JTextField userNameField = new JTextField();
		userNameField.setColumns(10);
		userNameField.setBounds(415, 312, 239, 21);
		frmAddIdCard.getContentPane().add(userNameField);
		
		JLabel cardImageLabel = new JLabel("");
		cardImageLabel.setBounds(316, 66, 321, 228);
		frmAddIdCard.getContentPane().add(cardImageLabel);
		cardImageLabel.setIcon(new ImageIcon(IDAddGUI.class.getResource("/JavaTeamCardWallet/image/ID-card-image.png")));

		
		JTextField addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(415, 444, 239, 71);
		frmAddIdCard.getContentPane().add(addressField);
		
		JButton addButton = new JButton("ADD");
		addButton.setBounds(765, 504, 91, 23);
		frmAddIdCard.getContentPane().add(addButton);

		String outputFile = "ID.txt";
		
		addButton.addActionListener(new ActionListener() { //add 버튼 눌렀을 때

			public void actionPerformed(ActionEvent e) {
				ID_card newCard = new ID_card();
				newCard.setUserName(userNameField.getText());
				newCard.setaddress(addressField.getText());
				newCard.setregistration(cardNumField.getText());
				
				try { //텍스트 파일의 ID부분만 변경
					BufferedReader Reader = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile)));
					
					String line;
					String dummy="";
					
					for (int i=0; i<1; i++) {
						line = Reader.readLine();
						dummy +=(line + "\r\n" );
					}
					
					String delData = Reader.readLine();//수정하고자 하는 줄
					dummy+=(" 이름 :"+newCard.getUserName()+", 주민등록번호 :"+newCard.getregistration()+", 주소 :"+newCard.getaddress()+"\r\n");//변경
					
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
		
		JButton goBackBtn = new JButton("Back");
		goBackBtn.setBounds(0, 0, 85, 58);
		frmAddIdCard.getContentPane().add(goBackBtn);
		goBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frmAddIdCard.setVisible(false);
				new MainMenu();
			}

		});
		
		frmAddIdCard.getContentPane().setLayout(null);

		
		frmAddIdCard.setBounds(100, 100, 1000, 630);
		frmAddIdCard.setTitle("Add ID Card");
		frmAddIdCard.setVisible(true);
		frmAddIdCard.setResizable(false);
		frmAddIdCard.setPreferredSize(new Dimension(1000, 630));
		frmAddIdCard.setSize(1000, 630);
		frmAddIdCard.setLocationRelativeTo(null);
		frmAddIdCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}
}
