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

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarProjeto(Projeto projeto) throws Exception {
		
		try {
			
			this.entityManager.persist(projeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Projeto");
			
		}
		
	}
	
	public void modificarProjeto(Projeto projeto) throws Exception {
		
		try {
			
			this.entityManager.merge(projeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Projeto");

		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> listarProjetos() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Projeto p ORDER BY p.id ASC");
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<Projeto>();		
			
		}
		
	}	

}
