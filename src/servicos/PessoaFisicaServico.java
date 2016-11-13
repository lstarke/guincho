package servicos;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dao.PessoaFisicaDAO;
import modelo.PessoaFisica;

@Path("pessoafisica")
public class PessoaFisicaServico {
	
	@Path("/novo")
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo) {
		PessoaFisica pessoaFisica = new Gson().fromJson(conteudo, PessoaFisica.class);
		pessoaFisica.setDataCadastro(new Date());
		System.out.println(pessoaFisica.getNome());
		new PessoaFisicaDAO().inserir(pessoaFisica);		
		URI uri = URI.create("/pessoafisica/" + pessoaFisica.getCodigo());
		return Response.created(uri).build();
	}
	
	@Path("{codigo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("codigo") long codigo) {		
		return new PessoaFisicaDAO().buscar(codigo).toJson();
	}	
	
	@Path("email/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("email") String email) {		
		return new PessoaFisicaDAO().buscar(email).toJson();
	}	
	
	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar() {		
		return new Gson().toJson(new PessoaFisicaDAO().buscar());
	}

}
