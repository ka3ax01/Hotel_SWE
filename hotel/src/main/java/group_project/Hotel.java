package group_project;

import java.util.List;

public class Hotel {
	protected String hotel_id;
	protected String name;
	protected String address;
	protected List<String> phone_numbers;
	protected String room_type;
	protected List<Room> rooms;
	protected int[] room_price;
	
	public Hotel (String hotel_id,           
                  String name,               
                  String address,            
                  List<String> phone_numbers,
                  String room_type,          
                  List<Room> rooms,          
                  int[] room_price) {
		this.hotel_id = hotel_id;
		this.name = name;
		this.address = address;
		this.phone_numbers = phone_numbers;
		this.phone_numbers = phone_numbers;
		this.room_type = room_type;
		this.rooms = rooms;
		this.room_price = room_price;
	}

	public String getHotel_id() {
		return hotel_id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public List<String> getPhone_numbers() {
		return phone_numbers;
	}

	public String getRoom_type() {
		return room_type;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public int[] getRoom_price() {
		return room_price;
	}
	
	
	
                  
}