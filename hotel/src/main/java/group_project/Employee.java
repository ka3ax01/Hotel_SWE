package group_project;

public class Employee extends User {
	
	protected String employee_id;
	protected Hotel hotel;
	protected int salary;
	protected String mob_phone;
	
	protected Employee(String email, String name, String surname, String employee_id, Hotel hotel, int salary, String mob_phone) {
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.employee_id = employee_id;
		this.hotel = hotel;
		this.salary = salary;
		this.mob_phone = mob_phone;
		
	}
}
