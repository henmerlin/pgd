package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Fase;
import entidades.projetos.StatusFase;
import models.projetos.FaseServico;

@ManagedBean
@ViewScoped
public class FaseBean {

	private Fase fase;
	
	@EJB
	private FaseServico faseServico;
	
	public FaseBean() {
		
		this.fase = new Fase();
		
	}
	
	public List<StatusFase> listarFases() {
		
		return faseServico.listarFases();
		
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}	

}
