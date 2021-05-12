package JavaTeamCardWallet;

import java.util.Date;

public class Traffic_card extends Card {
	private double balance; // 잔액

	/* getters and setters */
	public double getbalance() {
		return balance;
	}

	public void setbalance(double balance) {
		this.balance = balance;
	}

	void displayTraffic(double balance) {
		System.out.println("잔액은 "+balance+"원 입니다.");
	}

	public void useTraffic(double spent , Date useDate) {
		if(balance-spent>=0) {
			this.balance = this.balance - spent;
            System.out.println(spent+"원을 사용하셨습니다.");
            System.out.println("잔액은 "+balance+"원 입니다.");
            //Date를 어떻게 기록?
        }
        System.out.println("잔액이 부족합니다.");
	}

	/* 가계부 클래스에 보내기 */
	public void sendAccountBook() {

	}
}
