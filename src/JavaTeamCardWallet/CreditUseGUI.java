package JavaTeamCardWallet;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class CreditUseGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditUseGUI window = new CreditUseGUI();
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
	public CreditUseGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JButton goBackBtn = new AnotherRoundedButton("Back");
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
		
		/*占쎈ご 筌띾슢諭얏묾占�*/
		String[] header = new String[]{"Name", "Card number", "Credit score", "Limit", "Card company", "MII", "Expire Date", "Total Use"};
		String[][] data = new String[][] {
			{"","","","","","","",""},
			{"","","","","","","",""},
			{"","","","","","","",""},
			{"","","","","","","",""},
			{"","","","","","","",""},
			{"","","","","","","",""},
			{"","","","","","","",""}
		};
		int count = 0;
		String inputFile = "Credit_Card.txt";
		try {
			Scanner inputStream = new Scanner(new File(inputFile));
			String line;
			while(inputStream.hasNextLine()) {
				line = inputStream.nextLine();
				String[] ary = line.split(",");
				String name = ary[0];
				String cardNum = ary[1];
				String creditScore = ary[2];
				String limit = ary[3];
				String cardCom = ary[4];
				String MII = ary[5];
				String expireDate = ary[6];
				String totalUse = ary[7];
				
				data[count][0] = name;
				data[count][1] = cardNum;
				data[count][2] = creditScore;
				data[count][3] = limit;
				data[count][4] = cardCom;
				data[count][5] = MII;
				data[count][6] = expireDate;
				data[count][7] = totalUse;
				count++;
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable(data, header);
		table.setBounds(0, 165, 996, 437);
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		table.setFillsViewportHeight(true);
		table.setRowHeight(30);
		
		frame.getContentPane().add(table);
		
		JRadioButton checkCardRadioButton = new JRadioButton("Check card");
		checkCardRadioButton.setBounds(309, 41, 113, 23);
		frame.getContentPane().add(checkCardRadioButton);
		
		
		JRadioButton creditCardRadioButton = new JRadioButton("Credit card");
		creditCardRadioButton.setBounds(539, 41, 113, 23);
		frame.getContentPane().add(creditCardRadioButton);
		creditCardRadioButton.setSelected(true);
		
		checkCardRadioButton.addActionListener(new ActionListener() { //check card 占쎄퐨占쎄문占쎈릭疫뀐옙
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new CheckUseGUI();
			}
		});
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(23, 140, 85, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(148, 140, 85, 15);
		frame.getContentPane().add(lblCardNumber);
		
		JLabel lblLimit = new JLabel("Limit");
		lblLimit.setBounds(418, 140, 85, 15);
		frame.getContentPane().add(lblLimit);
		
		JLabel lblCardCompany = new JLabel("Card Company");
		lblCardCompany.setBounds(515, 140, 85, 15);
		frame.getContentPane().add(lblCardCompany);
		
		JLabel lblMii = new JLabel("MII");
		lblMii.setBounds(675, 140, 33, 15);
		frame.getContentPane().add(lblMii);
		
		JLabel lblExpireDate = new JLabel("Expire date");
		lblExpireDate.setBounds(775, 140, 85, 15);
		frame.getContentPane().add(lblExpireDate);
		
		JLabel lblCreditScore = new JLabel("Credit Score");
		lblCreditScore.setBounds(273, 140, 85, 15);
		frame.getContentPane().add(lblCreditScore);
		
		JLabel lblTotalUse = new JLabel("Total Use");
		lblTotalUse.setBounds(899, 140, 85, 15);
		frame.getContentPane().add(lblTotalUse);
		
		String fileName = "Credit_Card.txt";
		
		/*占쎈�믭옙�뵠�뇡占� 占쎄깻�뵳占쏙옙六쏙옙�뱽 占쎈르*/
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				try {
					String line = "";
					int rowNum = table.getSelectedRow();
					BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
					
					for(int i=0; i<rowNum; i++) {
						line = line + inputStream.readLine();
						line += "\n";
					}
					//System.out.println(line);

					String dummy = inputStream.readLine();
					
					//System.out.println(dummy);
					
					String buff = null;
					
					while((buff=inputStream.readLine()) != null) {
						line += buff;
						line += "\n";
					}
					
					inputStream.close();
					
					System.out.println(line);
					
					BufferedWriter outputStream = new BufferedWriter(new FileWriter(fileName));
					outputStream.write(line);
					outputStream.close();
					frame.setVisible(false);
					new CreditUseGUISub(data[rowNum][0],data[rowNum][1],data[rowNum][2],data[rowNum][3],data[rowNum][4],data[rowNum][5],data[rowNum][6],data[rowNum][7]);
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
