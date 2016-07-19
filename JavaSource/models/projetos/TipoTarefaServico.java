package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.TipoTarefa;

@Stateless
public class TipoTarefaServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarTipoTarefa(TipoTarefa tipoTarefa) throws Exception {

		try {

			List<TipoTarefa> listarDTarefa = this.listarTipoTarefa();

			Integer total = listarDTarefa.size() + 1;

			tipoTarefa.setOrdem(total);

			this.entityManager.persist(tipoTarefa);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Tarefa");

		}		

	}

	public void modificarTarefa(TipoTarefa tipoTarefa) throws Exception {

		try {

			List<TipoTarefa> listarDTarefa = this.listarTipoTarefa();

			TipoTarefa tipoTarefaEspecifico = this.listarTipoTarefaEspecifico(tipoTarefa.getId());

			this.ordenarListaTarefa(tipoTarefa, tipoTarefaEspecifico, listarDTarefa);

			this.entityManager.merge(tipoTarefa);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Tarefa");

		}

	}

	@SuppressWarnings("unchecked")
	public List<TipoTarefa> listarTipoTarefa() {

		try {

			Query query = this.entityManager.createQuery("FROM TipoTarefa t ORDER BY t.ordem ASC");			
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<TipoTarefa>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<TipoTarefa> listarTipoTarefaAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM TipoTarefa t WHERE t.ativo =:param1 ORDER BY t.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<TipoTarefa>();

		}

	}

	public TipoTarefa listarTipoTarefaEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM TipoTarefa t WHERE t.id =:param1");
			query.setParameter("param1", id);
			return (TipoTarefa) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

	public void ordenarListaTarefa(TipoTarefa tipoTarefaNovo, TipoTarefa tipoTarefaAntigo, List<TipoTarefa> listaTarefa) {

		if (tipoTarefaNovo.getOrdem() > tipoTarefaAntigo.getOrdem()) {

			for (TipoTarefa tipoTarefa : listaTarefa) {

				if (tipoTarefa.getOrdem() > tipoTarefaAntigo.getOrdem() && tipoTarefa.getOrdem() <= tipoTarefaNovo.getOrdem()) {

					tipoTarefa.setOrdem(tipoTarefa.getOrdem() - 1);

					this.entityManager.merge(tipoTarefa);

				}

			}

		}

		if (tipoTarefaNovo.getOrdem() < tipoTarefaAntigo.getOrdem()) {

			for (TipoTarefa tipoTarefa : listaTarefa) {

				if (tipoTarefa.getOrdem() > tipoTarefaAntigo.getOrdem() && tipoTarefa.getOrdem() >= tipoTarefaNovo.getOrdem()) {

					tipoTarefa.setOrdem(tipoTarefa.getOrdem() + 1);

					this.entityManager.merge(tipoTarefa);

				}

			}

		}

	}

}
