package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import modelo.PessoaFisica;

public class PessoaFisicaDAO  {
	
	public void inserir(PessoaFisica p) {		
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();		
		
		tx.begin();
		
		//manager.persist(p);
		manager.merge(p);
		
		tx.commit();
		//manager.close();
		//JPAUtil.close();	
		
	}
	
	public PessoaFisica buscar(long id) {
		
		PessoaFisica p = null;
		
		try {
			
			EntityManager manager = JPAUtil.getEntityManager();			
			
			p =  manager.find(PessoaFisica.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (PessoaFisica) p;
				
	}
	
	public PessoaFisica buscar(String email) {
		
		PessoaFisica p = null;
		
		try {
			
			EntityManager manager = JPAUtil.getEntityManager();	
			Query query = manager.createQuery("from PessoaFisica where email = :email");
			query.setParameter("email", email);
			
			p = (PessoaFisica) query.getSingleResult();
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
				
	}
	
	public List<PessoaFisica> buscar() {
		
		List<PessoaFisica> listaPessoaFisica = null;
		
		try {
			
			EntityManager manager = JPAUtil.getEntityManager();			
			Query query = manager.createQuery("from PessoaFisica");
			
			listaPessoaFisica = query.getResultList();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaPessoaFisica;
				
	}

}
