package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Projeto;
import entidades.projetos.TarefaProjeto;

@Stateless
public class TarefaProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarTarefaProjeto(TarefaProjeto tarefaProjeto) throws Exception {
		
		try {
			
			this.entityManager.persist(tarefaProjeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Tarefa do Projeto");
			
		}
		
		
	}
	
	public void modificarTarefaProjeto(TarefaProjeto tarefaProjeto) throws Exception {
		
		try {
			
			this.entityManager.merge(tarefaProjeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Tarefa do Projeto");

		}
		
	}

	@SuppressWarnings("unchecked")
	public List<TarefaProjeto> listarTarefaProjetoEspecifico(Projeto projeto) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM TarefaProjeto t WHERE t.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();			
			
		} catch (Exception e) {
			
			return new ArrayList<TarefaProjeto>();

		}
		
	}
	
}
