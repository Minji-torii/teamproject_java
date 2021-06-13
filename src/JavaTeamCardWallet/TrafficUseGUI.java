package JavaTeamCardWallet;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = null;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null))); // panel size == img size
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}

public class TrafficUseGUI {

	private JFrame frame;
	private JTextField fee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrafficUseGUI window = new TrafficUseGUI();
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
	public TrafficUseGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1000, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel TrafficUse = new JPanel();
		TrafficUse.setBounds(0, 0, 1000, 630);
		frame.getContentPane().add(TrafficUse);
		TrafficUse.setLayout(null);

		JTextArea outputBalance = new JTextArea();
		outputBalance.setBounds(404, 496, 121, 24);
		TrafficUse.add(outputBalance);
		// use button 눌렀을때 잔액이 차감 되야함
		// fee를 변수에 저장 -> Traffic_card.txt 정보르 읽어오기(가장 마지막 줄의 balance값 읽기) -> balance 를
		// double 타입으로 변환
		// balance -= fee -> Traffic_card.txt 에 변경된 balance 값 추가.
		
		fee = new JTextField();
		fee.setBounds(404, 339, 121, 28);
		TrafficUse.add(fee);
		fee.setColumns(10);
		
		String[][] data = new String[][] {
			{"","",""}
			};
			
		JButton useTrafficCard = new JButton("USE");
		useTrafficCard.setBounds(404, 416, 121, 43);
		TrafficUse.add(useTrafficCard);
		useTrafficCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// class
				
				String Tbalance = null;
				//double fee2 = Double.parseDouble(fee.getSelectedText()); // fee 변수에 저장 double type
				Tbalance = fee.getText();
				Double fee2 = Double.parseDouble(Tbalance);
				
				String inputFile = "Traffic_card.txt";
				String line;
				try {

					Scanner inputStream = new Scanner(new File(inputFile));
					line = inputStream.nextLine();
					System.out.println(line);
					
						String[] ary = line.split(" ");
						String cardNumber = ary[0];
						String user = ary[1];
						String bal = ary[2];
						data[0][0] = cardNumber;
						data[0][1] = user;
						data[0][2] = bal;
						System.out.println(data[0][2]);
						
				
					inputStream.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				double Dbalance = Double.parseDouble(data[0][2]);
				Dbalance -= fee2;
				
				Tbalance = Double.toString(Dbalance);
				System.out.println(Tbalance);
				outputBalance.setText(Tbalance);

				
				
				
				// traffic_card.txt에 추가하기
				String fileName2 = "Traffic_card.txt";
				PrintWriter outputStream;
				try {
					outputStream = new PrintWriter(new FileOutputStream(fileName2));
					outputStream.println(data[0][0] + " " + data[0][1] + " " + Tbalance); // 변경된 값 텍스트에
																											// 추가하기
					outputStream.close();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}

		});

		// 교통카드사용 화면 -> 사용할 카드 선택하는 화면으로 넘어가야함
		JButton backToUsecard = new JButton("BACK");
		backToUsecard.setBounds(0, 0, 111, 52);
		TrafficUse.add(backToUsecard);

		

		JLabel Fee = new JLabel("Fee :  ");
		Fee.setFont(new Font("굴림", Font.PLAIN, 14));
		Fee.setBounds(309, 335, 69, 35);
		TrafficUse.add(Fee);

		JLabel lblNewLabel = new JLabel("Balance : ");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel.setBounds(309, 500, 69, 17);
		TrafficUse.add(lblNewLabel);

		JLabel cardImageLabel = new JLabel("");
		cardImageLabel.setIcon(new ImageIcon(TrafficUseGUI.class.getResource("/JavaTeamCardWallet/image/TrafficCard.PNG")));
		cardImageLabel.setBounds(339, 63, 321, 228);
		TrafficUse.add(cardImageLabel);

		backToUsecard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new MainMenu();
			}

		});

	}
}
