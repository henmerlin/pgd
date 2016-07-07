package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.Bug;
import entidades.bugs.CodigoBugDescricao;

@Stateless
public class CodigoBugDescricaoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarDescricao(CodigoBugDescricao codigoBugDescricao, Bug bug) throws Exception {
		
		try {
			
			codigoBugDescricao.setBug(bug);
			
			this.entityManager.persist(codigoBugDescricao);
			
		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Descrição.");
			
		}
		
	}
	
	public void modificarDescricao(CodigoBugDescricao codigoBugDescricao) throws Exception {
		
		try {
			
			this.entityManager.merge(codigoBugDescricao);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Descrição.");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CodigoBugDescricao> listarCodigoDescricaoBugEspecifico(Bug bug) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM CodigoBugDescricao c WHERE c.bug =:param1");
			query.setParameter("param1", bug);
			return query.getResultList();			
			
		} catch (Exception e) {
			
			return new ArrayList<CodigoBugDescricao>();
			
		}
		
	}

}
