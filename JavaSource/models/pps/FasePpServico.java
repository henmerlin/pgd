package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.FasePp;

@Stateless
public class FasePpServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarFase(FasePp fasePp) throws Exception {

		try {

			this.entityManager.persist(fasePp);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar a Fase");

		}

	}

	public void modificarFase(FasePp fasePp) throws Exception {

		try {

			this.entityManager.merge(fasePp);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar a Fase");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<FasePp> listarFasePpAtivo() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM FasePp f WHERE f.ativo =:param1");
			query.setParameter("param1", true);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<FasePp>();
			
		}
		
	}
	
}
