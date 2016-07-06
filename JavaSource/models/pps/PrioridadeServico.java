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

			Prioridade prioridadeEspecifico = this.listarPrioridadeEspecifico(prioridade.getId());			

			this.ordenarListaPrioridade(prioridade, prioridadeEspecifico, listaDPrioridade);
			
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

	public Prioridade listarPrioridadeEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM Prioridade p WHERE p.id =:param1");
			query.setParameter("param1", id);
			return (Prioridade) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}
	
	public void ordenarListaPrioridade(Prioridade prioridadeNova, Prioridade prioridadeAntiga, List<Prioridade> listaPrioridade) {
		
		if (prioridadeNova.getOrdem() > prioridadeAntiga.getOrdem()) {

			for (Prioridade prioridade : listaPrioridade) {

				if (prioridade.getOrdem() > prioridadeAntiga.getOrdem() && prioridade.getOrdem() <= prioridadeNova.getOrdem()) {

					prioridade.setOrdem(prioridade.getOrdem() - 1);

					this.entityManager.merge(prioridade);

				}				

			}

		}
		
		if (prioridadeNova.getOrdem() < prioridadeAntiga.getOrdem()) {

			for (Prioridade prioridade : listaPrioridade) {

				if (prioridade.getOrdem() < prioridadeAntiga.getOrdem() && prioridade.getOrdem() >= prioridadeNova.getOrdem()) {

					prioridade.setOrdem(prioridade.getOrdem() + 1);

					this.entityManager.merge(prioridade);

				}				

			}

		}
		
	}

}
