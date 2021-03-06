package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.Codigo;

@Stateless
public class CodigoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarCodigo(Codigo codigo) throws Exception {

		try {

			this.entityManager.persist(codigo);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Codigo");

		}

	}
	
	public void modificarCodigo(Codigo codigo) throws Exception {

		try {

			this.entityManager.merge(codigo);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Codigo");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Codigo> listarCodigosAtivo() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Codigo c WHERE c.ativo =:param1");
			query.setParameter("param1", true);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Codigo>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Codigo> listarCodigos() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Codigo c");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Codigo>();
			
		}
		
	}

}
