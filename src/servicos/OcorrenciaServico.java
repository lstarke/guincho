package servicos;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dao.OrdemServicoDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import modelo.OrdemServico;
import modelo.PessoaJuridica;


@Path("ocorrencia")
public class OcorrenciaServico {
	
	@Path("/novo")
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo) {
		OrdemServico os = new Gson().fromJson(conteudo, OrdemServico.class);
		os.setDataInicio(new Date());
		new OrdemServicoDAO().inserir(os);		
		URI uri = URI.create("/ocorrencia/" + os.getCodigo());
		return Response.created(uri).build();
	}
	
	@Path("{codigo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("codigo") long codigo) {		
		return new OrdemServicoDAO().buscar(codigo).toJson();
	}
	
	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar() {		
		return new Gson().toJson(new OrdemServicoDAO().buscar());
	}
	
	@Path("{codigo}/assumir/{pessoaJuridicaId}")
	@PUT
	public Response alteraPessoaJuridica(@PathParam("codigo") long codigo, @PathParam("pessoaJuridicaId") long pessoaJuridicaId) {
		OrdemServico os = new OrdemServicoDAO().buscar(codigo);
		PessoaJuridica pj = new PessoaJuridicaDAO().buscar(pessoaJuridicaId);
		os.setEmAndamento(true);
		os.setPessoaJuridica(pj);
		new OrdemServicoDAO().inserir(os);
		return Response.ok().build();
	}
	
	@Path("{codigo}/finalizar")
	@PUT
	public Response finalizarOcorrencia(@PathParam("codigo") long codigo) {
		OrdemServico os = new OrdemServicoDAO().buscar(codigo);		
		os.setEmAndamento(false);
		os.setFinalizada(true);	
		os.setDataFim(new Date());
		new OrdemServicoDAO().inserir(os);
		return Response.ok().build();
	}	
	
	

}
