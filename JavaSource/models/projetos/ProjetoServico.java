package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.Projeto;
import entidades.projetos.SequenciaRelatorioProjeto;
import entidades.projetos.StatusProjeto;
import entidades.projetos.TipoProjeto;

@Stateless
public class ProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarProjeto(Projeto projeto) throws Exception {
		
		try {
			
			this.entityManager.persist(projeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Projeto");
			
		}
		
	}
	
	public void modificarProjeto(Projeto projeto) throws Exception {
		
		try {
			
			this.entityManager.merge(projeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Projeto");

		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> listarProjetos() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Projeto p ORDER BY p.id ASC");
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<Projeto>();		
			
		}
		
	}
	
	public Projeto listarProjetoEspecifico(Projeto projeto) throws Exception {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Projeto p WHERE p.id =:param1");
			query.setParameter("param1", projeto.getId());
			return (Projeto) query.getSingleResult();
			
		} catch (Exception e) {
			
			throw new Exception("Projeto não encontrado.");

		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> listarProjetosStatusEspecifico(StatusProjeto statusProjeto) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Projeto p WHERE p.statusProjeto =:param1");
			query.setParameter("param1", statusProjeto);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Projeto>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> listarProjetosTipoProjeto(TipoProjeto tipoProjeto) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Projeto p WHERE p.tipoProjeto =:param1");
			query.setParameter("param1", tipoProjeto);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Projeto>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> listarProjetoEvolucao(Boolean bol, List<SequenciaRelatorioProjeto> listaSequencia) {
		
		try {
			
			StringBuffer sequencia = new StringBuffer();

			Integer totalLista = listaSequencia.size();

			Integer count = 1;			

			for (SequenciaRelatorioProjeto sequenciaRelatorioProjeto : listaSequencia) {
				
				String or = "";

				if (count != totalLista) {

					or = " OR ";

				}

				sequencia.append("p.statusProjeto.nome = '" + sequenciaRelatorioProjeto.getStatusProjeto().getNome() + "' " + or + " ");

				count++;

			}
					
			Query query = this.entityManager.createQuery("FROM Projeto p WHERE p.evolucao =:param1 AND ( "  + sequencia + ")");
			query.setParameter("param1", bol);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Projeto>();

		}
		
	}

}
