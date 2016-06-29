package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.Pp;
import models.pps.PpServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class PpBean {
	
	private Pp pp;
	
	@EJB
	private PpServico ppServico;
	
	public PpBean() {
		
		this.pp = new Pp();
		
	}
	
	public void cadastrarPp() {
		
		try {
			
			this.ppServico.cadastrarPp(this.pp);
			JSFUtil.addInfoMessage("Pp cadastrado com sucesso.");
			this.pp = new Pp();			
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarPp() {
		
		try {
			
			this.ppServico.modificarPp(this.pp);
			JSFUtil.addInfoMessage("Pp modificado com sucesso.");
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Pp> listarPp() {
		
		return this.ppServico.listarPp();
		
	}
	
	public Pp listarPpEspecifico() {
		
		try {
			
			this.pp = this.ppServico.listarPpEspecifico(this.pp);
			
			return this.pp;			
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			return null;
						
		}
		
	}

	public Pp getPp() {
		return pp;
	}

	public void setPp(Pp pp) {
		this.pp = pp;
	}	

}
