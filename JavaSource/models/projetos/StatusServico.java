package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Status;

@Stateless
public class StatusServico {

	@PersistenceContext(unitName="vu")  
	private EntityManager entityManager;

	public StatusServico() {

	}

	public void cadastrarStatus(Status status) throws Exception {

		try {

			this.entityManager.persist(status);		

		} catch (Exception e) {

			throw new Exception("Não foi possivel cadastrar uma Status");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Status> listarStatus() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Status f");
			
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Status>();
			
		}
		
	}
	
	public void editarFase(Status status) throws Exception {

		try {

			this.entityManager.merge(status);

		} catch (Exception e) {

			throw new Exception("Não foi possivel editar uma Status");

		}

	}

}
