package JavaTeamCardWallet;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

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
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class ID_cardUseGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ID_cardUseGUI window = new ID_cardUseGUI();
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
	public ID_cardUseGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
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
		
		String inputFile = "ID.txt";
		String dummy1="";
		String dummy2="";
		String dummy3="";
		try { //�ؽ�Ʈ ������ ID�κи� ����
			BufferedReader Reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			
			String line;
			
			for (int i=0; i<2; i++) {
				line = Reader.readLine();
				dummy1 +=(line + "\r\n" );
			}
			for (int i=2; i<5; i++) {
				line = Reader.readLine();
				dummy2 +=(line + "\r\n" );
			}
			for (int i=5; i<7; i++) {
				line = Reader.readLine();
				dummy3 +=(line + "\r\n" );
			}
			Reader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(dummy1);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(97, 52, 796, 115);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(dummy2);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(97, 221, 796, 115);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(dummy3);
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(97, 382, 796, 115);
		frame.getContentPane().add(lblNewLabel_2);
		
		frame.setBounds(100, 100, 1000, 630);
		frame.setTitle("Use ID Card");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(1000, 630));
		frame.setSize(1000, 630);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
