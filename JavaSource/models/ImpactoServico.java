package models;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Impacto;

@Stateless
public class ImpactoServico {

	@PersistenceContext(unitName="vu")  
	private EntityManager entityManager;

	public ImpactoServico() {

	}

	public void cadastrarImpacto(Impacto impacto) throws Exception {

		try {

			this.entityManager.persist(impacto);		

		} catch (Exception e) {

			throw new Exception("Não foi possivel cadastrar uma Impacto");

		}

	}

	@SuppressWarnings("unchecked")
	public List<Impacto> listarImpacto() {

		try {

			Query query = this.entityManager.createQuery("FROM Impacto i");

			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Impacto>();

		}

	}

	public void editarFase(Impacto impacto) throws Exception {

		try {

			this.entityManager.merge(impacto);

		} catch (Exception e) {

			throw new Exception("Não foi possivel editar uma Impacto");

		}

	}

}
