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
	
	public ImpactoProjetoServico() {
		
	}
	
	public void cadastrarImpactoProjeto(ImpactoProjeto impactoProjeto) throws Exception {

		try {

			this.entityManager.persist(impactoProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar ImpactoProjeto.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<ImpactoProjeto> listarImpactosProjetos() {

		try {

			Query query = this.entityManager.createQuery("FROM ImpactoProjeto");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ImpactoProjeto>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<ImpactoProjeto> listarImpactosProjetosEspecifico(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM ImpactoProjeto i WHERE i.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ImpactoProjeto>();

		}

	}

	

}
