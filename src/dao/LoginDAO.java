package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Credencial;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;

public class LoginDAO {
	
public Credencial buscar(String email) {
		
		Credencial c = null;
		
		try {
			
			EntityManager manager = JPAUtil.getEntityManager();	
			Query query = manager.createQuery("from PessoaJuridica where email = :email");
			query.setParameter("email", email);
			
			PessoaJuridica pj = (PessoaJuridica) query.getSingleResult();
		
		
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
				
	}

}
