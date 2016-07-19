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


	public void cadastrarTipoProjeto(TipoProjeto tipoProjeto) throws Exception {

		try {

			List<TipoProjeto> listaDeTipoProjeto = this.listarTipoProjeto();
			
			Integer total = listaDeTipoProjeto.size() + 1;
			
			tipoProjeto.setOrdem(total);
			
			this.entityManager.persist(tipoProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Tipo de Projeto");

		}

	}

	public void modificarTipoProjeto(TipoProjeto tipoProjeto) throws Exception {

		try {

			List<TipoProjeto> listaDeTipoProjeto = this.listarTipoProjeto();
			
			TipoProjeto tipoProjetoEspecifico = this.listarTipoProjetoEspecifico(tipoProjeto.getId());
			
			this.ordenarListaTipoProjeto(tipoProjeto, tipoProjetoEspecifico, listaDeTipoProjeto);
			
			this.entityManager.merge(tipoProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Tipo de Projeto");

		}

	}

	@SuppressWarnings("unchecked")
	public List<TipoProjeto> listarTipoProjeto() {

		try {

			Query query = this.entityManager.createQuery("FROM TipoProjeto t ORDER BY t.ordem ASC");
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<TipoProjeto>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<TipoProjeto> listarTipoProjetoAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM TipoProjeto t WHERE t.ativo =:param1 ORDER BY t.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<TipoProjeto>();

		}

	}

	public TipoProjeto listarTipoProjetoEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM TipoProjeto t WHERE t.id =:param1");
			query.setParameter("param1", id);
			return (TipoProjeto) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

	public void ordenarListaTipoProjeto(TipoProjeto tipoProjetoNovo, TipoProjeto tipoProjetoAntigo, List<TipoProjeto> listaTipoProjeto) {

		if (tipoProjetoNovo.getOrdem() > tipoProjetoAntigo.getOrdem()) {

			for (TipoProjeto tipoProjeto : listaTipoProjeto) {

				if (tipoProjeto.getOrdem() > tipoProjetoAntigo.getOrdem() && tipoProjeto.getOrdem() <= tipoProjetoNovo.getOrdem()) {


					tipoProjeto.setOrdem(tipoProjeto.getOrdem() - 1);

					this.entityManager.merge(tipoProjeto);


				}

			}

		}	


		if (tipoProjetoNovo.getOrdem() < tipoProjetoAntigo.getOrdem()) {

			for (TipoProjeto tipoProjeto : listaTipoProjeto) {

				if (tipoProjeto.getOrdem() < tipoProjetoAntigo.getOrdem() && tipoProjeto.getOrdem() >= tipoProjetoNovo.getOrdem()) {


					tipoProjeto.setOrdem(tipoProjeto.getOrdem() + 1);

					this.entityManager.merge(tipoProjeto);


				}

			}

		}

	}

}
