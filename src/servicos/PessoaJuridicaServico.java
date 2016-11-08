package servicos;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import modelo.PessoaJuridica;

@Path("pessoajuridica")
public class PessoaJuridicaServico {
	
	@Path("/novo")
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo) {
		PessoaJuridica pessoaJuridica = new Gson().fromJson(conteudo, PessoaJuridica.class);		
		new PessoaJuridicaDAO().inserir(pessoaJuridica);		
		URI uri = URI.create("/pessoafisica/" + pessoaJuridica.getCodigo());
		return Response.created(uri).build();
	}

}
