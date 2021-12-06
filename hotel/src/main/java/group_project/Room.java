package group_project;


public class Room {
	protected int room_no;
	protected Hotel hotel;
	protected String room_type;
	protected int size;
	protected int capacity;
	protected int floor;
	protected boolean is_occupied;
	
	public Room(int room_no, Hotel hotel, String room_type, int size, int capacity, int floor, boolean is_occupied) {
		this.room_no = room_no;
		this.hotel = hotel;
		this.room_type = room_type;
		this.size = size;
		this.capacity = capacity;
		this.floor = floor;
		this.is_occupied = is_occupied;
	}

	public int getRoom_no() {
		return room_no;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public String getRoom_type() {
		return room_type;
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getFloor() {
		return floor;
	}

	public boolean isIs_occupied() {
		return is_occupied;
	}
	
	

}
