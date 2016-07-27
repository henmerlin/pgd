package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.Bug;
import entidades.bugs.DetalhesBug;
import entidades.bugs.FasesBug;

@Stateless
public class DetalhesBugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarDetalhes(DetalhesBug detalhesBug, Bug bug) throws Exception {

		try {
						
			Integer totalDetalhes = this.listarDetalhesBugEspecifico(bug).size();
			
			if (totalDetalhes == 0) {
				
				detalhesBug.setBug(bug);
				this.entityManager.persist(detalhesBug);

			}else{
				
				throw new Exception("Bug já possui um detalhe cadastrado.");
				
			}
			
		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Detalhe.");

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
	
	@SuppressWarnings("unchecked")
	public List<DetalhesBug> listarDetalhesBugPorFase(FasesBug fasesBug) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM DetalhesBug d WHERE d.fasesBug =:param1");
			query.setParameter("param1", fasesBug);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<DetalhesBug>();
			
		}
		
	}
	
	public DetalhesBug listarDetalhesBugEspecificoUm(Bug bug) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM DetalhesBug d WHERE d.bug =:param1");
			query.setParameter("param1", bug);
			return (DetalhesBug) query.getSingleResult();
			
		} catch (Exception e) {

			return null;
			
		}
		
	}

}
