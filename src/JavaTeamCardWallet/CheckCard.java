package JavaTeamCardWallet;
import java.util.Date;
import java.util.Scanner;  
public class CheckCard extends BankCard{
	private double balance,price, spent;
	int amount;
	
	//카드 잔액 불러오는 매쏘드
	public void setBalance() {
		System.out.println("Enter your balance");
		balance = keyboard.nextDouble();
	}
	//카드 사용하는 함수 override
	//방법1
	@Override
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
		
	}
	
	public double getBalance() {
		return balance;
	}
	
}
