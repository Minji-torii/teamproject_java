package JavaTeamCardWallet;

import java.util.Scanner;

public class accountBook {

	private double initialAmount = 100000, spentAmount;
	private String date;

	Scanner scan = new Scanner(System.in);

	public double getinitialAmount() {
		return initialAmount; // ���� ����(�ʱⰪ �����ȉ����� �ش� �޼��� Ÿ����)
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

		System.out.println("��볯¥     " + "���ݾ�     " + "���ܿ��ݾ�");

		System.out.println("date    " + "spentAmount     " + "FinalAmount");

	} // ���� �ܼ�â�ƴ� ȭ�鿡����ϵ���

}
