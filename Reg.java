package site;

import group_project.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/items")
public class Reg {
	
	private String user;
	private String password;
	private String reg = "b";
	
	public Reg() {
		
	}
	
	@GET
	public Response Hello() {
		Gson gson = new Gson();
		Reg abc = new Reg();
		abc.user = this.user;
		abc.password = this.password;
		abc.reg = this.reg;
		return Response.ok(gson.toJson(abc)).build();
	}
	
	@POST
	public Response create(@FormParam("user") String user, @FormParam("password") String password, 
			@FormParam("name") String name, @FormParam("surname") String surname,
			@FormParam("id_type") String id_type, @FormParam("id_no") String id_no,
			@FormParam("address") String address, @FormParam("home_number") String hphone,
			@FormParam("mobile_number") String mobile_number) {
		if (user.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty() || id_type.isEmpty() ||id_no.isEmpty()) {
			reg = "b";
			return Response.ok().build();
		}
		Guest guest = new Guest(user, password);
		boolean exist = guest.doesExist();
		if (exist == true) {
			reg = "b";
			return Response.ok().build();
		}
		else {
			try {
				guest.createAccount(name, surname, id_type, id_no, address, hphone, mobile_number);
				reg = "a";
			} catch (Exception e) {
				reg = "b";
				e.printStackTrace();
			}
		}
		return Response.ok().build();
	}

}
