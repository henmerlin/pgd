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

			List<StatusFasePp> listaDStatus = this.listarStatusFasePp();

			Integer ultimoLista = listaDStatus.size() + 1;

			statusFasePp.setOrdem(ultimoLista);

			this.entityManager.persist(statusFasePp);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Status da Fase");

		}

	}


	public void modificarStatusFasePp(StatusFasePp statusFasePp) throws Exception {

		try {		

			List<StatusFasePp> listaDStatus = this.listarStatusFasePp();

			StatusFasePp statusFaseEspecifica = this.listaStatusFaseEspecifico(statusFasePp.getId());
			
			this.ordenarListaStatusFase(statusFasePp, statusFaseEspecifica, listaDStatus);

			this.entityManager.merge(statusFasePp);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Status da Fase");

		}

	}

	@SuppressWarnings("unchecked")
	public List<StatusFasePp> listarStatusFasePp() {

		try {
			Query query = this.entityManager.createQuery("FROM StatusFasePp s ORDER BY s.ordem ASC");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusFasePp>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<StatusFasePp> listarStatusFasePpAtivo() {

		try {
			Query query = this.entityManager.createQuery("FROM StatusFasePp s WHERE s.ativo =:param1 ORDER BY s.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusFasePp>();

		}

	}

	public StatusFasePp listaStatusFaseEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM StatusFasePp s WHERE s.id =:param1");
			query.setParameter("param1", id);
			return (StatusFasePp) query.getSingleResult();			

		} catch (Exception e) {

			return null;

		}

	}


	public void ordenarListaStatusFase(StatusFasePp statusFasePpNova, StatusFasePp statusFasePpAntiga, List<StatusFasePp> listaStatus) {

		if (statusFasePpNova.getOrdem() > statusFasePpAntiga.getOrdem()) {

			for (StatusFasePp statusFase : listaStatus) {

				if (statusFase.getOrdem() > statusFasePpAntiga.getOrdem() && statusFase.getOrdem() <= statusFasePpNova.getOrdem()) {

					statusFase.setOrdem(statusFase.getOrdem() - 1);

					this.entityManager.merge(statusFase);

				}

			}

		}	

		if (statusFasePpNova.getOrdem() < statusFasePpAntiga.getOrdem()) {

			for (StatusFasePp statusFase : listaStatus) {

				if (statusFase.getOrdem() < statusFasePpAntiga.getOrdem() && statusFase.getOrdem() >= statusFasePpNova.getOrdem()) {

					statusFase.setOrdem(statusFase.getOrdem() + 1);

					this.entityManager.merge(statusFase);

				}

			}

		}	

	}

}
