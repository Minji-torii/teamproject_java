package JavaTeamCardWallet;

public class ID_card extends Card {
	private String registration, address, typeofID; // 주민번호, 주소, ID 종류
	//사진 등록 처리 필요
	
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
	
	//일단 display를 구현했지만 gui popup으로 띄우는게 좋을듯
	public void displayID() {
		System.out.println("이름 : "+getUserName());
		//사진 display
		System.out.println("주민번호 : "+ this.registration);
		System.out.println("주소 : "+ this.address);
		System.out.println("만료일자 : "+ getExpireDate());

	}
}
