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

import dao.PessoaJuridicaDAO;
import modelo.PessoaJuridica;

@Path("pessoajuridica")
public class PessoaJuridicaServico {
	
	@Path("/novo")
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo) {
		PessoaJuridica pessoaJuridica = new Gson().fromJson(conteudo, PessoaJuridica.class);		
		pessoaJuridica.setDataCadastro(new Date());
		pessoaJuridica.setSenha(pessoaJuridica.getSenha());
		new PessoaJuridicaDAO().inserir(pessoaJuridica);		
		URI uri = URI.create("/pessoafisica/" + pessoaJuridica.getCodigo());
		return Response.created(uri).build();
	}
	
	@Path("{codigo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("codigo") long codigo) {		
		return new PessoaJuridicaDAO().buscar(codigo).toJson();
	}	
	
	@Path("email/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("email") String email) {		
		return new PessoaJuridicaDAO().buscar(email).toJson();
	}	
	
	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar() {		
		return new Gson().toJson(new PessoaJuridicaDAO().buscar());
	}

}
