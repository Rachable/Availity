package FileProcessing;

public class Customer {

	private String userID, firstName, lastName, insuranceCompany;
	private int version;
	
	public Customer(String row) {
		
		String[] cells = row.split(",");
		
		userID = cells[0];
		firstName = cells[1];
		lastName = cells[2];
		version = Integer.parseInt(cells[3]);
		insuranceCompany = cells[4];
	}
	
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public int getVersion() {
		return version;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	@Override
	public String toString() {
		return String.join(",", userID, firstName, lastName, String.valueOf(version), insuranceCompany);
	}
	
}
