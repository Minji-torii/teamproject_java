package JavaTeamCardWallet;

public class ID_card extends Card {
	private String registration, address, typeofID; // �ֹι�ȣ, �ּ�, ID ����
	//���� ��� ó�� �ʿ�
	
	public String getregistration() {
		return registration;
	}

	public void setregistration(String registration) {
		this.registration = registration;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String gettypeofID() {
		return typeofID;
	}

	public void settypeofID(String typeofID) {
		this.typeofID = typeofID;
	}
	
	//�ϴ� display�� ���������� gui popup���� ���°� ������
	public void displayID() {
		System.out.println("�̸� : "+getUserName());
		//���� display
		System.out.println("�ֹι�ȣ : "+ this.registration);
		System.out.println("�ּ� : "+ this.address);
		System.out.println("�������� : "+ getExpireDate());

	}
}
