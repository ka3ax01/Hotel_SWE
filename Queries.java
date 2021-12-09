package group_project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.Gson;

import java.sql.ResultSet;

public class Queries {

	public static void main(String[] args) throws Exception {
        Guest newGuy = new Guest("user.one@gmail.com", "123456");
        System.out.println(newGuy.doesExist());
        newGuy.createAccount();
        Date check_in = Date.valueOf("2021-12-13");
        Date check_out = Date.valueOf("2021-12-14");
        newGuy.createBooking(1, 1, check_in, check_out);
        newGuy.cancelBooking(10004);
	}

}
