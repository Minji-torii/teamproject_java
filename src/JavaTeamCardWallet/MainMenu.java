package JavaTeamCardWallet;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel mainMenu = new JPanel();
		JPanel addCard = new JPanel();
		JPanel useCard = new JPanel();
		JPanel AccountBook = new JPanel();
		JPanel useCard2 = new JPanel();

		frame.setVisible(true);
		mainMenu.setVisible(true);
		useCard.setVisible(false);
		addCard.setVisible(false);
		AccountBook.setVisible(false);
		useCard2.setVisible(false);

//main menu
		mainMenu.setBounds(0, 0, 1000, 600);
		frame.getContentPane().add(mainMenu);
		mainMenu.setLayout(null);

		RoundedButton useCardBtn = new RoundedButton("Use Card");
		useCardBtn.setFont(new Font("굴림", Font.BOLD, 18));
		useCardBtn.setBounds(413, 199, 164, 219);
		mainMenu.add(useCardBtn);
		useCardBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(false);
				useCard2.setVisible(true);
				mainMenu.setVisible(false);
			}

		});

		RoundedButton addCardBtn = new RoundedButton("Add Card");
		addCardBtn.setFont(new Font("굴림", Font.BOLD, 18));
		addCardBtn.setBounds(124, 198, 163, 220);
		mainMenu.add(addCardBtn);
		addCardBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(true);
				useCard.setVisible(false);
				mainMenu.setVisible(false);
			}

		});

		RoundedButton accountBtn = new RoundedButton("Account Book");
		accountBtn.setFont(new Font("굴림", Font.BOLD, 18));
		accountBtn.setBounds(705, 202, 165, 216);
		mainMenu.add(accountBtn);
		accountBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(false);
				useCard.setVisible(false);
				mainMenu.setVisible(false);
				AccountBook.setVisible(true);
				frame.setVisible(false);
				new table();
			}

		});

		JLabel mainLabel = new JLabel("Select Menu");
		mainLabel.setFont(new Font("굴림", Font.BOLD, 28));
		mainLabel.setBounds(413, 74, 210, 77);
		mainMenu.add(mainLabel);
		
		JButton btnLogOut = new AnotherRoundedButton("Log Out");
		btnLogOut.setBounds(0, 0, 91, 23);
		mainMenu.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(false);
				useCard.setVisible(false);
				mainMenu.setVisible(false);
				AccountBook.setVisible(true);
				frame.setVisible(false);
				new Login();
			}

		});

		// Use card section
		/*
		 * 폐기 예정 useCard.setBounds(0, 0, 1000, 600);
		 * frame.getContentPane().add(useCard); useCard.setLayout(null);
		 * 
		 * JLabel lblNewLabel = new JLabel("USE CARD"); lblNewLabel.setFont(new
		 * Font("굴림", Font.BOLD, 26)); lblNewLabel.setBounds(406, 53, 144, 48);
		 * useCard.add(lblNewLabel);
		 * 
		 * JButton card1 = new JButton("Card1"); card1.setBounds(76, 144, 189, 98);
		 * useCard.add(card1);
		 * 
		 * JButton card2 = new JButton("Card2"); card2.setBounds(373, 144, 190, 99);
		 * useCard.add(card2);
		 * 
		 * JButton card3 = new JButton("Card3"); card3.setBounds(667, 144, 188, 99);
		 * useCard.add(card3);
		 * 
		 * JButton backToMainMenu2 = new JButton("Back"); backToMainMenu2.setBounds(0,
		 * 10, 72, 42); useCard.add(backToMainMenu2);
		 * backToMainMenu2.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub addCard.setVisible(false); useCard.setVisible(false);
		 * mainMenu.setVisible(true); }
		 * 
		 * });
		 */
