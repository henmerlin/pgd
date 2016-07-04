package models.pps;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.SequenciaRelatorioPp;

@Stateless
public class SequenciaRelatorioPpServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public SequenciaRelatorioPpServico() {



	}

	public void cadastrarSequencia(SequenciaRelatorioPp sequenciaRelatorioPp) throws Exception {

		try {

			this.entityManager.persist(sequenciaRelatorioPp);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Sequencia.");

		}

	}

	public void modificarSequencia(SequenciaRelatorioPp sequenciaRelatorioPp) throws Exception {

		try {

			this.entityManager.merge(sequenciaRelatorioPp);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Sequencia.");

		}

	}

	public SequenciaRelatorioPp listarSequencia() throws Exception {

		try {

			Query query = this.entityManager.createQuery("FROM SequenciaRelatorioPp s");
			return (SequenciaRelatorioPp) query.getSingleResult();

		} catch (Exception e) {

			throw new Exception("Sequencia não encontrado.");

		}

	}

}
