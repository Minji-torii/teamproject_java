package JavaTeamCardWallet;

import java.util.Date;

public class Traffic_card extends Card {
	private double balance; // �ܾ�

	/* getters and setters */
	public double getbalance() {
		return balance;
	}

	public void setbalance(double balance) {
		this.balance = balance;
	}

	void displayTraffic(double balance) {
		System.out.println("�ܾ��� "+balance+"�� �Դϴ�.");
	}

	public void useTraffic(double spent , Date useDate) {
		if(balance-spent>=0) {
			this.balance = this.balance - spent;
            System.out.println(spent+"���� ����ϼ̽��ϴ�.");
            System.out.println("�ܾ��� "+balance+"�� �Դϴ�.");
            //Date�� ��� ���?
        }
        System.out.println("�ܾ��� �����մϴ�.");
	}

	/* ����� Ŭ������ ������ */
	public void sendAccountBook() {

	}
}
