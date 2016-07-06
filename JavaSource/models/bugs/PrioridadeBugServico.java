package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.PrioridadeBug;

@Stateless
public class PrioridadeBugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarPrioridade(PrioridadeBug prioridadeBug) throws Exception {

		try {

			List<PrioridadeBug> listaDPrioridade = this.listarPrioridade();

			Integer total = listaDPrioridade.size() + 1;

			prioridadeBug.setOrdem(total);

			this.entityManager.persist(prioridadeBug);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Prioridade.");

		}

	}

	public void modificarPrioridade(PrioridadeBug prioridadeBug) throws Exception {

		try {
			
			List<PrioridadeBug> listaDPrioridade = this.listarPrioridade();

			PrioridadeBug prioridadeBugEspecifico = this.listarPrioridadeEspecifico(prioridadeBug.getId());

			this.ordenarListaPrioridade(prioridadeBug, prioridadeBugEspecifico, listaDPrioridade);

			this.entityManager.merge(prioridadeBug);
			
		} catch (Exception e) {
		
			throw new Exception("Erro ao modificar Prioridade");
			
		}

	}

	@SuppressWarnings("unchecked")
	public List<PrioridadeBug> listarPrioridade() {

		try {

			Query query = this.entityManager.createQuery("FROM PrioridadeBug p ORDER BY p.ordem ASC");
			return query.getResultList();


		} catch (Exception e) {

			return new ArrayList<PrioridadeBug>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<PrioridadeBug> listarPrioridadeAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM PrioridadeBug p WHERE p.ativo =:param1 ORDER BY p.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<PrioridadeBug>();

		}

	}

	public PrioridadeBug listarPrioridadeEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM PrioridadeBug p WHERE p.id =:param1");
			query.setParameter("param1", id);
			return (PrioridadeBug) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

	public void ordenarListaPrioridade(PrioridadeBug prioridadeBugNovo, PrioridadeBug prioridadeBugAntigo, List<PrioridadeBug> listPrioridade) {

		if (prioridadeBugNovo.getOrdem() > prioridadeBugAntigo.getOrdem()) {

			for (PrioridadeBug prioridadeBug : listPrioridade) {

				if (prioridadeBug.getOrdem() > prioridadeBugAntigo.getOrdem() && prioridadeBug.getOrdem() <= prioridadeBugNovo.getOrdem()) {

					prioridadeBug.setOrdem(prioridadeBug.getOrdem() - 1);

					this.entityManager.merge(prioridadeBug);

				}

			}

		}

		if (prioridadeBugNovo.getOrdem() < prioridadeBugAntigo.getOrdem()) {

			for (PrioridadeBug prioridadeBug : listPrioridade) {

				if (prioridadeBug.getOrdem() < prioridadeBugAntigo.getOrdem() && prioridadeBug.getOrdem() >= prioridadeBugNovo.getOrdem()) {

					prioridadeBug.setOrdem(prioridadeBug.getOrdem() + 1);

					this.entityManager.merge(prioridadeBug);

				}

			}

		}

	}

}
