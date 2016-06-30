package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.Prioridade;

@Stateless
public class PrioridadeServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarPrioridade(Prioridade prioridade) throws Exception {

		try {

			this.entityManager.persist(prioridade);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Prioridade");

		}

	}

	public void modificaPrioridade(Prioridade prioridade) throws Exception {

		try {

			this.entityManager.merge(prioridade);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Prioridade");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Prioridade> listarPrioridadesAtiva() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Prioridade p WHERE p.ativo =:param1 ORDER BY p.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Prioridade>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Prioridade> listarPrioridades() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Prioridade p");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Prioridade>();
			
		}
		
	}

}
