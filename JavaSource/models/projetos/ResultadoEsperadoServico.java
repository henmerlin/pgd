package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Projeto;
import entidades.projetos.ResultadoEsperado;

@Stateless
public class ResultadoEsperadoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public ResultadoEsperadoServico() {
		
	}
	
	public void cadastrarResultadoEsperado(ResultadoEsperado resultadoEsperado) throws Exception {

		try {

			this.entityManager.persist(resultadoEsperado);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar ResultadoEsperado.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<ResultadoEsperado> listarResultadoEsperado() {

		try {

			Query query = this.entityManager.createQuery("FROM ResultadoEsperado");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ResultadoEsperado>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<ResultadoEsperado> listarResultadoEsperadoProjeto(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM ResultadoEsperado r WHERE r.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ResultadoEsperado>();

		}

	}	

}
