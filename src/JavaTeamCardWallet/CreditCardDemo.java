package JavaTeamCardWallet;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreditCardDemo {

	public static void main(String[] args) {
		CreditCard card1 = new CreditCard();
		Date now = new Date();
		
		System.out.println(now);
		
		card1.useCard(100, 2, "°Ç´ã", now);

	}

}
