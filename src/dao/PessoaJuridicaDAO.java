package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import modelo.PessoaJuridica;

public class PessoaJuridicaDAO {
	
public void inserir(PessoaJuridica p) {		
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		manager.persist(p);		
		
		tx.commit();
		manager.close();
		JPAUtil.close();	
		
	}

}
