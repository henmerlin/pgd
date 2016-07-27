package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.Bug;
import entidades.bugs.DetalhesBug;
import models.bugs.DetalhesBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class DetalhesBugBean {
	
	private DetalhesBug detalhesBug;
	
	private DetalhesBug detalhesBugModifica;
	
	@EJB
	private DetalhesBugServico detalhesBugServico;

	public DetalhesBugBean() {
		
		this.detalhesBug = new DetalhesBug();
		
		this.detalhesBugModifica = new DetalhesBug();
		
	}
	
	public void cadastrarDetalhes(Bug bug) {
		
		try {
						
			this.detalhesBugServico.cadastrarDetalhes(this.detalhesBug, bug);
			JSFUtil.addInfoMessage("Detalhe cadastrado com sucesso.");
			this.detalhesBug = new DetalhesBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarDetalhes() {
		
		try {
			
			this.detalhesBugServico.modificarDetalhes(this.detalhesBugModifica);
			JSFUtil.addInfoMessage("Detalhe modificado com sucesso.");
			this.detalhesBugModifica = new DetalhesBug();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<DetalhesBug> listarDetalhesBugEspecifico(Bug bug) {
		
		return this.detalhesBugServico.listarDetalhesBugEspecifico(bug);
		
	}
	
	public DetalhesBug listarDetalhesBugEspecificoUm(Bug bug) {
		
		return this.detalhesBugServico.listarDetalhesBugEspecificoUm(bug);
		
	}
	

	public DetalhesBug getDetalhesBug() {
		return detalhesBug;
	}

	public void setDetalhesBug(DetalhesBug detalhesBug) {
		this.detalhesBug = detalhesBug;
	}

	public DetalhesBug getDetalhesBugModifica() {
		return detalhesBugModifica;
	}

	public void setDetalhesBugModifica(DetalhesBug detalhesBugModifica) {
		this.detalhesBugModifica = detalhesBugModifica;
	}	

}
