package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.Pp;
import entidades.pps.Priorizacao;
import models.pps.PriorizacaoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class PriorizacaoBean {

	private Priorizacao priorizacao;
	
	private Priorizacao priorizacaoModifica;
	
	@EJB
	private PriorizacaoServico priorizacaoServico;
	
	public PriorizacaoBean() {
		
		this.priorizacao = new Priorizacao();
		
		this.priorizacaoModifica = new Priorizacao();
		
	}
	
	public void cadastrarPriorizacao(Pp pp) {
		
		try {
			
			this.priorizacaoServico.cadastrarPriorizacao(this.priorizacao, pp);
			JSFUtil.addInfoMessage("Priorização cadastrada com sucesso.");
			this.priorizacao = new Priorizacao();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarPriorizacao() {
		
		try {
			
			this.priorizacaoServico.modificarPriorizacao(this.priorizacaoModifica);
			JSFUtil.addInfoMessage("Priorização modificada com sucesso.");
			this.priorizacaoModifica = new Priorizacao();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Priorizacao> listarPriorizacaoEspecifico(Pp pp) {
		
		return this.priorizacaoServico.listarPriorizacaoEspecifico(pp);
		
	}
	
	public List<Priorizacao> listarPriorizacao() {
		
		return this.priorizacaoServico.listarPriorizacao();
		
	}

	public Priorizacao getPriorizacao() {
		return priorizacao;
	}

	public void setPriorizacao(Priorizacao priorizacao) {
		this.priorizacao = priorizacao;
	}

	public Priorizacao getPriorizacaoModifica() {
		return priorizacaoModifica;
	}

	public void setPriorizacaoModifica(Priorizacao priorizacaoModifica) {
		this.priorizacaoModifica = priorizacaoModifica;
	}	
	
}
