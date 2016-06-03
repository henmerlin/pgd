package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Projeto;
import entidades.projetos.Tarefa;

@Stateless
public class TarefaServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
		
	public TarefaServico() {
		
	}
	
	public void cadastrarTarefa(Tarefa tarefa) throws Exception {

		try {

			this.entityManager.persist(tarefa);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Terefa.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> listarTarefa() {

		try {

			Query query = this.entityManager.createQuery("FROM Terefa");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Tarefa>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> listarTarefaEspecifica(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM Tarefa t WHERE t.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Tarefa>();

		}

	}
	
	public void modificarTarefa(Tarefa tarefa) throws Exception {

		try {

			this.entityManager.merge(tarefa);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Terefa.");

		}

	}	

}
