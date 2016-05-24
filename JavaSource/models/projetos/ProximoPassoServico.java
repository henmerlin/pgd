package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Projeto;
import entidades.projetos.ProximoPasso;

@Stateless
public class ProximoPassoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public ProximoPassoServico() {
				
	}
	
	public void cadastrarProximoPasso(ProximoPasso proximoPasso) throws Exception {

		try {

			this.entityManager.persist(proximoPasso);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar ProximoPasso.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<ProximoPasso> listarProximoPasso() {

		try {

			Query query = this.entityManager.createQuery("FROM ProximoPasso");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ProximoPasso>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<ProximoPasso> listarProximoPassoProjeto(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM ProximoPasso p WHERE p.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ProximoPasso>();

		}

	}
	
}
