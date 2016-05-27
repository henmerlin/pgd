package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Projeto;

@Stateless
public class ProjetoServico {
	
	@PersistenceContext(unitName="vu")  
	private EntityManager entityManager;

	public ProjetoServico() {

	}
	
	public void cadastrarProjeto(Projeto projeto) throws Exception {

		try {
			
			projeto.setConclusaoPj(0.0);

			this.entityManager.persist(projeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Projeto.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> listarProjeto() {

		try {

			Query query = this.entityManager.createQuery("FROM Projeto");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Projeto>();

		}

	}
	
	public Projeto listarProjetoEspecifico(Projeto projeto) throws Exception {

		try {

			Query query = this.entityManager.createQuery("FROM Projeto p WHERE p.id =:param1");
			query.setParameter("param1", projeto.getId());
			return (Projeto) query.getSingleResult();

		} catch (Exception e) {

			throw new Exception("Projeto nao encontrado...");

		}

	}

	

}
