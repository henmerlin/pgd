package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.FasePp;

@Stateless
public class FasePpServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarFase(FasePp fasePp) throws Exception {

		try {

			List<FasePp> listaDFase = this.listarFasePp();

			Integer ultimoLista = listaDFase.size() + 1;

			fasePp.setOrdem(ultimoLista);

			this.entityManager.persist(fasePp);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar a Fase");

		}

	}

	public void modificarFase(FasePp fasePp) throws Exception {

		try {		

			List<FasePp> listaDFase = this.listarFasePp();

			FasePp fasePpEspecifica = this.listaFasePpEspecifica(fasePp.getId());			

			this.ordenarListaFase(fasePp, fasePpEspecifica, listaDFase);
			
			this.entityManager.merge(fasePp);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar a Fase: " + fasePp.getNome());

		}

	}

	@SuppressWarnings("unchecked")
	public List<FasePp> listarFasePpAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM FasePp f WHERE f.ativo =:param1 ORDER BY f.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<FasePp>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<FasePp> listarFasePp() {

		try {

			Query query = this.entityManager.createQuery("FROM FasePp f ORDER BY f.ordem ASC");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<FasePp>();

		}

	}

	public FasePp listaFasePpEspecifica(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM FasePp f WHERE f.id =:param1");
			query.setParameter("param1", id);
			return (FasePp) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

	public void ordenarListaFase(FasePp fasePpNova, FasePp fasePpAntiga, List<FasePp> listaFase) {

		if (fasePpNova.getOrdem() > fasePpAntiga.getOrdem()) {

			for (FasePp fase : listaFase) {

				if (fase.getOrdem() > fasePpAntiga.getOrdem() && fase.getOrdem() <= fasePpNova.getOrdem()) {

					fase.setOrdem(fase.getOrdem() - 1);

					this.entityManager.merge(fase);

				}				

			}

		}

		if (fasePpNova.getOrdem() < fasePpAntiga.getOrdem()) {

			for (FasePp fase : listaFase) {

				if (fase.getOrdem() < fasePpAntiga.getOrdem() && fase.getOrdem() >= fasePpNova.getOrdem()) {

					fase.setOrdem(fase.getOrdem() + 1);

					this.entityManager.merge(fase);

				}				

			}

		}

	}

}
