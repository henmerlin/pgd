package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.PontosCritico;
import entidades.projetos.Projeto;

@Stateless
public class PontosCriticosServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public PontosCriticosServico() {
		
	}
	
	public void cadastrarPontosCritico(PontosCritico pontosCritico) throws Exception {

		try {

			this.entityManager.persist(pontosCritico);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar PontosCritico.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<PontosCritico> listarPontosCriticos() {

		try {

			Query query = this.entityManager.createQuery("FROM PontosCritico");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<PontosCritico>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<PontosCritico> listarPontosCriticosProjeto(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM PontosCritico p WHERE p.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<PontosCritico>();

		}

	}
			
}
