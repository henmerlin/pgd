package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.DataImplantacao;
import entidades.projetos.Projeto;

@Stateless
public class DataImplantacaoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public DataImplantacaoServico() {
		
	}
	
	public void cadastrarDataImplantacao(DataImplantacao dataImplantacao) throws Exception {

		try {

			this.entityManager.persist(dataImplantacao);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar DataImplantacao.");

		}

	}
	
	public void updateDataImplantacao(DataImplantacao dataImplantacao) throws Exception {

		try {

			this.entityManager.merge(dataImplantacao);

		} catch (Exception e) {

			throw new Exception("Erro ao tentar fazer o Update DataImplantacao.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<DataImplantacao> listarDatasImplantacao() {

		try {

			Query query = this.entityManager.createQuery("FROM DataImplantacao");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<DataImplantacao>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<DataImplantacao> listarDatasImplantacaoEspecifico(Projeto projeto) {

		try {
						
			Query query = this.entityManager.createQuery("FROM DataImplantacao d WHERE d.projeto =:param1 ORDER BY d.dataAlteracao DESC");			
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {
			
			return new ArrayList<DataImplantacao>();

		}

	}	

}
