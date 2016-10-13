package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Impacto;

@Stateless
public class ImpactoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarImpacto(Impacto impacto) throws Exception {

		try {

			List<Impacto> listaDeImpacto = this.listarImpacto();

			Integer total = listaDeImpacto.size() + 1;

			impacto.setOrdem(total);

			this.entityManager.persist(impacto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Impacto");

		}

	}

	public void modificarImpacto(Impacto impacto) throws Exception {

		try {

			List<Impacto> listaDeImpacto = this.listarImpacto();

			Impacto impactoEspecifico = this.listarImpactoEspecifico(impacto.getId());

			this.ordenarListaImpacto(impacto, impactoEspecifico, listaDeImpacto);

			this.entityManager.merge(impacto);

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			throw new Exception("Erro ao modificar Impacto");

		}

	}

	@SuppressWarnings("unchecked")
	public List<Impacto> listarImpacto() {

		try {

			Query query = this.entityManager.createQuery("FROM Impacto i ORDER BY i.ordem ASC");						
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<Impacto>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Impacto> listarImpactoAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM Impacto i WHERE i.ativo =:param1 ORDER BY i.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<Impacto>();

		}

	}	

	public Impacto listarImpactoEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM Impacto i WHERE i.id =:param1 ORDER BY i.ordem ASC");
			query.setParameter("param1", id);
			return (Impacto) query.getSingleResult();			

		} catch (Exception e) {

			return null;

		}

	}

	public void ordenarListaImpacto(Impacto impactoNovo, Impacto impactoAntigo, List<Impacto> listaImpacto) {

		if (impactoNovo.getOrdem() > impactoAntigo.getOrdem()) {

			for (Impacto impacto : listaImpacto) {

				if (impacto.getOrdem() > impactoAntigo.getOrdem() && impacto.getOrdem() <= impactoNovo.getOrdem()) {

					impacto.setOrdem(impacto.getOrdem() - 1);

					this.entityManager.merge(impacto);

				}

			}

		}

		if (impactoNovo.getOrdem() < impactoAntigo.getOrdem()) {

			for (Impacto impacto : listaImpacto) {

				if (impacto.getOrdem() < impactoAntigo.getOrdem() && impacto.getOrdem() >= impactoNovo.getOrdem()) {

					impacto.setOrdem(impacto.getOrdem() + 1);

					this.entityManager.merge(impacto);

				}

			}

		}

	}

}
