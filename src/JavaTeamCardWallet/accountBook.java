package JavaTeamCardWallet;

import java.util.Scanner;

public class accountBook {

	private double initialAmount = 100000, spentAmount;
	private String date;

	Scanner scan = new Scanner(System.in);

	public double getinitialAmount() {
		return initialAmount; // 추후 구현(초기값 설정안됬을시 해당 메서드 타도록)
	}

	public void setinitialAmount(double initialAmount) {
		initialAmount = scan.nextDouble();
	}

	public void spentAmount() {
		spentAmount = scan.nextDouble();
	}

	public double sum() {
		double FinalAmount = initialAmount - spentAmount;
		return FinalAmount;
	}

	public static void main(String[] args) {

		System.out.println("사용날짜     " + "사용금액     " + "총잔여금액");

		System.out.println("date    " + "spentAmount     " + "FinalAmount");

	} // 추후 콘솔창아닌 화면에출력하도록

}
