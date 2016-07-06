package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.SistemaAfetado;

@Stateless
public class SistemaAfetadoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarSistemaAfetado(SistemaAfetado sistemaAfetado) throws Exception {
		
		try {
			
			this.entityManager.persist(sistemaAfetado);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Sistema.");
			
		}
		
	}
	
	public void modificarSistemaAfetado(SistemaAfetado sistemaAfetado) throws Exception {
		
		try {
			
			this.entityManager.merge(sistemaAfetado);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Sistema");
			
		}		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<SistemaAfetado> listarSistema() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM SistemaAfetado s");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<SistemaAfetado>();
			
		}
		
	}

}
