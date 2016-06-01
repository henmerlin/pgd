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

	public DataImplantacaoProjetoServico() {
		
	}
	
	public void cadastrarDataImplantacao(DataImplantacaoProjeto dataImplantacao) throws Exception {

		try {

			this.entityManager.persist(dataImplantacao);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar DataImplantacaoProjeto.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<DataImplantacaoProjeto> listarDataImplantacao() {

		try {

			Query query = this.entityManager.createQuery("FROM DataImplantacaoProjeto");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<DataImplantacaoProjeto>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<DataImplantacaoProjeto> listarDatasImplantacaoEspecifico(Projeto projeto) {

		try {
						
			Query query = this.entityManager.createQuery("FROM DataImplantacaoProjeto d WHERE d.projeto =:param1 ORDER BY d.data DESC");			
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {
			
			return new ArrayList<DataImplantacaoProjeto>();

		}

	}

}
