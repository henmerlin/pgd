package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.ImpactoBug;

@Stateless
public class ImpactoBugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarImpacto(ImpactoBug impactoBug) throws Exception {

		try {

			List<ImpactoBug> listarDImpacto = this.listarImpacto();

			Integer total = listarDImpacto.size() + 1;

			impactoBug.setOrdem(total);

			this.entityManager.persist(impactoBug);

		} catch (Exception e) {

			throw new Exception("Erro ao acadastrar impacto.");

		}

	}

	public void modificarImpacto(ImpactoBug impactoBug) throws Exception {

		try {

			List<ImpactoBug> listarDImpacto = this.listarImpacto();

			ImpactoBug impactoBugEspecifico = this.listarImpactoBugEspecifico(impactoBug.getId());

			this.ordenarListaImpacto(impactoBug, impactoBugEspecifico, listarDImpacto);

			this.entityManager.merge(impactoBug);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Impacto: " + impactoBug.getNome());

		}

	}

	@SuppressWarnings("unchecked")
	public List<ImpactoBug> listarImpacto() {

		try {

			Query query = this.entityManager.createQuery("FROM ImpactoBug i ORDER BY i.ordem ASC");

			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ImpactoBug>();

		}

	}

	public ImpactoBug listarImpactoBugEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("");
			query.setParameter("param1", id);
			return (ImpactoBug) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

	public void ordenarListaImpacto(ImpactoBug impactoBugNovo, ImpactoBug impactoBugAntigo, List<ImpactoBug> listaImpacto) {

		if (impactoBugNovo.getOrdem() > impactoBugAntigo.getOrdem()) {

			for (ImpactoBug impactoBug : listaImpacto) {

				if (impactoBug.getOrdem() > impactoBugAntigo.getOrdem() && impactoBug.getOrdem() <= impactoBugAntigo.getOrdem()) {

					impactoBug.setOrdem(impactoBug.getOrdem() - 1);

					this.entityManager.merge(impactoBug);
				}

			}

		}

		if (impactoBugNovo.getOrdem() < impactoBugAntigo.getOrdem()) {

			for (ImpactoBug impactoBug : listaImpacto) {

				if (impactoBug.getOrdem() < impactoBugAntigo.getOrdem() && impactoBug.getOrdem() >= impactoBugAntigo.getOrdem()) {

					impactoBug.setOrdem(impactoBug.getOrdem() + 1);

					this.entityManager.merge(impactoBug);
				}

			}

		}

	}

}