// Add card panel 

		addCard.setBounds(0, 0, 1000, 600);
		frame.getContentPane().add(addCard);
		addCard.setLayout(null);
		// bank card 버튼을 눌렀을때 신용카드 혹은 체크 카드를 선택하는 창으로 넘어가는 기능을 추가해야함
		RoundedButton BankCardbtn = new RoundedButton("BankCard");
		BankCardbtn.setBounds(123, 199, 164, 219);
		addCard.add(BankCardbtn);
		BankCardbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(false);
				useCard.setVisible(false);
				mainMenu.setVisible(false);
				AccountBook.setVisible(false);
				frame.setVisible(false);
				new CheckAddGUI();
				// new CreditAddGUI();
				// new CheckAddGUI();
			}

		});

		RoundedButton idCardbtn = new RoundedButton("ID Card");
		idCardbtn.setBounds(413, 199, 164, 219);
		addCard.add(idCardbtn);
		idCardbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(false);
				useCard.setVisible(false);
				mainMenu.setVisible(false);
				AccountBook.setVisible(false);
				frame.setVisible(false);
				new IDAddGUI(); //move to ID Add
				// new IDAddGUI();
				//
			}

		});

		RoundedButton traficCardbtn = new RoundedButton("Trafic Card");
		traficCardbtn.setBounds(706, 199, 164, 219);
		addCard.add(traficCardbtn);
		traficCardbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(false);
				useCard.setVisible(false);
				mainMenu.setVisible(false);
				AccountBook.setVisible(false);
				frame.dispose();
				new TraficAddGUI();

				//
			}

		});

		JLabel lblNewLabel_1 = new JLabel("Add Card");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 28));
		lblNewLabel_1.setBounds(413, 71, 164, 90);
		addCard.add(lblNewLabel_1);

		JButton backToMainMenu = new AnotherRoundedButton("Back");
		backToMainMenu.setBounds(0, 0, 95, 23);
		addCard.add(backToMainMenu);
		backToMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(false);
				useCard.setVisible(false);
				mainMenu.setVisible(true);
			}

		});

// mainmenu에서  usecard  버튼 눌렀을 때 보이는 화면

		useCard2.setBounds(0, 0, 1000, 600);
		frame.getContentPane().add(useCard2);
		useCard2.setLayout(null);
		JLabel useCardLabel = new JLabel("Use Card");
		useCardLabel.setFont(new Font("굴림", Font.BOLD, 28));
		useCardLabel.setBounds(413, 67, 168, 77);
		useCard2.add(useCardLabel);

		RoundedButton UseBankBtn = new RoundedButton("Bank Card");
		UseBankBtn.setBounds(124, 199, 162, 219);
		useCard2.add(UseBankBtn);
		UseBankBtn.addActionListener(new ActionListener() { //Bank Use 선택
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new CreditUseGUI();
			}
		});

		RoundedButton useIDcardBtn = new RoundedButton("ID Card");
		useIDcardBtn.setBounds(413, 199, 162, 219);
		useCard2.add(useIDcardBtn);
		useIDcardBtn.addActionListener(new ActionListener() { //Id Use 선택
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new ID_cardUseGUI();
			}
		});

		RoundedButton useTrafficbtn = new RoundedButton("Traffic Card");
		useTrafficbtn.setBounds(702, 203, 168, 215);
		useCard2.add(useTrafficbtn);
		useTrafficbtn.addActionListener(new ActionListener() { // Use 선택
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new TrafficUseGUI();
			}
		});

		JButton useCardBacktoMain = new AnotherRoundedButton("Back");
		useCardBacktoMain.setBounds(0, 0, 95, 23);
		useCard2.add(useCardBacktoMain);
		useCardBacktoMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(false);
				useCard2.setVisible(false);
				mainMenu.setVisible(true);
				AccountBook.setVisible(false);
			}

		});
		// Acount book section
		AccountBook.setBounds(0, 0, 986, 593);
		frame.getContentPane().add(AccountBook);
		AccountBook.setLayout(null);

		JButton backToMainMenu3 = new AnotherRoundedButton("Back");
		backToMainMenu3.setBounds(0, 0, 89, 40);
		AccountBook.add(backToMainMenu3);

		backToMainMenu3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCard.setVisible(false);
				useCard.setVisible(false);
				mainMenu.setVisible(true);
				AccountBook.setVisible(false);
			}

		});
	}
}
