package models.bugs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.bugs.FasesBug;

@Stateless
public class FasesBugServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarFase(FasesBug fasesBug) throws Exception {

		try {

			List<FasesBug> listaDFaseBug = this.listarFaseBug();
			
			Integer total = listaDFaseBug.size() + 1;
			
			fasesBug.setOrdem(total);
			
			this.entityManager.persist(fasesBug);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Fase.");

		}

	}

	public void modificarFase(FasesBug fasesBug) throws Exception {

		try {

			List<FasesBug> listaDFaseBug = this.listarFaseBug();
			
			FasesBug fasesBugEspecifico = this.listarFaseBugEspecifico(fasesBug.getId());
			
			this.ordernarListaFaseBug(fasesBug, fasesBugEspecifico, listaDFaseBug);
			
			this.entityManager.merge(fasesBug);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Fase");

		}

	}

	@SuppressWarnings("unchecked")
	public List<FasesBug> listarFaseBug() {

		try {

			Query query = this.entityManager.createQuery("FROM FasesBug f ORDER BY f.ordem ASC");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<FasesBug>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<FasesBug> listarFaseBugAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM FasesBug f WHERE f.ativo =:param1 ORDER BY f.ordem ASC");
			query.setParameter("param1", true);			
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<FasesBug>();

		}

	}

	public FasesBug listarFaseBugEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM FasesBug f WHERE f.id =:param1");
			query.setParameter("param1", id);
			return (FasesBug) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

	public void ordernarListaFaseBug(FasesBug fasesBugNovo, FasesBug fasesBugAntigo, List<FasesBug> listaFaseBug) {

		if (fasesBugNovo.getOrdem() > fasesBugAntigo.getOrdem()) {

			for (FasesBug fasesBug : listaFaseBug) {

				if (fasesBug.getOrdem() > fasesBugAntigo.getOrdem() && fasesBug.getOrdem() <= fasesBugNovo.getOrdem()) {

					fasesBug.setOrdem(fasesBug.getOrdem() - 1);

					this.entityManager.merge(fasesBug);

				}

			}

		}

		if (fasesBugNovo.getOrdem() < fasesBugAntigo.getOrdem()) {

			for (FasesBug fasesBug : listaFaseBug) {

				if (fasesBug.getOrdem() < fasesBugAntigo.getOrdem() && fasesBug.getOrdem() >= fasesBugNovo.getOrdem()) {

					fasesBug.setOrdem(fasesBug.getOrdem() + 1);

					this.entityManager.merge(fasesBug);

				}

			}

		}

	}	

}
