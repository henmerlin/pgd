package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.CodigoPp;
import entidades.pps.Pp;
import models.pps.CodigoPpServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class CodigoPpBean {

	private CodigoPp codigoPp;
	
	private CodigoPp codigoPpModifica;
	
	@EJB
	private CodigoPpServico codigoPpServico;
	
	public CodigoPpBean() {
		
		this.codigoPp = new CodigoPp();
		
		this.codigoPpModifica = new CodigoPp();
		
	}
	
	public void cadastrarCodigoPp(Pp pp) {
		
		try {
			
			this.codigoPpServico.cadastrarCodigoPp(this.codigoPp, pp);
			JSFUtil.addInfoMessage("Codigo para o pp cadastrado com sucesso.");
			this.codigoPp = new CodigoPp();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificaCodigoPp() {
		
		try {
			
			this.codigoPpServico.modificaCodigoPp(this.codigoPpModifica);
			JSFUtil.addInfoMessage("Código para o pp modificado com sucesso");
			this.codigoPpModifica = new CodigoPp();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<CodigoPp> listarCodigoPpEspecifico(Pp pp) {
		
		return this.codigoPpServico.listarCodigoPpEspecifico(pp);
		
	}

	public CodigoPp getCodigoPp() {
		return codigoPp;
	}

	public void setCodigoPp(CodigoPp codigoPp) {
		this.codigoPp = codigoPp;
	}

	public CodigoPp getCodigoPpModifica() {
		return codigoPpModifica;
	}

	public void setCodigoPpModifica(CodigoPp codigoPpModifica) {
		this.codigoPpModifica = codigoPpModifica;
	}
	
}
