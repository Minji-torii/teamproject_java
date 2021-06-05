import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JButton;


		
	public class table extends JFrame {
		tableData td = new tableData();
		
		private JTable creditTb;
		private JTable trafficTb;
		public table() {
		setSize(1000,600);
		setTitle("Card Wallet");
		getContentPane().setLayout(null);
		
		
		//credit
		
		JPanel creditPanel = new JPanel();
		creditPanel.setBounds(27, 58, 935, 430);
		getContentPane().add(creditPanel);
		
		creditTb = new JTable(td1);
		creditPanel.add(creditTb);
		
		//traffic
		
		JPanel trafficPanel = new JPanel();
		trafficPanel.setBounds(27, 58, 935, 430);
		getContentPane().add(trafficPanel);
		
		trafficTb = new JTable(td2);
		trafficPanel.add(trafficTb);
		
		JButton creditBtn = new JButton("Credit Card");
		creditBtn.setBounds(27, 10, 134, 51);
		getContentPane().add(creditBtn);
		
		creditBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creditPanel.setVisible(true);
				trafficPanel.setVisible(false);			
				
			}
			
		});
		
		JButton trafficBtn = new JButton("Traffic Card");
		trafficBtn.setBounds(159, 10, 134, 51);
		getContentPane().add(trafficBtn);
		
		trafficBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creditPanel.setVisible(false);
				trafficPanel.setVisible(true);			
				
			}
			
		});
		
		
		
		}
		
	//JPanel creditCard = new JPanel();
	//JPanel idCard = new JPanel();
		
		
	
	public static void main(String[] args) {
		new table();
	}
}
