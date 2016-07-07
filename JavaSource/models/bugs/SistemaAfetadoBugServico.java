package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.Bug;
import entidades.bugs.SistemaAfetadoBug;

@Stateless
public class SistemaAfetadoBugServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarSistemaAfetadoBug(SistemaAfetadoBug sistemaAfetadoBug, Bug bug) throws Exception {
		
		try {
			
			sistemaAfetadoBug.setBug(bug);
			
			this.entityManager.persist(sistemaAfetadoBug);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Sistema Afetado.");
			
		}		
		
	}
	
	public void modificarSistemaAfetadoBug(SistemaAfetadoBug sistemaAfetadoBug) throws Exception {
		
		try {
			
			this.entityManager.merge(sistemaAfetadoBug);
						
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Sistema Afetado.");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<SistemaAfetadoBug> listarSistemaAfetadoEspecificoBug(Bug bug) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM SistemaAfetadoBug s WHERE s.bug =:param1");
			query.setParameter("param1", bug);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<SistemaAfetadoBug>();
			
		}
		
	}

}
