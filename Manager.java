package group_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager extends User {

	private static final String DELETE_CLEANING_SQL = "delete from cleaning where clean_id = ?;";
	private static final String INSERT_CLEANING_SQL = "INSERT INTO cleaning" +
        "  (emp_id, days, room_id, clean_id, start_clean, end_clean) VALUES " +
        " (?, ?, ?, ?, ?, ?);";

	private final String conUrl = "jdbc:postgresql:HotelChains?user=postgres&password=sugaislove93";
	public Connection dbconnect() {
	Connection dbconnect = null;

	try {
	dbconnect = DriverManager.getConnection(conUrl);
	System.out.println("You are now connected to the server");
	}catch(SQLException e){
	System.err.println(e.getMessage());
	}

	return dbconnect;
	}
	
	public static void main(String[] args) {

		Manager app = new Manager();
		app.updateClean(3, 6, "16:00", "17:00");
		app.deleteRecord();
		//app.insertRecord();
		app.showSchedule();
		}

	//Editing cleaning schedule 
	public int updateClean(int emp_id, int room_id, String start_clean, String end_clean) {
		String SQLupdate = "UPDATE cleaning "
		+ "SET start_clean = ?, end_clean = ? "
		+ "WHERE emp_id = ? AND room_id = ?";


		int rowsAffected = 0;

		try (Connection conn = dbconnect();

		PreparedStatement prepareStatement = conn.prepareStatement(SQLupdate)){
		prepareStatement.setString(1, start_clean);
		prepareStatement.setString(2, end_clean);
		prepareStatement.setInt(3, emp_id);
		prepareStatement.setInt(4, room_id);
		System.out.println("Schedule updated!");


		rowsAffected = prepareStatement.executeUpdate();
		} catch (SQLException ex) {
		System.err.println(ex.getMessage());
		}
		return rowsAffected;
		}
		
    //Displaying cleaning schedule 	
	 public void showSchedule() {
			
			  Connection conn = null;
		        try {
		            String dbURL1 = "jdbc:postgresql:HotelChains?user=postgres&password=sugaislove93";
		            conn = DriverManager.getConnection(dbURL1);
		            if (conn != null) {
		                System.out.println("Connected to database of Cleaning");
		            }
		            Statement stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery( "select * from cleaning;" );
		            while ( rs.next() ) {

		            	 Integer emp_id = rs.getInt("emp_id");
		                 String days  = rs.getString("days");
		                 String room_id  = rs.getString("room_id");
		                 String clean_id  = rs.getString("clean_id");
		                 String start_clean  = rs.getString("start_clean");
		                 String end_clean  = rs.getString("end_clean");


		                 System.out.printf( "emp_id = " + emp_id +" days = " + days+" room_id = " + room_id +" clean_id = " + clean_id +" start_clean = " + start_clean +" end_clean = " + end_clean);

		                 System.out.println();
		             }
		            rs.close();

		            stmt.close();

		            conn.close();
		        }
		        catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		        
	}
	 

	 //Inserting records in the Cleaning table 
	 public void insertRecord() {
		 System.out.println(INSERT_CLEANING_SQL);

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql:HotelChains?user=postgres&password=sugaislove93");

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLEANING_SQL)) {
        preparedStatement.setInt(1,8);
        preparedStatement.setString(2, "T,R");
        preparedStatement.setInt(3, 18);
        preparedStatement.setInt(4, 19);
        preparedStatement.setString(5, "21:00");
        preparedStatement.setString(6, "22:00");

        System.out.println("Record added!");

        
        preparedStatement.executeUpdate();
		}   catch (SQLException ex) {
        ex.printStackTrace();
    	}
	 }
	 
	//Deleting records from the Cleaning table 
	public void deleteRecord() {
	System.out.println(DELETE_CLEANING_SQL);

	try (Connection connection = DriverManager.getConnection("jdbc:postgresql:HotelChains?user=postgres&password=sugaislove93");

    PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLEANING_SQL);) {
    preparedStatement.setInt(1, 18);

    int result = preparedStatement.executeUpdate();
    System.out.println("Number of records affected :: " + result);
    System.out.println("Record deleted!");
	} catch (SQLException ex) {
        ex.printStackTrace();
    }
}
}
