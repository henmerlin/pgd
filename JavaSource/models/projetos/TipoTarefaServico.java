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
	
	public TipoTarefaServico() {
		
	}
	
	public void cadastrarTipoTarefa(TipoTarefa tipoTarefa) throws Exception {

		try {

			this.entityManager.persist(tipoTarefa);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar TipoTarefa.");

		}

	}
	
	public void modificarTipoTarefa(TipoTarefa tipoTarefa) throws Exception {

		try {

			this.entityManager.merge(tipoTarefa);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar TipoTarefa.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<TipoTarefa> listarTipoTarefa() {

		try {

			Query query = this.entityManager.createQuery("FROM TipoTarefa");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<TipoTarefa>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<TipoTarefa> listarTipoTarefaAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM TipoTarefa t WHERE t.ativo =:param1");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<TipoTarefa>();

		}

	}
}
