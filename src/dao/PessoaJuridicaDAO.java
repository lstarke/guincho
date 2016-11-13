package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import modelo.PessoaFisica;
import modelo.PessoaJuridica;

public class PessoaJuridicaDAO {
	
public void inserir(PessoaJuridica p) {		
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		manager.merge(p);		
		
		tx.commit();
		manager.close();
		//JPAUtil.close();	
		
	}

public PessoaJuridica buscar(long id) {
	
	PessoaJuridica p = null;
	
	try {
		
		EntityManager manager = JPAUtil.getEntityManager();			
		
		p =  manager.find(PessoaJuridica.class, id);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return (PessoaJuridica) p;
			
}

public PessoaJuridica buscar(String email) {
	
	PessoaJuridica p = null;
	
	try {
		
		EntityManager manager = JPAUtil.getEntityManager();	
		Query query = manager.createQuery("from PessoaJuridica where email = :email");
		query.setParameter("email", email);
		
		p = (PessoaJuridica) query.getSingleResult();
		
					
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return p;
			
}

public List<PessoaJuridica> buscar() {
	
	List<PessoaJuridica> listaPessoaJuridica = null;
	
	try {
		
		EntityManager manager = JPAUtil.getEntityManager();			
		Query query = manager.createQuery("from PessoaJuridica");
		
		listaPessoaJuridica = query.getResultList();			
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return listaPessoaJuridica;
			
}

}
