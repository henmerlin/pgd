package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.ProjetoFase;

@Stateless
public class ProjetoFaseServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;


	public void cadastrarFase(ProjetoFase projetoFase) throws Exception {

		try {

			List<ProjetoFase> listarDFase = this.listarProjetoFase();
			
			Integer total = listarDFase.size() + 1;
			
			projetoFase.setOrdem(total);
			
			this.entityManager.persist(projetoFase);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Fase");			

		}

	}

	public void modificarFase(ProjetoFase projetoFase) throws Exception {

		try {

			List<ProjetoFase> listarDFase = this.listarProjetoFase();
			
			ProjetoFase projetoFaseEspecifico = this.listarProjetoFaseEspecifico(projetoFase.getId());
			
			this.ordenarProjetoFase(projetoFase, projetoFaseEspecifico, listarDFase);
			
			this.entityManager.merge(projetoFase);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Fase");			

		}

	}

	@SuppressWarnings("unchecked")
	public List<ProjetoFase> listarProjetoFase() {

		try {

			Query query = this.entityManager.createQuery("FROM ProjetoFase p ORDER BY p.ordem ASC");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ProjetoFase>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<ProjetoFase> listarProjetoFaseAtivo() {

		try {

			Query query = this.entityManager.createQuery("FROM ProjetoFase p WHERE p.ativo =:param1 ORDER BY p.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<ProjetoFase>();

		}

	}

	public ProjetoFase listarProjetoFaseEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM ProjetoFase p WHERE p.id =:param1 ORDER BY p.ordem ASC");
			query.setParameter("param1", id);
			return (ProjetoFase) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

	public void ordenarProjetoFase(ProjetoFase projetoFaseNovo, ProjetoFase projetoFaseAntigo, List<ProjetoFase> listaProjetoFase) {

		if (projetoFaseNovo.getOrdem() > projetoFaseAntigo.getOrdem()) {

			for (ProjetoFase projetoFase : listaProjetoFase) {

				if (projetoFase.getOrdem() > projetoFaseAntigo.getOrdem() && projetoFase.getOrdem() <= projetoFaseNovo.getOrdem()) {

					projetoFase.setOrdem(projetoFase.getOrdem() - 1);

					this.entityManager.merge(projetoFase);

				}

			}

		}

		if (projetoFaseNovo.getOrdem() < projetoFaseAntigo.getOrdem()) {

			for (ProjetoFase projetoFase : listaProjetoFase) {

				if (projetoFase.getOrdem() < projetoFaseAntigo.getOrdem() && projetoFase.getOrdem() >= projetoFaseNovo.getOrdem()) {

					projetoFase.setOrdem(projetoFase.getOrdem() + 1);

					this.entityManager.merge(projetoFase);

				}

			}

		}

	}

}
