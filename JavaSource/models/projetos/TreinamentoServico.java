package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Projeto;
import entidades.projetos.Treinamento;

@Stateless
public class TreinamentoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

		
	public TreinamentoServico() {
		
	}
	
	public void cadastrarTreinamento(Treinamento treinamento) throws Exception {

		try {

			this.entityManager.persist(treinamento);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Treinamento.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Treinamento> listarTreinamento() {

		try {

			Query query = this.entityManager.createQuery("FROM Treinamento");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Treinamento>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Treinamento> listarTreinamentoProjeto(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM Treinamento t WHERE t.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Treinamento>();

		}

	}

	

	

}
