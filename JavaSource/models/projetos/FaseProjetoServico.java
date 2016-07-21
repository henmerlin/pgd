package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.projetos.FaseProjeto;
import entidades.projetos.Projeto;
import entidades.projetos.ProjetoFase;
import entidades.projetos.SequenciaRelatorioProjeto;

@Stateless
public class FaseProjetoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	
	public void cadastrarFaseProjeto(FaseProjeto faseProjeto, Projeto projeto) throws Exception {
		
		try {
			
			faseProjeto.setProjeto(projeto);
			
			this.entityManager.persist(faseProjeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro cadastrar Fase Projeto");
			
		}
		
	}
	
	public void modificarFaseProjeto(FaseProjeto faseProjeto) throws Exception {
		
		try {
			
			this.entityManager.merge(faseProjeto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Fase Projeto");

		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<FaseProjeto> listarFaseProjetoEspecifico(Projeto projeto) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM FaseProjeto f WHERE f.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();		
			
		} catch (Exception e) {
			
			return new ArrayList<FaseProjeto>();

		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<FaseProjeto> listarFaseProjetoStatusEspecifico(ProjetoFase projetoFase, List<SequenciaRelatorioProjeto> listaSequencia) {
		
		try {
			
			StringBuffer sequencia = new StringBuffer();

			Integer totalLista = listaSequencia.size();

			Integer count = 1;			

			for (SequenciaRelatorioProjeto sequenciaRelatorioProjeto : listaSequencia) {
				
				String or = "";

				if (count != totalLista) {

					or = " OR ";

				}

				sequencia.append("f.statusProjeto.nome = '" + sequenciaRelatorioProjeto.getStatusProjeto().getNome() + "' " + or + " ");

				count++;

			}
			
			Query query = this.entityManager.createQuery("FROM FaseProjeto f WHERE f.projetoFase =:param1 AND ( " + sequencia + " )");
			query.setParameter("param1", projetoFase);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<FaseProjeto>();			
			
		}
		
	}

}
