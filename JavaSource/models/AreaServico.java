package models;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Area;

@Stateless
public class AreaServico {
		
	@PersistenceContext(unitName="vu")  
	private EntityManager entityManager;
	
	public AreaServico() {
		
	}
	
	public void cadastrarArea(Area area) throws Exception {
		
		try {
			
			this.entityManager.persist(area);
			
		} catch (Exception e) {
			
			throw new Exception("Não foi possivel cadastrar uma Area");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> listarAreas() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Area a");
			
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Area>();
			
		}
		
	}
	

}
