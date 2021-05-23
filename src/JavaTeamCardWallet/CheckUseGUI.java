import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.Scanner;
import javax.swing.JLabel;
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
		
		
		/*표 만들기*/
		String[] header = new String[]{"Name", "Card number", "Balance", "Card company", "MII"};
		String[][] data = new String[][] {
			{"","","","",""},
			{"","","","",""},
			{"","","","",""},
			{"","","","",""},
			{"","","","",""},
			{"","","","",""},
			{"","","","",""}
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
				
				data[count][0] = name;
				data[count][1] = cardNum;
				data[count][2] = balance;
				data[count][3] = cardCom;
				data[count][4] = MII;
				count++;
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable(data, header);
		table.setBounds(0, 59, 996, 543);
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		table.setFillsViewportHeight(true);
		table.setRowHeight(30);
		
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(64, 34, 85, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(261, 34, 85, 15);
		frame.getContentPane().add(lblCardNumber);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(467, 34, 85, 15);
		frame.getContentPane().add(lblBalance);
		
		JLabel lblCardCompany = new JLabel("Card Company");
		lblCardCompany.setBounds(651, 34, 85, 15);
		frame.getContentPane().add(lblCardCompany);
		
		JLabel lblMii = new JLabel("MII");
		lblMii.setBounds(878, 34, 33, 15);
		frame.getContentPane().add(lblMii);
		
		/*테이블 클릭했을 때*/
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int rowNum = table.getSelectedRow();
				//System.out.println(rowNum);
				frame.setVisible(false);
				new CheckUseGUISub(data[rowNum][0],data[rowNum][1],data[rowNum][2],data[rowNum][3],data[rowNum][4]);
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
