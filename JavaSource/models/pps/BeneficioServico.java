package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.Beneficio;

@Stateless
public class BeneficioServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarBeneficio(Beneficio beneficio) throws Exception {
		
		try {
			
			this.entityManager.persist(beneficio);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Beneficio");
			
		}
		
	}
	
	public void modificarBeneficio(Beneficio beneficio) throws Exception {
		
		try {
			
			this.entityManager.merge(beneficio);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Beneficio");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Beneficio> listarBeneficiosAtivos() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Beneficio b WHERE b.ativo =:param1");
			query.setParameter("param1", true);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Beneficio>();
			
		}
		
	}
	
}
