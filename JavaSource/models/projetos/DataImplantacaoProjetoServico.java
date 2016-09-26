package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.DataImplantacaoProjeto;
import entidades.projetos.Projeto;

@Stateless
public class DataImplantacaoProjetoServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarDataImplantacaoProjeto(DataImplantacaoProjeto dataImplantacaoProjeto, Projeto projeto) throws Exception {
		
		try {
			
			dataImplantacaoProjeto.setProjeto(projeto);
			
			this.entityManager.persist(dataImplantacaoProjeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Data de Implantacao do Projeto");

		}
		
	}
	
	public void modificarDataImplantacaoProjeto(DataImplantacaoProjeto dataImplantacaoProjeto) throws Exception {
		
		try {
			
			this.entityManager.merge(dataImplantacaoProjeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Data de Implantacao do Projeto");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<DataImplantacaoProjeto> listarDataImplantacaoProjetoEspecificoProjeto(Projeto projeto) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM DataImplantacaoProjeto d WHERE d.projeto =:param1 ORDER BY d.dataImplantacao ASC");
			query.setParameter("param1", projeto);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<DataImplantacaoProjeto>();

		}
		
	}

}
