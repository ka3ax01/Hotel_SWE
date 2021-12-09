package site;

import group_project.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/items")
public class Login {

	private String user;
	private String password;
	private String log = "b";

	public Login() {
		
	}
	
	@GET
	public Response hello() {
		Gson gson = new Gson();
		Login abc = new Login();
		abc.user = this.user;
		abc.password = this.password;
		abc.log = this.log;
		return Response.ok(gson.toJson(abc)).build();
	}
	
	@POST
	public Response log(@FormParam("user") String user, @FormParam("password") String password) { 
		Guest guest = new Guest(user, password);
		boolean exist = guest.login();
		this.user = user;
		this.password = password;
		if (exist == true) {
			log = "a";
		}
		else log = "b";
		return Response.ok().build();
		
	}

}
