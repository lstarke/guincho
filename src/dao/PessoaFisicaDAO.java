package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import modelo.PessoaFisica;

public class PessoaFisicaDAO {
	
	public void inserir(PessoaFisica p) {		
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		manager.persist(p);		
		
		tx.commit();
		manager.close();
		JPAUtil.close();	
		
	}

}
