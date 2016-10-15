package servicos;

import java.net.URI;

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
		System.out.println(pessoaFisica.getNome());
		new PessoaFisicaDAO().inserir(pessoaFisica);
		URI uri = URI.create("/pessoafisica/" + pessoaFisica.getCodigo());
		return Response.created(uri).build();
	}
	
	/*@Path("{codigo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("codigo") long codigo) {		
		return new PessoaFisicaDAO().busca(codigo).toJson();
	}*/	

}
