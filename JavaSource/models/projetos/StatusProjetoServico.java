package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.StatusProjeto;

@Stateless
public class StatusProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarStatusProjeto(StatusProjeto statusProjeto) throws Exception {

		try {

			List<StatusProjeto> listarDStatus = this.listarStatusProjeto();

			Integer total = listarDStatus.size();

			statusProjeto.setOrdem(total);

			this.entityManager.persist(statusProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Status");

		}

	}

	public void modificarStatusProjeto(StatusProjeto statusProjeto) throws Exception {

		try {

			List<StatusProjeto> listarDStatus = this.listarStatusProjeto();

			StatusProjeto statusProjetoEspecifico = this.listarStatusEspecifico(statusProjeto.getId());

			this.ordenarListaStatus(statusProjeto, statusProjetoEspecifico, listarDStatus);

			this.entityManager.merge(statusProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Status");

		}

	}

	@SuppressWarnings("unchecked")
	public List<StatusProjeto> listarStatusAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM StatusProjeto s WHERE s.ativo =:param1 ORDER BY s.ordem ASC");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusProjeto>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<StatusProjeto> listarStatusProjeto() {

		try {

			Query query = this.entityManager.createQuery("FROM StatusProjeto s ORDER BY s.ordem ASC");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusProjeto>();

		}

	}

	public StatusProjeto listarStatusEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM StatusProjeto s WHERE s.id =:param1");
			query.setParameter("param1", id);
			return (StatusProjeto) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

	public void ordenarListaStatus(StatusProjeto statusProjetoNovo, StatusProjeto statusProjetoAntigo, List<StatusProjeto> listaStatus) {

		if (statusProjetoNovo.getOrdem() > statusProjetoAntigo.getOrdem()) {

			for (StatusProjeto statusProjeto : listaStatus) {

				if (statusProjeto.getOrdem() > statusProjetoAntigo.getOrdem() && statusProjeto.getOrdem() <= statusProjetoNovo.getOrdem()) {

					statusProjeto.setOrdem(statusProjeto.getOrdem() - 1);

					this.entityManager.merge(statusProjeto);

				}

			}

		}

		if (statusProjetoNovo.getOrdem() < statusProjetoAntigo.getOrdem()) {

			for (StatusProjeto statusProjeto : listaStatus) {

				if (statusProjeto.getOrdem() < statusProjetoAntigo.getOrdem() && statusProjeto.getOrdem() >= statusProjetoNovo.getOrdem()) {

					statusProjeto.setOrdem(statusProjeto.getOrdem() + 1);

					this.entityManager.merge(statusProjeto);

				}

			}

		}

	}

}
