import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Scanner;  
public class CheckCard extends BankCard{
	private double balance,price, spent;
	int amount;
	
	//카드 잔액 불러오는 매쏘드
	public void setBalance(String newBalance) {
		balance = Double.parseDouble(newBalance);
	}
	//카드 사용하는 함수 override
	//방법1
	//@Override
	/*
	public void useCard(double spent, int amount, String productName, Date useDate ) {
		price = spent * amount;
		
		if (balance -price < 0) {
			System.out.println("Insufficient Balance");
		}
		else if (balance -price >= 0) {
			balance = balance -price;			
		}
		getBalance();
	}
	*/
	// 방법 2
	/*
	public void useCard() {
		System.out.println("payment information");
		System.out.println("How much?");
		spent = keyboard.nextDouble();
		System.out.println("How many?");
		amount = keyboard.nextInt();
		price = spent * amount;
		
		if (balance -price < 0) {
			System.out.println("Insufficient Balance");
			this.useCard();
		}
		else if (balance -price >= 0) {
			balance = balance -price;			
		}
		
	}*/
	
	public double getBalance() {
		return balance;
	}
	/*SQL 사용하려고 시도했던 부분
	public static void createCheckCard(String name, String cardNum, String balance, String cardCompany, String MII) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO Check_Card"
					+ "(name, cardNum, balance, cardCompany, MII) "
					+ "VALUE "
					+"('"+name+"','"+cardNum+"','"+balance+"','"+cardCompany+"','"+MII+"')");
			insert.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+ "Check_Card(id int NOT NULL, AUTO_INCREMENT,"
					+ "name varChar(255),"
					+ "cardNum varChar(255),"
					+ "balance varChar(255),"
					+ "cardCompany varChar(255),"
					+ "MII varChar(255),"
					+ "PRIMARY KEY(id))");
			create.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Table Successfully Created");
		}
	}
	

	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6414145";
			String user = "sql6414145";
			String pass ="3nF6zatC9q";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("The Connection Successful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}*/
	
}