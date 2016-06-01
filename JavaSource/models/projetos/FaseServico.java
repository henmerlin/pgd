package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.StatusFase;

@Stateless
public class FaseServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public FaseServico() {
		
	}
	
	public void cadastrarFase(StatusFase fase) throws Exception {

		try {

			this.entityManager.persist(fase);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Fase.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<StatusFase> listarFases() {

		try {

			Query query = this.entityManager.createQuery("FROM Fase");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<StatusFase>();

		}

	}

}
