package servicos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.LoginDAO;

@Path("login")
public class LoginServico {
	
	@Path("{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("email") String email) {		
		return new LoginDAO().buscar(email).toJson();
	}	
	
	

}
