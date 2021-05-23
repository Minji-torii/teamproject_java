import java.util.Date;
import java.util.Scanner;

public class BankCard extends Card {
   private String MII, cardCompany, cardNumber; //카드 MII, 카드회사, 카드번호
   private String firstLetter, fourLetter;
   
   Scanner keyboard = new Scanner(System.in);
   
   /*getters and setters*/
   public String getMII() {
      return MII;
   }

   public void setMII(String MII) {
      this.MII = MII;
   }

   public String getCardCompany() {
      return cardCompany;
   }

   public void setCardCompany(String cardCompany) {
      this.cardCompany = cardCompany;
   }

   public String getCardNumber() {
      return cardNumber;
   }

   public void setCardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
   }

   
   /*카드 번호에서 카드 정보 읽어오기*/
   public void InputCardNum(String newCardNum) {
      cardNumber = newCardNum;
      firstLetter = cardNumber.substring(0,1);
      fourLetter = cardNumber.substring(0,4);
      
      switch (firstLetter) {
      case "4":
         MII = "VISA";
         break;
      case "5":
         MII = "MASTER CARD";
         break;
      case "9":
         MII = "Normal Card";
         break;
      default :
          System.out.println("Wrong first letter, Please try again");
          this.InputCardNum(newCardNum);
          break;
      }
      
      switch (fourLetter) {
      case "4119":
         cardCompany = "하나 카드";
         break;
      case "4512":
         cardCompany = "삼성 카드";
         break;
      case "4579":
         cardCompany = "국민 카드";
         break;
      case "4048":
         cardCompany = "BC 카드";
         break;
      case "5021":
         cardCompany = "KB국민카드";
         break;
      case "5107":
         cardCompany = "신한카드";
         break;
      case "5123":
         cardCompany = "삼성카드";
         break;
      case "9430":
         cardCompany = "BC카드";
         break;
      case "9409":
         cardCompany = "롯데카드";
         break;
      case "9530":
         cardCompany = "광주은행";
         break;
      default :
          System.out.println("Wrong first letter, Please try again");
          this.InputCardNum(newCardNum);
          break;
      }
   }

   /*카드 사용하기*/
   public void useCard(double price, int amount, String productName, Date useDate ) {
      
   }
   
   /*가계부 클래스 완성되면*/
   public void sendAccountBook(double price, int amount, String productName, Date useDate) {
      
   }
   
   
}