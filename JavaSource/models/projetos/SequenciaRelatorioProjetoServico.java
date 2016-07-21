package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.SequenciaRelatorioProjeto;
import entidades.projetos.StatusProjeto;

@Stateless
public class SequenciaRelatorioProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarSequenciaRelatorioProjeto(StatusProjeto statusProjeto) throws Exception {

		try {

			SequenciaRelatorioProjeto sequenciaRelatorioProjeto = new SequenciaRelatorioProjeto();

			sequenciaRelatorioProjeto.setStatusProjeto(statusProjeto);
			sequenciaRelatorioProjeto.setAtivo(false);

			this.entityManager.persist(sequenciaRelatorioProjeto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Sequencia.");


		}

	}

	public void modificaSequenciaRelatorioProjeto(SequenciaRelatorioProjeto sequenciaRelatorioProjeto) throws Exception {

		try {

			this.entityManager.merge(sequenciaRelatorioProjeto);

		} catch (Exception e) {
			throw new Exception("Erro ao modificar Sequencia.");
		}

	}

	@SuppressWarnings("unchecked")
	public List<SequenciaRelatorioProjeto> listarSequenciaRelatorioProjeto() {

		try {
			
			Query query = this.entityManager.createQuery("FROM SequenciaRelatorioProjeto s");
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<SequenciaRelatorioProjeto>();		
			
		}

	}

	@SuppressWarnings("unchecked")
	public List<SequenciaRelatorioProjeto> listarSequenciaRelatorioProjetoAtivo() {

		try {
			
			Query query = this.entityManager.createQuery("FROM SequenciaRelatorioProjeto s WHERE s.ativo =:param1");
			query.setParameter("param1", true);
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<SequenciaRelatorioProjeto>();
			
		}

	}

}
