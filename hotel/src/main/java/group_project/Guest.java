package group_project;

public class Guest extends User {
	
	private String id_type;
	private String id_number;
	private String mob_phone;
	private String home_phone;
	
	public Guest (String email, String name, String surname, String id_type, String id_number, String mob_phone, String home_phone) {
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.id_type = id_type;
		this.id_number = id_number;
		this.mob_phone = mob_phone;
		this.home_phone = home_phone;
	}

	public void createAccount() {
		
	}
	
	public void createBooking() {
		
	}
	
	public void cancelBooking() {
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getId_type() {
		return id_type;
	}

	public String getId_number() {
		return id_number;
	}

	public String getMob_phone() {
		return mob_phone;
	}

	public String getHome_phone() {
		return home_phone;
	}
	
}
