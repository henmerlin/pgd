package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.SequenciaRelatorioPp;
import entidades.pps.StatusFasePp;

@Stateless
public class SequenciaRelatorioPpServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public SequenciaRelatorioPpServico() {



	}

	public void cadastrarSequencia(StatusFasePp statusFase) throws Exception {

		try {
			
			SequenciaRelatorioPp sequenciaRelatorioPp = new SequenciaRelatorioPp();
			
			sequenciaRelatorioPp.setStatusFasePp(statusFase);
			sequenciaRelatorioPp.setAtivo(false);

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

		
	@SuppressWarnings("unchecked")
	public List<SequenciaRelatorioPp> listarSequenciaAtivo() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM SequenciaRelatorioPp s WHERE s.ativo =:param1");
			query.setParameter("param1", true);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<SequenciaRelatorioPp>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<SequenciaRelatorioPp> listarSequencia() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM SequenciaRelatorioPp s");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<SequenciaRelatorioPp>();
			
		}
		
		
	}
	
}
