package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.TipoProjeto;

@Stateless
public class TipoProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
		
	public TipoProjetoServico() {
		
	}
	
	public void cadastrarTipoProjeto(TipoProjeto tipoProjeto) throws Exception {

		try {

			this.entityManager.persist(tipoProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar TipoProjeto.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<TipoProjeto> listarTipoProjeto() {

		try {

			Query query = this.entityManager.createQuery("FROM TipoProjeto");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<TipoProjeto>();

		}

	}

}
