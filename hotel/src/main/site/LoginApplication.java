package site;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/login")
public class LoginApplication extends Application {

	private Set < Object > singletons = new HashSet < Object >();
	private Set < Class <? > > empty = new HashSet < Class <? > >();
	
	public LoginApplication () {
	singletons.add (new Login());
	}
	@Override
	public Set < Class <? > > getClasses () {
	return empty ;
	}
	@Override
	public Set < Object > getSingletons () {
	return singletons ;
	}

}
