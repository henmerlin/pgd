package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.FaseProjeto;
import entidades.projetos.StatusFaseProjeto;

@Stateless
public class StatusFaseProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public StatusFaseProjetoServico() {
		
	}
	
	public void cadastrarStatusFaseProjeto(StatusFaseProjeto statusFaseProjeto) throws Exception {
		
		try {

			this.entityManager.persist(statusFaseProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar StatusFaseProjetoServico.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<StatusFaseProjeto> listarStatusFaseProjeto() {

		try {

			Query query = this.entityManager.createQuery("FROM StatusFaseProjeto");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusFaseProjeto>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<StatusFaseProjeto> listarStatusFaseProjetoEspecifico(FaseProjeto faseProjeto) {

		try {

			Query query = this.entityManager.createQuery("FROM StatusFaseProjeto s WHERE s.faseProjeto =:param1 ORDER BY s.dataModStatus DESC");
			query.setParameter("param1", faseProjeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusFaseProjeto>();

		}

	}
	
}
