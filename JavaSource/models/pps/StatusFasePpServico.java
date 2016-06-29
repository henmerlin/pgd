package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.StatusFasePp;

@Stateless
public class StatusFasePpServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarStatusFasePp(StatusFasePp statusFasePp) throws Exception {

		try {

			this.entityManager.persist(statusFasePp);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Status da Fase");

		}

	}


	public void modificarStatusFasePp(StatusFasePp statusFasePp) throws Exception {

		try {

			this.entityManager.merge(statusFasePp);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Status da Fase");

		}

	}

	@SuppressWarnings("unchecked")
	public List<StatusFasePp> listarStatusFasePp() {

		try {
			Query query = this.entityManager.createQuery("FROM StatusFasePp s");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusFasePp>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<StatusFasePp> listarStatusFasePpAtivo() {

		try {
			Query query = this.entityManager.createQuery("FROM StatusFasePp s WHERE s.ativo =:param1");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusFasePp>();

		}

	}

}
