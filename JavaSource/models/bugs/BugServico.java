package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.Bug;

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

}
