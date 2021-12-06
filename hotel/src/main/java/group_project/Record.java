package group_project;

import java.util.List;

public class Record {
	
	protected Hotel hotel;
	protected List<Booking> record;
	public Record(Hotel hotel, List<Booking> record) {
		this.hotel = hotel;
		this.record = record;
	}

}
