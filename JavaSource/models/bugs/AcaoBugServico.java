package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.AcaoBug;
import entidades.bugs.Bug;

@Stateless
public class AcaoBugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarAcao(AcaoBug acaoBug) throws Exception {
		
		try {
			
			this.entityManager.persist(acaoBug);
			
		} catch (Exception e) {
		
			throw new Exception("Erro ao cadastrar Acao para o Bug");
			
		}
		
	}
	
	public void modificarAcao(AcaoBug acaoBug) throws Exception {
		
		try {
			
			this.entityManager.merge(acaoBug);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Acao para o Bug");
			
		}		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<AcaoBug> listarAcaoBugsEspecifico(Bug bug) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM AcaoBug a WHERE a.bug =:param1");
			query.setParameter("param1", bug);			
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<AcaoBug>();
			
		}
		
	}

}
