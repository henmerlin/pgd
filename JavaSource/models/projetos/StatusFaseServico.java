package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.StatusFase;

@Stateless
public class StatusFaseServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public StatusFaseServico() {
		
	}
	
	public void cadastrarCadastrarStatusFase(StatusFase statusFase) throws Exception {

		try {

			this.entityManager.persist(statusFase);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar StatusFase.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<StatusFase> listarStatusFase() {

		try {

			Query query = this.entityManager.createQuery("FROM StatusFase");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusFase>();

		}

	}	

}
