package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Credencial;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;
import modelo.TipoPessoaEnum;

public class LoginDAO {
	
public Credencial buscar(String email) {
		
		Credencial c = null;
		List<PessoaJuridica> listaPJ = null;
		List<PessoaFisica> listaPF = null;
		
		try {
			
			EntityManager manager = JPAUtil.getEntityManager();	
			
			Query queryPJ = manager.createQuery("from PessoaJuridica where email = :email", PessoaJuridica.class);
			queryPJ.setParameter("email", email);
			
			listaPJ = queryPJ.getResultList();
			
			Query queryPF = manager.createQuery("from PessoaFisica where email = :email", PessoaFisica.class);
			queryPF.setParameter("email", email);
			
			listaPF = queryPF.getResultList();
			
			if (!listaPF.isEmpty()) {
				
				c = new Credencial();
				
				c.setEmail(listaPF.get(0).getEmail());
				c.setSenha(listaPF.get(0).getSenha());
				c.setTipoPessoa(TipoPessoaEnum.PESSOA_FISICA);
				
			} else {
				if (!listaPJ.isEmpty()) {
					
					c = new Credencial();
					
					c.setEmail(listaPJ.get(0).getEmail());
					c.setSenha(listaPJ.get(0).getSenha());
					c.setTipoPessoa(TipoPessoaEnum.PESSOA_JURIDICA);
					
				}
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
		
				
	}

}
