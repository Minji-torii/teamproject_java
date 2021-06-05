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
public class CheckUseGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckUseGUI window = new CheckUseGUI();
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
	public CheckUseGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		/*표 만들기*/
		String[] header = new String[]{"Name", "Card number", "Balance", "Card company", "MII", "Expire Date"};
		String[][] data = new String[][] {
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""}
		};
		int count = 0;
		String inputFile = "Check_Card.txt";
		try {
			Scanner inputStream = new Scanner(new File(inputFile));
			String line;
			while(inputStream.hasNextLine()) {
				line = inputStream.nextLine();
				String[] ary = line.split(",");
				String name = ary[0];
				String cardNum = ary[1];
				String balance = ary[2];
				String cardCom = ary[3];
				String MII = ary[4];
				String expireDate = ary[5];
				
				data[count][0] = name;
				data[count][1] = cardNum;
				data[count][2] = balance;
				data[count][3] = cardCom;
				data[count][4] = MII;
				data[count][5] = expireDate;
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
		checkCardRadioButton.setSelected(true);
		
		JRadioButton creditCardRadioButton = new JRadioButton("Credit card");
		creditCardRadioButton.setBounds(539, 41, 113, 23);
		frame.getContentPane().add(creditCardRadioButton);
		
		creditCardRadioButton.addActionListener(new ActionListener() { //credit card 선택하기
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new CreditUseGUI();
			}
		});
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(44, 140, 85, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(210, 140, 85, 15);
		frame.getContentPane().add(lblCardNumber);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(381, 140, 85, 15);
		frame.getContentPane().add(lblBalance);
		
		JLabel lblCardCompany = new JLabel("Card Company");
		lblCardCompany.setBounds(539, 140, 85, 15);
		frame.getContentPane().add(lblCardCompany);
		
		JLabel lblMii = new JLabel("MII");
		lblMii.setBounds(732, 140, 33, 15);
		frame.getContentPane().add(lblMii);
		
		JLabel lblExpireDate = new JLabel("Expire date");
		lblExpireDate.setBounds(887, 140, 85, 15);
		frame.getContentPane().add(lblExpireDate);
		
		String fileName = "Check_Card.txt";
		
		/*테이블 클릭했을 때*/
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
					new CheckUseGUISub(data[rowNum][0],data[rowNum][1],data[rowNum][2],data[rowNum][3],data[rowNum][4],data[rowNum][5]);
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
