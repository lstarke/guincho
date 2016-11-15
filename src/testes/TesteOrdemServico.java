package testes;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.JPAUtil;
import dao.PessoaFisicaDAO;
import modelo.Endereco;
import modelo.LocalizacaoCliente;
import modelo.OrdemServico;
import modelo.PessoaFisica;
import modelo.Veiculo;

public class TesteOrdemServico {
	
	public static void main(String[] args) {
		
		PessoaFisica pf = new PessoaFisica();
		
		pf.setCodigo(0);
		pf.setCpf("654321");
		pf.setDataCadastro(new Date());
		pf.setEmail("meu@email.com");
		pf.setNome("Rogerio");
		pf.setSobrenome("Fagundes");
		pf.setRg("555555");
		pf.setSenha("minhasenha");
		pf.setTelefone("3332065");
		
		Endereco e1 = new Endereco();
		
		e1.setCodigo(0);
		e1.setBairro("centro");
		e1.setCep(89107000);
		e1.setCidade("Pomerode");
		e1.setComplemento("casa");
		e1.setNumero(971);
		e1.setRua("Castelo Branco");
		e1.setUf("sc");
		
		pf.setEndereco(e1);
		
		Veiculo v1 = new Veiculo();
		
		v1.setCodigo(0);
		v1.setAno(2013);
		v1.setCor("branco");
		v1.setFabricante("GM");
		v1.setModelo("Chevete");
		v1.setPlaca("ABC1234");
		v1.setRenavam(99887766);
		
		pf.getVeiculos().add(v1);
		
		OrdemServico os = new OrdemServico();
		
		os.setCodigo(0);
		os.setDescricao("Guincho");
		os.setPessoaFisica(new PessoaFisicaDAO().buscar(1L));		
		os.setDataInicio(new Date());
		
		LocalizacaoCliente lc = new LocalizacaoCliente();
		
		lc.setCodigo(0);
		lc.setLat(123.5546);
		lc.setLng(78954.451);
		
		os.setLocalizacaoCliente(lc);
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		manager.merge(os);
		tx.commit();
		manager.close();
		JPAUtil.close();
		
		
		
		
	}

}
