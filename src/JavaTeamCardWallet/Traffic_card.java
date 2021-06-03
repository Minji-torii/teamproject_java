package JavaTeamCardWallet;
import java.util.Date;

public class Traffic_card extends Card {
	private String balance = "10000"; // 잔액 -> string type으로 바꿨습니다. gui에서 textfield로 입력 받을때 텍스트 형식이어서...
	private double balance2 = Double.parseDouble(balance);
	private String cardNum;
	private String userName;

	/* getters and setters */
	public String getbalance() {
		return balance;
	}

	public void setbalance(String string) {
		this.balance = string;

	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cNum) {
		this.cardNum = cNum;

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String uNum) {
		this.userName = uNum;

	}

	void displayTraffic(double balance) {
		System.out.println("잔액은 " + balance + "원 입니다.");
	}

	public void useTraffic(double spent, Date useDate) {
		if (balance2 - spent >= 0) {
			this.balance2 = this.balance2 - spent;
			System.out.println(spent + "원을 사용하셨습니다.");
			System.out.println("잔액은 " + balance + "원 입니다.");
		}
		System.out.println("잔액이 부족합니다.");
	}

}
