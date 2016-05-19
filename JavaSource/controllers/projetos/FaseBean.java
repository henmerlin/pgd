package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Fase;
import models.projetos.FaseServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class FaseBean {
	
	private Fase fase;
	
	@EJB
	private FaseServico faseServico;

	public FaseBean() {
		
		this.fase = new Fase();
		
	}
	
	public void cadastrarFase() {
		
		try {
			
			this.faseServico.cadastrarFase(this.fase);
			
			this.fase = new Fase();
			
			JSFUtil.addInfoMessage("Fase cadastrada com sucesso");
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Fase> listarFase() {
		
		return this.faseServico.listarFase();		
		
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

}
