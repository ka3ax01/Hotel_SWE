package group_project;

import java.util.List;
import java.sql.Date;

public class Booking {
	
	protected Hotel hotel;
	protected int room_no;
	protected String person_booked;
	protected List<String> people_occupied;
	protected Date check_in;
	protected Date check_out;
	protected int price;

	public Booking(Hotel hotel, 
					int room_no, 
					String person_booked, 
					List<String> people_occupied, 
					Date check_in, 
					Date check_out,
					int price) {
		
		this.hotel = hotel;
		this.room_no = room_no;
		this.person_booked = person_booked;
		this.people_occupied = people_occupied;
		this.check_in = check_in;
		this.check_out = check_out;
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public int getRoom_no() {
		return room_no;
	}

	public String getPerson_booked() {
		return person_booked;
	}

	public List<String> getPeople_occupied() {
		return people_occupied;
	}

	public Date getCheck_in() {
		return check_in;
	}

	public Date getCheck_out() {
		return check_out;
	}

	public int getPrice() {
		return price;
	}
	
	

}
