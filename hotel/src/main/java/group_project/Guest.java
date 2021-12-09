package group_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class Guest extends User {
	
	private String id_type;
	private String id_number;
	private String mob_phone;
	private String home_phone;
	
	public Guest (String email, String password) {
		this.email = email;
		this.password = password;
	}

	public boolean doesExist() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
        try {
            // Connect method 
        	Class.forName("org.postgresql.Driver");
            String dbURL = String.format("jdbc:postgresql:%s?user=%s&password=%s", Database.db, Database.u, Database.pw);
            conn = DriverManager.getConnection(dbURL);
            
            String str = "select email from \"Users\" where email = ?;";
            
            pstmt = conn.prepareStatement(str);
            pstmt.setString(1, email);
            
            rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {
            	try {
                	if (rs != null)rs.close();
                    
                    if (pstmt != null) pstmt.close();

                    if (conn!=null) conn.close();
                }
                catch (SQLException ex) {
                	
                } 
                
                return true;
            }
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
        	
        }
        try {
        	if (rs != null)rs.close();
            
            if (pstmt != null) pstmt.close();

            if (conn!=null) conn.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return false;
		
	}
	
	public boolean login() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
        try {
            // Connect method 
        	Class.forName("org.postgresql.Driver");
            String dbURL = String.format("jdbc:postgresql:%s?user=%s&password=%s", Database.db, Database.u, Database.pw);
            conn = DriverManager.getConnection(dbURL);
            
            String str = "select U.email from \"Users\" U, \"Guest\" G where U.email = ? and U.\"Password\" = ? and U.email = G.email;";
            
            pstmt = conn.prepareStatement(str);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            
            rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {
            	try {
                	if (rs != null)rs.close();
                    
                    if (pstmt != null) pstmt.close();

                    if (conn!=null) conn.close();
                }
                catch (SQLException ex) {
                	
                } 
                
                return true;
            }
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
        	
        }
        try {
        	if (rs != null)rs.close();
            
            if (pstmt != null) pstmt.close();

            if (conn!=null) conn.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return false;
		
	}
	
	public void createAccount( 
			String name, String surname,
			String id_type, String id_no,
			String address, String hphone,
			String mobile_number) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
        try {
        	Class.forName("org.postgresql.Driver");
            // Connect method 
            String dbURL = String.format("jdbc:postgresql:%s?user=%s&password=%s", Database.db, Database.u, Database.pw);
            conn = DriverManager.getConnection(dbURL);
            
            String str = "insert into \"Users\" (email, \"Name\", \"Surname\", \"Password\") values (?, ?, ?, ?) ;";
            
            pstmt = conn.prepareStatement(str);
            pstmt.setString(1, email);
            pstmt.setString(2, name);
            pstmt.setString(3, surname);
            pstmt.setString(4, password);
            
            pstmt.executeUpdate();
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select max(guest_id) as id from \"Guest\" ;");
            
            rs.next();
            int newGuest_id = rs.getInt("id") + 1;
            
            str = "insert into \"Guest\" (guest_id, id_type, number, address, hphone_number, mobile_number, email) values (?, ?, ?, ?, ?, ?, ?) ;";
            
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, newGuest_id);
            pstmt.setString(2, id_type);
            pstmt.setString(3, id_no);
            pstmt.setString(4, address);
            pstmt.setString(5, hphone);
            pstmt.setString(6, mobile_number);
            pstmt.setString(7, email);
            
            pstmt.executeUpdate();
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        try {
        	if (rs != null)rs.close();
            
            if (pstmt != null) pstmt.close();
            
            if (stmt != null) stmt.close();

            if (conn!=null) conn.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
	}
	
	public List<String> showBookings() {
		Connection conn = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		List<String> booking = new ArrayList<String>();
		try {
        	Class.forName("org.postgresql.Driver");
            // Connect method 
        	String dbURL = String.format("jdbc:postgresql:%s?user=%s&password=%s", Database.db, Database.u, Database.pw);
            conn = DriverManager.getConnection(dbURL);
            
            String str = "select guest_id from \"Guest\" where email = ? ;";
            pstmt = conn.prepareStatement(str);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            
            rs.next();
            int guest_id = rs.getInt("guest_id");
            
            str = "select * from \"Reservations\" where guest_id = ? ;";
            
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, guest_id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	str = "select name from \"Hotel\" where hotel_id = ? ;";
            	pstmt = conn.prepareStatement(str);
                pstmt.setInt(1, rs.getInt("hotel_id"));
                rs1 = pstmt.executeQuery();
                rs1.next();
                String hotel = rs1.getString("name");
                
                str = "select \"room number\" from \"Room\" where hotel_id = ? and room_id = ? ;";
            	pstmt = conn.prepareStatement(str);
                pstmt.setInt(1, rs.getInt("hotel_id"));
                pstmt.setInt(2, rs.getInt("room_id"));
                rs1 = pstmt.executeQuery();
                rs1.next();
                String room = rs1.getString("room number");
                
            	str = "Hotel: " + hotel + " Room number: " + room + " Check in: " + rs.getDate("check_in") + " Check out: " + rs.getDate("check_out");
            	booking.add(str);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception ex) {
        	System.out.println("Cannot book");
        }
        try {
        	if (rs != null)rs.close();
        	
        	if (rs1 != null)rs.close();
            
            if (pstmt != null) pstmt.close();
            
            if (conn!=null) conn.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return booking;
	}
	
	public void createBooking(int hotel_id, int room_id, Date check_in, Date check_out ) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
        try {
        	Class.forName("org.postgresql.Driver");
            // Connect method 
        	String dbURL = String.format("jdbc:postgresql:%s?user=%s&password=%s", Database.db, Database.u, Database.pw);
            conn = DriverManager.getConnection(dbURL);
            
            String str = "select * from \"Reservations\" where hotel_id = ? and room_id = ? and (check_in between ? and ? or check_out between ? and ? or ? between check_in and check_out) ;";
            
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, hotel_id);
            pstmt.setInt(2, room_id);
            pstmt.setDate(3, check_in);
            pstmt.setDate(4, check_out);
            pstmt.setDate(5, check_in);
            pstmt.setDate(6, check_out);
            pstmt.setDate(7, check_in);
            
            
            rs = pstmt.executeQuery();
            if(rs.isBeforeFirst()) {
            	throw new Exception();
            }
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select max(res_id) as id from \"Reservations\" ;");
            
            rs.next();
            int newRes_id = rs.getInt("id") + 1;
            
            str = "select guest_id from \"Guest\" where email = ? ;";
            pstmt = conn.prepareStatement(str);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            
            rs.next();
            int guest_id = rs.getInt("guest_id");
            
            str = "insert into \"Reservations\" (guest_id, hotel_id, room_id, check_in, check_out, res_id) values (?, ?, ?, ?, ?, ?) ;";
            
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, guest_id);
            pstmt.setInt(2, hotel_id);
            pstmt.setInt(3, room_id);
            pstmt.setDate(4, check_in);
            pstmt.setDate(5, check_out);
            pstmt.setInt(6, newRes_id);
            
            pstmt.executeUpdate();
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception ex) {
        	System.out.println("Cannot book");
        }
        try {
        	if (rs != null)rs.close();
            
            if (pstmt != null) pstmt.close();
            
            if (stmt != null) stmt.close();

            if (conn!=null) conn.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
	}
	
	public void cancelBooking(int res_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
        try {
        	Class.forName("org.postgresql.Driver");
            // Connect method 
        	String dbURL = String.format("jdbc:postgresql:%s?user=%s&password=%s", Database.db, Database.u, Database.pw);
            conn = DriverManager.getConnection(dbURL);
            
            String str = "delete from \"Reservations\" where res_id = ? ;";
            
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, res_id);
            
            pstmt.executeUpdate();
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        try {
            
            if (pstmt != null) pstmt.close();
            
            if (conn!=null) conn.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
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
