package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.CodigoPp;
import entidades.pps.Pp;

@Stateless
public class CodigoPpServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarCodigoPp(CodigoPp codigoPp, Pp pp) throws Exception {
		
		try {
			
			codigoPp.setPp(pp);
			
			this.entityManager.persist(codigoPp);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Código para o Pp");

		}		
		
	}
	
	public void modificaCodigoPp(CodigoPp codigoPp) throws Exception {
		
		try {
			
			this.entityManager.merge(codigoPp);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Código para o Pp");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CodigoPp> listarCodigoPpEspecifico(Pp pp) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM CodigoPp c WHERE c.pp =:param1");
			query.setParameter("param1", pp);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<CodigoPp>();
			
		}					
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CodigoPp> listarCodigoPP() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM CodigoPp c");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<CodigoPp>();
			
		}		
		
	}

}
