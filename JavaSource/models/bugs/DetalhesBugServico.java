package models.bugs;

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
	
	public DetalhesBug listarDetalhesBugEspecifico(Bug bug) throws Exception {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM DetalhesBug d WHERE d.bug =:param1");
			query.setParameter("param1", bug);			
			return (DetalhesBug) query.getSingleResult();
			
		} catch (Exception e) {
			
			throw new Exception("Não foi possivel encontrar detalhe especifico.");
			
		}
		
	}

}
