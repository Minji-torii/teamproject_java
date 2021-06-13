package JavaTeamCardWallet;

public class ID_card extends Card {
	private String registration, address; // 주민번호, 주소, ID 종류
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
}
