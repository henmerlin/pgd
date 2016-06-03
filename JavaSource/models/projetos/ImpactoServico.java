package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Impacto;

@Stateless
public class ImpactoServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;	

	public ImpactoServico() {
		
	}
	
	public void cadastrarImpacto(Impacto impacto) throws Exception {

		try {

			this.entityManager.persist(impacto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Impacto.");

		}
		
	}
	
	public void modificarImpacto(Impacto impacto) throws Exception {

		try {

			this.entityManager.merge(impacto);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Impacto.");

		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Impacto> listarImpacto() {

		try {

			Query query = this.entityManager.createQuery("FROM Impacto");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Impacto>();

		}

	}	

}
