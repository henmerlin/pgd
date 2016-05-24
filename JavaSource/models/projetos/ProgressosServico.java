package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Progressos;

@Stateless
public class ProgressosServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public ProgressosServico() {
		
	}
	
	public void cadastrarProgresso(Progressos progressos) throws Exception {

		try {

			this.entityManager.persist(progressos);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Progressos.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Progressos> listarProgressos() {

		try {

			Query query = this.entityManager.createQuery("FROM Progressos");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Progressos>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Progressos> listarProgressosProjetoEspecifico(Progressos progressos) {

		try {

			Query query = this.entityManager.createQuery("FROM Progressos p WHERE p.projeto =:param1");
			query.setParameter("param1", progressos);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Progressos>();

		}

	}

}
