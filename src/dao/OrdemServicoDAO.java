package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.google.gson.JsonElement;

import modelo.OrdemServico;
import modelo.PessoaFisica;
import servicos.OcorrenciaServico;

public class OrdemServicoDAO {
	
	public void inserir(OrdemServico os) {		
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();		
		
		tx.begin();		
		
		manager.merge(os);
		
		tx.commit();
		
	}

	public OrdemServico buscar(long id) {
		
			
			OrdemServico os = null;
			
			try {
				
				EntityManager manager = JPAUtil.getEntityManager();			
				
				os = manager.find(OrdemServico.class, id);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return (OrdemServico) os;	
		
	}
	
	public List<OrdemServico> buscar() {
		
		List<OrdemServico> listaOS = null;
		
		try {
			
			EntityManager manager = JPAUtil.getEntityManager();			
			Query query = manager.createQuery("from OrdemServico");
			
			listaOS = query.getResultList();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaOS;
				
	}



}
