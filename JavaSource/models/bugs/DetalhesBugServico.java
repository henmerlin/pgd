package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.Bug;
import entidades.bugs.DetalhesBug;

@Stateless
public class DetalhesBugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarDetalhes(DetalhesBug detalhesBug) throws Exception {

		try {

			this.entityManager.persist(detalhesBug);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Detalhes.");

		}

	}

	public void modificarDetalhes(DetalhesBug detalhesBug) throws Exception {

		try {

			this.entityManager.merge(detalhesBug);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Detalhes.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<DetalhesBug> listarDetalhesBugEspecifico(Bug bug) {		
		
		try {
			
			Query query = this.entityManager.createQuery("FROM DetalhesBug d WHERE d.bug =:param1");
			query.setParameter("param1", bug);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<DetalhesBug>();
			
		}
		
	}

}
