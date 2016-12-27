package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.CodigoBug;

@Stateless
public class CodigoBugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarCodigoBug(CodigoBug codigoBug) throws Exception {
		
		try {
			
			this.entityManager.persist(codigoBug);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Código.");
			
		}		
		
	}
	
	public void modificarCodigoBug(CodigoBug codigoBug) throws Exception {
		
		try {
			
			this.entityManager.merge(codigoBug);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Código.");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CodigoBug> listarCodigoBug() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM CodigoBug c");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<CodigoBug>();
			
		}
		
	}

}
