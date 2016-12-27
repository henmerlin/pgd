package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.Pp;
import entidades.pps.Priorizacao;

@Stateless
public class PriorizacaoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarPriorizacao(Priorizacao priorizacao, Pp pp) throws Exception {

		try {

			Integer total = this.listarPriorizacaoEspecifico(pp).size();

			if (total == 0) {
				
				priorizacao.setPp(pp);
				this.entityManager.persist(priorizacao);
				
			}else{
				
				throw new Exception("Já existe uma Priorização cadastrada.");
				
			}

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Priorização.");

		}

	}

	public void modificarPriorizacao(Priorizacao priorizacao) throws Exception {

		try {

			this.entityManager.merge(priorizacao);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Priorização.");

		}

	}

	@SuppressWarnings("unchecked")
	public List<Priorizacao> listarPriorizacaoEspecifico(Pp pp) {

		try {

			Query query = this.entityManager.createQuery("FROM Priorizacao p WHERE p.pp =:param1");
			query.setParameter("param1", pp);			
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Priorizacao>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Priorizacao> listarPriorizacao() {

		try {

			Query query = this.entityManager.createQuery("FROM Priorizacao p");
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<Priorizacao>();

		}

	}

}
