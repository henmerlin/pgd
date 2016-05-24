package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Projeto;
import entidades.projetos.StatusProjeto;

@Stateless
public class StatusProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
		
	public StatusProjetoServico() {
		
	}
	
	public void cadastrarStatusProjeto(StatusProjeto statusProjeto) throws Exception {

		try {

			this.entityManager.persist(statusProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar StatusProjeto.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<StatusProjeto> listarStatusProjeto() {

		try {

			Query query = this.entityManager.createQuery("FROM StatusProjeto");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusProjeto>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<StatusProjeto> listarStatusProjetoEspecifico(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM StatusProjeto s WHERE s.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusProjeto>();

		}

	}

	
	
	

}
