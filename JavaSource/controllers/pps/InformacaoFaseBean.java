package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.InformacaoFase;
import entidades.pps.Pp;
import models.pps.InformacaoFaseServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class InformacaoFaseBean {
	
	private InformacaoFase informacaoFase;
	
	private InformacaoFase informacaoFaseModifica;
	
	@EJB
	private InformacaoFaseServico informacaoFaseServico;

	public InformacaoFaseBean() {
		
		this.informacaoFase = new InformacaoFase();
		
		this.informacaoFaseModifica = new InformacaoFase();
		
	}
	
	public void cadastrarInformacaoFase(Pp pp) {
		
		try {			
					
			this.informacaoFaseServico.cadastrarInformacaoFase(this.informacaoFase, pp);
			JSFUtil.addInfoMessage("Informação fase cadastrada com sucesso.");
			this.informacaoFase = new InformacaoFase();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());

		}
		
	}
	
	public void modificarInformacaoFase(Pp pp) {
		
		try {
			
			this.informacaoFaseServico.modificarInformacaoFase(this.informacaoFaseModifica);
			JSFUtil.addInfoMessage("Informação modificada com sucesso.");
			this.informacaoFase = new InformacaoFase();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<InformacaoFase> listarInformacaoFaseEspecifico(Pp pp) {
		
		return this.informacaoFaseServico.listarInformacaoFaseEspecifico(pp);
		
	}

	public InformacaoFase getInformacaoFase() {
		return informacaoFase;
	}

	public void setInformacaoFase(InformacaoFase informacaoFase) {
		this.informacaoFase = informacaoFase;
	}

	public InformacaoFase getInformacaoFaseModifica() {
		return informacaoFaseModifica;
	}

	public void setInformacaoFaseModifica(InformacaoFase informacaoFaseModifica) {
		this.informacaoFaseModifica = informacaoFaseModifica;
	}	
	
}
