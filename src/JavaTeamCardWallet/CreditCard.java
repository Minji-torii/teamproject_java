package JavaTeamCardWallet;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreditCard extends BankCard {
	double limit; //사용한도
	double[] monthlySpent = new double[12]; // 월별 지출
	int creditScore = 250; // 기본 신용점수
	
	
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
	
	
	/*신용점수 구간에 따라 사용한도를 다르게 함*/
	
	/*사용한도 계산*/
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
	
	/*카드 사용하기*/
	@Override
	public void useCard(double price, int amount, String productName, Date useDate ) {
		
		calLimit(); //한도 계산
		int useMonth = useDate.getMonth(); //사용 월
		
		monthlySpent[useMonth] += price * amount;
		
		/*System.out.println(monthlySpent[useMonth] + productName + useMonth);*/ //테스트코드
		
		/*월 사용금액이 한도를 초과했을 때*/
		if(monthlySpent[useMonth] > limit) {
			System.out.println("You maxed out!");
			monthlySpent[useMonth] -= price * amount;
			creditScore -= 100; //신용점수 100 감소
		}
		else {
			creditScore += 10; //신용점수 10 증가
			sendAccountBook(price, amount, productName, useDate); //가계부로 내역 보내기
		}
		
	}
	
	/*가계부로 내역 보내기, 가계부 클래스 완성되면 작성*/
	@Override
	public void sendAccountBook(double price, int amount, String productName, Date useDate) {
	      
	   }
	
	/*월별지출 초기화*/
	public void resetMonthlySpent() {
		for(int i=0; i<12; i++) {
			monthlySpent[i] = 0;
		}
	}


	   
}
