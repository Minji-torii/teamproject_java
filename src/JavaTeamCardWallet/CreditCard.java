package JavaTeamCardWallet;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreditCard extends BankCard {
	double limit; //����ѵ�
	double[] monthlySpent = new double[12]; // ���� ����
	int creditScore = 250; // �⺻ �ſ�����
	
	
	/*getters and setters*/
	public double getLimit() {
		return limit;
	}



	public void setLimit(double limit) {
		this.limit = limit;
	}



	public int getCreditScore() {
		return creditScore;
	}



	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	
	
	/*�ſ����� ������ ���� ����ѵ��� �ٸ��� ��*/
	
	/*����ѵ� ���*/
	public void calLimit() {
		if(creditScore<=0)
			limit = 0;
		else if(creditScore<100)
			limit = 1000;
		else if(creditScore<200)
			limit = 2000;
		else if(creditScore<300)
			limit = 3000;
		else if(creditScore<400)
			limit = 4000;
		else
			limit = 5000;
	}
	
	/*ī�� ����ϱ�*/
	@Override
	public void useCard(double price, int amount, String productName, Date useDate ) {
		
		calLimit(); //�ѵ� ���
		int useMonth = useDate.getMonth(); //��� ��
		
		monthlySpent[useMonth] += price * amount;
		
		/*System.out.println(monthlySpent[useMonth] + productName + useMonth);*/ //�׽�Ʈ�ڵ�
		
		/*�� ���ݾ��� �ѵ��� �ʰ����� ��*/
		if(monthlySpent[useMonth] > limit) {
			System.out.println("You maxed out!");
			monthlySpent[useMonth] -= price * amount;
			creditScore -= 100; //�ſ����� 100 ����
		}
		else {
			creditScore += 10; //�ſ����� 10 ����
			sendAccountBook(price, amount, productName, useDate); //����η� ���� ������
		}
		
	}
	
	/*����η� ���� ������, ����� Ŭ���� �ϼ��Ǹ� �ۼ�*/
	@Override
	public void sendAccountBook(double price, int amount, String productName, Date useDate) {
	      
	   }
	
	/*�������� �ʱ�ȭ*/
	public void resetMonthlySpent() {
		for(int i=0; i<12; i++) {
			monthlySpent[i] = 0;
		}
	}


	   
}
