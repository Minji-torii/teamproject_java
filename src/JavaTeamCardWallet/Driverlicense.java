package JavaTeamCardWallet;

public class Driverlicense extends ID_card{
	private String licensenumber, conditions;
	
	public String getlicensenumber() {
		return licensenumber;
	}

	public void setlicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}
	
	public String getconditions() {
		return conditions;
	}

	public void setconditions(String conditions) {
		this.conditions = conditions;
	}
}
