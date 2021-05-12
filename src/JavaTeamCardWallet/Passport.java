package JavaTeamCardWallet;

public class Passport extends ID_card{
	private String Passportnumber, Nationality, birthday, gender, countryofissue; // 주민번호, 국적, 생년월일, 성, 발행국

	public String getPassportnumber() {
		return Passportnumber;
	}

	public void setPassportnumber(String Passportnumber) {
		this.Passportnumber = Passportnumber;
	}
	
	public String getNationality() {
		return Nationality;
	}

	public void setNationalityD(String Nationality) {
		this.Nationality = Nationality;
	}
	
	public String getbirthday() {
		return birthday;
	}

	public void setbirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getgender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}
	
	public String getcountryofissue() {
		return countryofissue;
	}

	public void setcountryofissue(String countryofissue) {
		this.countryofissue = countryofissue;
	}
	
}
