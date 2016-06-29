package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.InformacaoFase;
import entidades.pps.Pp;

@Stateless
public class InformacaoFaseServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarInformacaoFase(InformacaoFase informacaoFase, Pp pp) throws Exception {
		
		try {
			
			informacaoFase.setPp(pp);
			
			this.entityManager.persist(informacaoFase);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar informa��o da fase");
						
		}
		
	}
	
	public void modificarInformacaoFase(InformacaoFase informacaoFase) throws Exception {
		
		try {
			
			this.entityManager.merge(informacaoFase);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar informa��o da fase");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<InformacaoFase> listarInformacaoFaseEspecifico(Pp pp) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM InformacaoFase i WHERE i.pp =:param1");
			query.setParameter("param1", pp);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<InformacaoFase>();
			
		}
		
	}
	
}
