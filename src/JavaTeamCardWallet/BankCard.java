import java.util.Date;
import java.util.Scanner;

public class BankCard extends Card {
   private String MII, cardCompany, cardNumber; //ī�� MII, ī��ȸ��, ī���ȣ
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

   
   /*ī�� ��ȣ���� ī�� ���� �о����*/
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
         cardCompany = "�ϳ� ī��";
         break;
      case "4512":
         cardCompany = "�Ｚ ī��";
         break;
      case "4579":
         cardCompany = "���� ī��";
         break;
      case "4048":
         cardCompany = "BC ī��";
         break;
      case "5021":
         cardCompany = "KB����ī��";
         break;
      case "5107":
         cardCompany = "����ī��";
         break;
      case "5123":
         cardCompany = "�Ｚī��";
         break;
      case "9430":
         cardCompany = "BCī��";
         break;
      case "9409":
         cardCompany = "�Ե�ī��";
         break;
      case "9530":
         cardCompany = "��������";
         break;
      default :
          System.out.println("Wrong first letter, Please try again");
          this.InputCardNum(newCardNum);
          break;
      }
   }

   /*ī�� ����ϱ�*/
   public void useCard(double price, int amount, String productName, Date useDate ) {
      
   }
   
   /*����� Ŭ���� �ϼ��Ǹ�*/
   public void sendAccountBook(double price, int amount, String productName, Date useDate) {
      
   }
   
   
}