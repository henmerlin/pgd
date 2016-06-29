package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.Pp;

@Stateless
public class PpServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarPp(Pp pp) throws Exception {
		
		try {
			
			this.entityManager.persist(pp);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Pp");
			
		}
		
	}
	
	
	public void modificarPp(Pp pp) throws Exception {
		
		try {
			
			this.entityManager.merge(pp);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Pp");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Pp> listarPp() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Pp p ORDER BY p.id ASC");
			
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Pp>();
			
		}
		
	}
	
	public Pp listarPpEspecifico(Pp pp) throws Exception {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Pp p WHERE p.id =:param1");
			query.setParameter("param1", pp.getId());
			return (Pp) query.getSingleResult();
			
		} catch (Exception e) {
			
			throw new Exception("Pp não encontrado.");
			
		}
		
	}
}
