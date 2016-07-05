package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.Prioridade;

@Stateless
public class PrioridadeServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarPrioridade(Prioridade prioridade) throws Exception {

		try {

			List<Prioridade> listaDPrioridade = this.listarPrioridades();

			Integer ultimoLista = listaDPrioridade.size() + 1;

			prioridade.setOrdem(ultimoLista);

			this.entityManager.persist(prioridade);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Prioridade");

		}

	}

	public void modificaPrioridade(Prioridade prioridade) throws Exception {

		try {

			List<Prioridade> listaDPrioridade = this.listarPrioridades();

			Prioridade prioridadeEspecifico = this.listarPrioridadeEspecifico(prioridade.getNome());

			if (prioridade.getOrdem() > prioridadeEspecifico.getOrdem()) {

				for (Prioridade prioridadePp : listaDPrioridade) {

					if (prioridadePp.getOrdem() > prioridadeEspecifico.getOrdem() && prioridadePp.getOrdem() <= prioridade.getOrdem()) {

						prioridadePp.setOrdem(prioridadePp.getOrdem() + 1);

						this.entityManager.persist(prioridadePp);

					}

				}				

			}

			if (prioridade.getOrdem() < prioridadeEspecifico.getOrdem()) {

				for (Prioridade prioridadePp : listaDPrioridade) {

					if (prioridadePp.getOrdem() < prioridadeEspecifico.getOrdem() && prioridadePp.getOrdem() >= prioridade.getOrdem()) {

						prioridadePp.setOrdem(prioridadePp.getOrdem() - 1);

						this.entityManager.persist(prioridadePp);

					}

				}				

			}

			this.entityManager.merge(prioridade);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Prioridade");

		}

	}

	@SuppressWarnings("unchecked")
	public List<Prioridade> listarPrioridadesAtiva() {

		try {

			Query query = this.entityManager.createQuery("FROM Prioridade p WHERE p.ativo =:param1 ORDER BY p.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Prioridade>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Prioridade> listarPrioridades() {

		try {

			Query query = this.entityManager.createQuery("FROM Prioridade p ORDER BY p.ordem ASC");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Prioridade>();

		}

	}

	public Prioridade listarPrioridadeEspecifico(String nome) {

		try {

			Query query = this.entityManager.createQuery("FROM Prioridade p WHERE p.nome =:param1");
			query.setParameter("param1", nome);
			return (Prioridade) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

}
