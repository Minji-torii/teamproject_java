package JavaTeamCardWallet;
import java.util.Date;

public class Traffic_card extends Card {
	private String balance = "10000"; // �ܾ� -> string type���� �ٲ���ϴ�. gui���� textfield�� �Է� ������ �ؽ�Ʈ �����̾...
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
		System.out.println("�ܾ��� " + balance + "�� �Դϴ�.");
	}

	public void useTraffic(double spent, Date useDate) {
		if (balance2 - spent >= 0) {
			this.balance2 = this.balance2 - spent;
			System.out.println(spent + "���� ����ϼ̽��ϴ�.");
			System.out.println("�ܾ��� " + balance + "�� �Դϴ�.");
		}
		System.out.println("�ܾ��� �����մϴ�.");
	}

}
