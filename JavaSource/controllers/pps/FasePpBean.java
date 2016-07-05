package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.FasePp;
import models.pps.FasePpServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class FasePpBean {
	
	private FasePp fasePp;
	
	private FasePp fasePpMostra;
	
	@EJB
	private FasePpServico fasePpServico;

	public FasePpBean() {
		
		this.fasePp = new FasePp();
		
		this.fasePpMostra = new FasePp();
		
	}
	
	public void cadastrarFase() {
		
		try {	
			
			this.fasePpServico.cadastrarFase(this.fasePp);
			JSFUtil.addInfoMessage("Fase cadastrada com sucesso.");
			this.fasePp = new FasePp();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<FasePp> listarFasePp() {
		
		return this.fasePpServico.listarFasePp();
		
	}
	
	public List<FasePp> listarFasePpAtivo() {
		
		return this.fasePpServico.listarFasePpAtivo();
		
	}
	
	public void modificarFase() {
		
		try {
			
			this.fasePpServico.modificarFase(this.fasePpMostra);
			JSFUtil.addInfoMessage("Fase " + this.fasePpMostra.getNome() + " modificada com sucesso.");
			this.fasePpMostra = new FasePp();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}

	public FasePp getFasePp() {
		return fasePp;
	}

	public void setFasePp(FasePp fasePp) {
		this.fasePp = fasePp;
	}

	public FasePp getFasePpMostra() {
		return fasePpMostra;
	}

	public void setFasePpMostra(FasePp fasePpMostra) {
		this.fasePpMostra = fasePpMostra;
	}	
		
}
