package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.Bug;
import entidades.bugs.SequenciaRelatorioBug;
import entidades.bugs.StatusBug;

@Stateless
public class BugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;


	public void cadastrarBug(Bug bug) throws Exception {

		try {

			this.entityManager.persist(bug);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Bug");

		}

	}

	public void modificarBug(Bug bug) throws Exception {

		try {

			this.entityManager.merge(bug);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Bug");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Bug> listarBugs() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Bug b ORDER BY b.id ASC");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Bug>();
			
		}
		
	}
	
	public Bug listarBugEspecifico(Bug bug) throws Exception {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Bug b WHERE b.id =:param1");
			query.setParameter("param1", bug.getId());
			return (Bug) query.getSingleResult();
			
		} catch (Exception e) {
			
			throw new Exception("Id do bug não existe.");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Bug> listarBugPorFase(StatusBug statusBug) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Bug b WHERE b.statusBug =:param1");
			query.setParameter("param1", statusBug);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Bug>();
			
		}
				
	}
	
	@SuppressWarnings("unchecked")
	public List<Bug> listarBugPorStatus(List<SequenciaRelatorioBug> listaSequencia) {
		
		try {
			
			StringBuffer sequencia = new StringBuffer();
			
			Integer totalLista = listaSequencia.size();
			
			Integer count = 1;
			
			for (SequenciaRelatorioBug sequenciaRelatorioBug : listaSequencia) {
				
				String or = "";
				
				if (count != totalLista) {
					
					or = " OR ";
					
				}
				
				sequencia.append("b.statusBug.nome = '" + sequenciaRelatorioBug.getStatusBug().getNome() + "' " + or + " ");
				
				count++;
			}
			
			Query query = this.entityManager.createQuery("FROM Bug b WHERE " + sequencia);
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<Bug>();
			
		}
		
	}

}
