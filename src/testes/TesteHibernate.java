package testes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import dao.JPAUtil;
import modelo.Endereco;
import modelo.PessoaFisica;
import modelo.Veiculo;

public class TesteHibernate {
	
	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Endereco e = new Endereco();
		e.setBairro("centro");
		e.setCep(99999);
		e.setCidade("Pomerode");
		e.setComplemento("posto de saude");
		e.setNumero(971);
		e.setRua("hermann weege");
		e.setUf("sc");
		
		PessoaFisica pf = new PessoaFisica();
		pf.setCpf("9898989");
		pf.setDataCadastro(new Date());
		pf.setEmail("teste@teste.com");
		pf.setEndereco(e);
		pf.setNome("Leandro");
		pf.setRg("4343434");
		pf.setSenha("4323434");
		pf.setSobrenome("Strar");
		pf.setTelefone("323323");
		
		Veiculo v1 = new Veiculo();
		v1.setAno(2013);
		v1.setCor("branco");
		v1.setFabricante("troller");
		v1.setModelo("t4");
		v1.setPlaca("kkk1234");
		v1.setRenavam(123456);
		
		Veiculo v2 = new Veiculo();
		v2.setAno(2015);
		v2.setCor("branco");
		v2.setFabricante("troller");
		v2.setModelo("t4");
		v2.setPlaca("kkk3333");
		v2.setRenavam(9898723);
		
		pf.getVeiculos().add(v1);
		pf.getVeiculos().add(v2);
		
		System.out.println(pf.toJson());
		
		manager.persist(pf);
		tx.commit();
		manager.close();
		JPAUtil.close();	
		
		
	}

}
