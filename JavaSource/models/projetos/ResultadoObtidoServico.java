package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Projeto;
import entidades.projetos.ResultadoObtido;

@Stateless
public class ResultadoObtidoServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public ResultadoObtidoServico() {
		
	}
	
	public void cadastrarResultadoObtido(ResultadoObtido resultadoObtido) throws Exception {

		try {

			this.entityManager.persist(resultadoObtido);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar ResultadoObtido.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<ResultadoObtido> listarResultadoObtido() {

		try {

			Query query = this.entityManager.createQuery("FROM ResultadoObtido");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ResultadoObtido>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<ResultadoObtido> listarResultadoObtidoProjeto(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM ResultadoObtido r WHERE r.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ResultadoObtido>();

		}

	}

}
