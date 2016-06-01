package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.TipoTarefa;

@Stateless
public class TipoTarefaServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public TipoTarefaServico() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoTarefa> listarTipoTarefa() {

		try {

			Query query = this.entityManager.createQuery("FROM TipoTarefa");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<TipoTarefa>();

		}

	}

	

}
