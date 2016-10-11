package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.ImpactoProjeto;
import entidades.projetos.Projeto;

@Stateless
public class ImpactoProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarImpactoProjeto(ImpactoProjeto impactoProjeto, Projeto projeto) throws Exception {

		try {

			impactoProjeto.setProjeto(projeto);

			this.entityManager.persist(impactoProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Impacto para Projeto");

		}

	}

	public void modificarImpactoProjeto(ImpactoProjeto impactoProjeto) throws Exception {

		try {

			this.entityManager.merge(impactoProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Impacto do Projeto");

		}

	}

	@SuppressWarnings("unchecked")
	public List<ImpactoProjeto> listarImpactoProjetoEspecifico(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM ImpactoProjeto i WHERE i.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ImpactoProjeto>();

		}

	}

	public ImpactoProjeto listarImpactoProjetoEspecificoUnic(Projeto projeto) throws Exception {

		try {

			Query query = this.entityManager.createQuery("FROM ImpactoProjeto i WHERE i.projeto =:param1 ORDER BY i.id DESC");
			query.setMaxResults(1);
			query.setParameter("param1", projeto);
			return (ImpactoProjeto) query.getSingleResult();

		} catch (Exception e) {

			throw new Exception("Este projeto nao possui impactos cadastrados.");

		}

	}


}
