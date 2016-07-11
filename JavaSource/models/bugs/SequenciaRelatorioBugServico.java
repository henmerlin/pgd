package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.SequenciaRelatorioBug;
import entidades.bugs.StatusBug;

@Stateless
public class SequenciaRelatorioBugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	
	public void cadastrarSequencia(StatusBug statusBug) throws Exception {
		
		try {
			
			SequenciaRelatorioBug sequenciaRelatorioBug = new SequenciaRelatorioBug();
			
			sequenciaRelatorioBug.setStatusBug(statusBug);
			sequenciaRelatorioBug.setAtivo(false);
			
			this.entityManager.persist(sequenciaRelatorioBug);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Sequência.");
			
		}
		
	}
	
	public void modificarSequencia(SequenciaRelatorioBug sequenciaRelatorioBug) throws Exception {
		
		try {
			
			this.entityManager.merge(sequenciaRelatorioBug);
			
		} catch (Exception e) {

			throw new Exception("Erro ao modificar Sequência");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<SequenciaRelatorioBug> listarSequencia() {
		
		try {
						
			Query query = this.entityManager.createQuery("FROM SequenciaRelatorioBug s");
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<SequenciaRelatorioBug>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<SequenciaRelatorioBug> listarSequenciaAtivo() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM SequenciaRelatorioBug s WHERE s.ativo =:param1");
			query.setParameter("param1", true);			
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<SequenciaRelatorioBug>();
			
		}
		
	}

}
