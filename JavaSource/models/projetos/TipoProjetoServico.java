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
	
	public void modificarTipoProjeto(TipoProjeto tipoProjeto) throws Exception {

		try {
			
			this.entityManager.merge(tipoProjeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar TipoProjeto.");
			
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
	
	@SuppressWarnings("unchecked")
	public List<TipoProjeto> listarTipoProjetoAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM TipoProjeto t WHERE t.ativo =:param1");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<TipoProjeto>();

		}

	}	
	
}
