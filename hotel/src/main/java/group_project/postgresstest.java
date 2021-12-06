package group_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class postgresstest {
	public static void main(String[] args) {
        // create three connections to three different databases on localhost
        Connection conn = null;
        try {
            // Connect method 
            String dbURL1 = "jdbc:postgresql:exam?user=postgres&password=11111";
            conn = DriverManager.getConnection(dbURL1);
            if (conn != null) {
                System.out.println("Connected to database #1");
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from country ;" );
            while ( rs.next() ) {

                String  cname = rs.getString("cname");

                long pop  = rs.getInt("population");

                System.out.printf( "Country = " + cname + "Population = " + pop );

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
}
