package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.FaseProjeto;
import entidades.projetos.Projeto;

@Stateless
public class FaseProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
		
	public FaseProjetoServico() {
		
	}
	
	public void cadastrarFaseProjeto(FaseProjeto faseProjeto) throws Exception {

		try {

			faseProjeto.setPorcentagemConclusao(0.0);
			
			this.entityManager.persist(faseProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar FaseProjeto.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<FaseProjeto> listarFaseProjeto() {

		try {

			Query query = this.entityManager.createQuery("FROM FaseProjeto");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<FaseProjeto>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<FaseProjeto> listarFaseProjetoEspecifico(Projeto Projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM FaseProjeto f WHERE f.projeto =:param1");
			query.setParameter("param1", Projeto);
			
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<FaseProjeto>();

		}

	}
	
	public void modificarFaseProjeto(FaseProjeto faseProjeto) throws Exception {

		try {
			
			this.entityManager.merge(faseProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar FaseProjeto.");

		}

	}
		

}
