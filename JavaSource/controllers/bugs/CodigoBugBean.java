package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.CodigoBug;
import models.bugs.CodigoBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class CodigoBugBean {
	
	private CodigoBug codigoBug;

	private CodigoBug codigoBugModifica;
	
	@EJB
	private CodigoBugServico codigoBugServico;
	
	public CodigoBugBean() {
		
		this.codigoBug = new CodigoBug();
		
		this.codigoBugModifica = new CodigoBug();
		
	}
	
	public void cadastrarCodigoBug() {
		
		try {
			
			this.codigoBugServico.cadastrarCodigoBug(this.codigoBug);
			JSFUtil.addInfoMessage("Código cadastrado com sucesso.");
			this.codigoBug = new CodigoBug();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarCodigoBug() {
		
		try {
			
			this.codigoBugServico.modificarCodigoBug(this.codigoBugModifica);
			JSFUtil.addInfoMessage("Código modificado com sucesso.");
			this.codigoBugModifica = new CodigoBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<CodigoBug> listarCodigoBug() {
		
		return this.codigoBugServico.listarCodigoBug();
		
	}
	

	public CodigoBug getCodigoBug() {
		return codigoBug;
	}

	public void setCodigoBug(CodigoBug codigoBug) {
		this.codigoBug = codigoBug;
	}

	public CodigoBug getCodigoBugModifica() {
		return codigoBugModifica;
	}

	public void setCodigoBugModifica(CodigoBug codigoBugModifica) {
		this.codigoBugModifica = codigoBugModifica;
	}
	
}
