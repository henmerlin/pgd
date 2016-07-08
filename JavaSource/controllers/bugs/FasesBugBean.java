package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.FasesBug;
import models.bugs.FasesBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class FasesBugBean {
	
	private FasesBug fasesBug;
	
	private FasesBug fasesBugModifica;
	
	@EJB
	private FasesBugServico fasesBugServico;

	public FasesBugBean() {
		
		this.fasesBug = new FasesBug();
		
		this.fasesBugModifica = new FasesBug();
		
	}
	
	public void cadastrarFase() {
		
		try {
			
			this.fasesBugServico.cadastrarFase(this.fasesBug);
			JSFUtil.addInfoMessage("Fase cadastrada com sucesso.");
			this.fasesBug = new FasesBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarFase() {
		
		try {
			
			this.fasesBugServico.modificarFase(this.fasesBugModifica);
			JSFUtil.addInfoMessage("Fase modificada com sucesso.");
			this.fasesBugModifica = new FasesBug();			
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<FasesBug> listarFaseBug() {
		
		return this.fasesBugServico.listarFaseBug();
		
	}
	
	public List<FasesBug> listarFaseBugAtivo() {
		
		return this.fasesBugServico.listarFaseBugAtivo();
		
	}

	public FasesBug getFasesBug() {
		return fasesBug;
	}

	public void setFasesBug(FasesBug fasesBug) {
		this.fasesBug = fasesBug;
	}

	public FasesBug getFasesBugModifica() {
		return fasesBugModifica;
	}

	public void setFasesBugModifica(FasesBug fasesBugModifica) {
		this.fasesBugModifica = fasesBugModifica;
	}	

}
