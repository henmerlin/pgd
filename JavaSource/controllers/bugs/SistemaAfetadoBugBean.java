package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.Bug;
import entidades.bugs.SistemaAfetadoBug;
import models.bugs.SistemaAfetadoBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class SistemaAfetadoBugBean {
	
	private SistemaAfetadoBug sistemaAfetadoBug;
	
	private SistemaAfetadoBug sistemaAfetadoBugModifica;
	
	@EJB
	private SistemaAfetadoBugServico sistemaAfetadoBugServico;

	public SistemaAfetadoBugBean() {
		
		this.sistemaAfetadoBug = new SistemaAfetadoBug();
		
		this.sistemaAfetadoBugModifica = new SistemaAfetadoBug();
		
	}
	
	public void cadastrarSistemaAfetadoBug(Bug bug) {
		
		try {
			
			this.sistemaAfetadoBugServico.cadastrarSistemaAfetadoBug(this.sistemaAfetadoBug, bug);
			JSFUtil.addInfoMessage("Sistema cadastrado com sucesso.");
			this.sistemaAfetadoBug = new SistemaAfetadoBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarSistemaAfetadoBug() {
		
		try {
			
			this.sistemaAfetadoBugServico.modificarSistemaAfetadoBug(this.sistemaAfetadoBugModifica);
			JSFUtil.addInfoMessage("Sistema modificado com sucesso.");
			this.sistemaAfetadoBugModifica = new SistemaAfetadoBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<SistemaAfetadoBug> listarSistemaAfetadoEspecificoBug(Bug bug) {
			
		return this.sistemaAfetadoBugServico.listarSistemaAfetadoEspecificoBug(bug);
		
	}

	public SistemaAfetadoBug getSistemaAfetadoBug() {
		return sistemaAfetadoBug;
	}

	public void setSistemaAfetadoBug(SistemaAfetadoBug sistemaAfetadoBug) {
		this.sistemaAfetadoBug = sistemaAfetadoBug;
	}

	public SistemaAfetadoBug getSistemaAfetadoBugModifica() {
		return sistemaAfetadoBugModifica;
	}

	public void setSistemaAfetadoBugModifica(SistemaAfetadoBug sistemaAfetadoBugModifica) {
		this.sistemaAfetadoBugModifica = sistemaAfetadoBugModifica;
	}

}
