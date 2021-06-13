package JavaTeamCardWallet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame{
	
	
	public Login() {
		
		setTitle("Card Wallet");
		
		JLabel cardImageLabel = new JLabel("");
		cardImageLabel.setBounds(368, 39, 304, 332);
		ImageIcon img= new ImageIcon ("C:/work/image/card.jpg");
		cardImageLabel.setIcon(new ImageIcon(Login.class.getResource("/JavaTeamCardWallet/image/icon.PNG")));
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		label.setBounds(405, 393, 47, 21);
		JLabel pswrd = new JLabel("Password : ");
		pswrd.setBounds(387, 437, 80, 15);
		JTextField txtID = new JTextField(10);
		txtID.setBounds(498, 393, 132, 21);
		JPasswordField txtPass = new JPasswordField(10);
		txtPass.setBounds(498, 434, 132, 21);
		JButton btn1 = new JButton("Login");
		btn1.setBounds(445, 500, 80, 23);
		panel.setLayout(null);
		
		panel.add(label);
		panel.add(cardImageLabel);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(btn1);
		
		panel.setBounds(1000,600,300,50);
		
		btn1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String id = "java";
				String pass = "1234";
				
				if(id.equals(txtID.getText()) && pass.equals(txtPass.getText())){
					setVisible(false);
					new MainMenu();
				}	else {
					JOptionPane.showMessageDialog(null, "Login Failed");
				}
				
			}
		});
		
		//다음페이지.setVisible(false); 맨처음페이지만 보이도록
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				//(다음panel).setVisible(true);
				
				
			}
			
		});
		
		getContentPane().add(panel);
		
		setVisible(true);
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Login();
	}
	
}
