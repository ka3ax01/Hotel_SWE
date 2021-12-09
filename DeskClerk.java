package group_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class DeskClerk extends User {

	public void createBooking(int guest_id, int hotel_id, int room_id, Date check_in,  Date check_out ) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
        try {
        	Class.forName("org.postgresql.Driver");
            // Connect method 
        	String dbURL = String.format("jdbc:postgresql:%s?user=%s&password=%s", Database.db, Database.u, Database.pw);
            conn = DriverManager.getConnection(dbURL);
            
            String str = "select * from \"reservations\" where hotel_id = ? and room_id = ? and (check_in between ? and ? or check_out between ? and ? or ? between check_in and check_out) ;";
            
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
            rs = stmt.executeQuery("select max(res_id) as id from \"reservations\" ;");
            
            rs.next();
            int newRes_id = rs.getInt("id") + 1;
            
            
            str = "insert into \"reservations\" (guest_id, hotel_id, room_id, check_in, check_out, res_id) values (?, ?, ?, ?, ?, ?) ;";
            
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
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
        try {
        	Class.forName("org.postgresql.Driver");
            // Connect method 
        	String dbURL = String.format("jdbc:postgresql:%s?user=%s&password=%s", Database.db, Database.u, Database.pw);
            conn = DriverManager.getConnection(dbURL);
            
            String str = "delete from \"reservations\" where res_id = ? ;";
            
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, res_id);
            
            pstmt.executeUpdate();
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        try {
        	if (rs != null) rs.close();
            
            if (pstmt != null) pstmt.close();
            
            if (stmt != null) stmt.close();

            if (conn!=null) conn.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
	}
	
	public void updateBooking(int guest_id, int hotel_id, int room_id, Date check_in,  Date check_out) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
        try {
        	Class.forName("org.postgresql.Driver");
            // Connect method 
        	String dbURL = String.format("jdbc:postgresql:%s?user=%s&password=%s", Database.db, Database.u, Database.pw);
            conn = DriverManager.getConnection(dbURL);
            
            String str = "UPDATE reservations SET check_in =?, check_out =? WHERE "
            		+ "guest_id= ? AND hotel_id = ? AND room_id = ?";
    
            	pstmt = conn.prepareStatement(str);
            
    			pstmt.setDate(1, check_in);
    			pstmt.setDate(2, check_out);
    			pstmt.setInt(3, guest_id);
    			pstmt.setInt(4, hotel_id);
    			pstmt.setInt(5, room_id);
    			System.out.println("Reservation updated!");
    			pstmt.executeUpdate();
            
        }
            
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        try {
        	if (rs != null) rs.close();
            
            if (pstmt != null) pstmt.close();
            
            if (stmt != null) stmt.close();

            if (conn!=null) conn.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
	}	
}
