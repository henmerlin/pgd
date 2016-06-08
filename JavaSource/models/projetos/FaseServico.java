package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Fase;

@Stateless
public class FaseServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public FaseServico() {
		
	}
	
	public void cadastrarFase(Fase fase) throws Exception {

		try {

			this.entityManager.persist(fase);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Fase.");

		}

	}
	
	public void modificarFase(Fase fase) throws Exception {

		try {

			this.entityManager.merge(fase);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Fase.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Fase> listarFases() {

		try {

			Query query = this.entityManager.createQuery("FROM Fase f");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Fase>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Fase> listarFasesAtiva() {

		try {

			Query query = this.entityManager.createQuery("FROM Fase f WHERE f.ativo =:param1");
			query.setParameter("param1", true);			
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Fase>();

		}

	}

}
