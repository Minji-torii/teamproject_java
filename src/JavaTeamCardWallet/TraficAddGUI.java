// 뒤로가기 버튼 설정 addcard menu로 돌아가는 버튼 만들기
package JavaTeamCardWallet;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.PrintWriter;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;

public class TraficAddGUI {

	private JFrame frame;
	private JTextField TcardNum;
	private JTextField inputName;
	private JTextField inputBalance;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraficAddGUI window = new TraficAddGUI();
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
	public TraficAddGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1011, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel addTraficCard = new JPanel();
		addTraficCard.setBounds(0, 10, 985, 619);
		frame.getContentPane().add(addTraficCard);
		addTraficCard.setLayout(null);
		addTraficCard.setVisible(true);
		JLabel lblNewLabel = new JLabel("Card Number  ");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBounds(295, 390, 111, 38);
		addTraficCard.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(294, 438, 81, 36);
		addTraficCard.add(lblNewLabel_1);

		TcardNum = new JTextField();
		TcardNum.setBounds(400, 397, 236, 28);
		addTraficCard.add(TcardNum);
		TcardNum.setColumns(10);

		inputName = new JTextField();
		inputName.setBounds(400, 438, 236, 27);
		addTraficCard.add(inputName);
		inputName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Balance");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(295, 484, 81, 38);
		addTraficCard.add(lblNewLabel_3);

		inputBalance = new JTextField();
		inputBalance.setBounds(400, 485, 236, 28);
		addTraficCard.add(inputBalance);
		inputBalance.setColumns(10);

		JButton addBtn = new JButton("Add");
		addBtn.setFont(new Font("굴림", Font.PLAIN, 16));
		addBtn.setBounds(726, 548, 103, 38);
		addTraficCard.add(addBtn);
		// 교통카드등록 화면 -> 등록할 카드종류 선택하는 화면으로 넘어가야함
		JButton backbtn = new JButton("Back");
		backbtn.setFont(new Font("굴림", Font.PLAIN, 14));
		backbtn.setBounds(0, 0, 103, 38);
		addTraficCard.add(backbtn);
		
		JLabel cardImageLabel = new JLabel("");
		cardImageLabel.setIcon(new ImageIcon(TraficAddGUI.class.getResource("/JavaTeamCardWallet/image/TrafficCard.PNG")));
		
		cardImageLabel.setBounds(363, 105, 321, 228);
		addTraficCard.add(cardImageLabel);
		backbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new MainMenu();
			}

		});

		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Traffic_card trafficCard1 = new Traffic_card();
				// Traffic_card를 생성할 때, balance가 공백인데 parseInt를 적용해서 그랬던 것 같습니다. 
				//balance를 10000으로 임시로 성정해서 고쳤습니다.
				trafficCard1.setbalance(inputBalance.getText());
				trafficCard1.setCardNum(TcardNum.getText());
				trafficCard1.setUserName(inputName.getText());
				System.out.println(trafficCard1.getbalance());
				
				// 파일에 쓰는 코드는 문제가 없음.
				String fileName = "Traffic_card.txt";
				
				try {
					BufferedWriter Writer = new BufferedWriter(new FileWriter(fileName,true));
					System.out.println(trafficCard1.getUserName());
					
					Writer.write(trafficCard1.getCardNum()+ " ");
					Writer.write( trafficCard1.getUserName() + " ");
					Writer.write(trafficCard1.getbalance() + "\n");
					
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

	}
}
