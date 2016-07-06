package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.StatusBug;

@Stateless
public class StatusBugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarStatus(StatusBug statusBug) throws Exception {

		try {

			List<StatusBug> listaDStatus = this.listarStatus();
			
			Integer total = listaDStatus.size() + 1;
			
			statusBug.setOrdem(total);
			
			this.entityManager.persist(statusBug);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Status");

		}

	}

	public void modificarStatus(StatusBug statusBug) throws Exception {

		try {

			List<StatusBug> listaDStatus = this.listarStatus();
			
			StatusBug statusBugEspecifico = this.listarStatusEspecifico(statusBug.getId());

			this.ordenarListaStatus(statusBug, statusBugEspecifico, listaDStatus);
			
			this.entityManager.merge(statusBug);
			
		} catch (Exception e) {

			throw new Exception("Erro ao modificar Status");

		}

	}


	@SuppressWarnings("unchecked")
	public List<StatusBug> listarStatus() {

		try {

			Query query = this.entityManager.createQuery("FROM StatusBug s ORDER BY s.ordem ASC");			
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusBug>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<StatusBug> listarStatusAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM StatusBug s WHERE s.ativo =:param1 ORDER BY s.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusBug>();

		}

	}
	
	public StatusBug listarStatusEspecifico(Integer id) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM StatusBug s WHERE s.id =:param1 ORDER BY s.ordem ASC");
			query.setParameter("param1", id);
			return (StatusBug) query.getSingleResult();
			
		} catch (Exception e) {
			
			return null;
			
		}
		
	}

	public void ordenarListaStatus(StatusBug statusBugNovo, StatusBug statusBugAntigo, List<StatusBug> listaStatus) {

		if (statusBugNovo.getOrdem() > statusBugAntigo.getOrdem()) {

			for (StatusBug statusBug : listaStatus) {

				if (statusBug.getOrdem() > statusBugAntigo.getOrdem() && statusBug.getOrdem() <= statusBugNovo.getOrdem()) {

					statusBug.setOrdem(statusBug.getOrdem() - 1);

					this.entityManager.merge(statusBug);

				}

			}

		}

		if (statusBugNovo.getOrdem() < statusBugAntigo.getOrdem()) {

			for (StatusBug statusBug : listaStatus) {

				if (statusBug.getOrdem() < statusBugAntigo.getOrdem() && statusBug.getOrdem() >= statusBugNovo.getOrdem()) {

					statusBug.setOrdem(statusBug.getOrdem() + 1);

					this.entityManager.merge(statusBug);

				}

			}

		}

	}

}
