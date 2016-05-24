package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.AcoesMinImpacto;
import entidades.projetos.Projeto;

@Stateless
public class AcoesMinImpactoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public AcoesMinImpactoServico() {
		
	}
	
	public void cadastrarAcoesMinImpacto(AcoesMinImpacto acoesMinImpacto) throws Exception {

		try {

			this.entityManager.persist(acoesMinImpacto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar AcoesMinImpacto.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<AcoesMinImpacto> listarAcoesMinImpactos() {

		try {

			Query query = this.entityManager.createQuery("FROM AcoesMinImpacto");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<AcoesMinImpacto>();

		}

	}	
	
	@SuppressWarnings("unchecked")
	public List<AcoesMinImpacto> listarAcoesMinImpactosProjeto(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM AcoesMinImpacto a WHERE a.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<AcoesMinImpacto>();

		}

	}

}
