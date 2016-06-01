package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Impacto;
import models.projetos.ImpactoServico;

@ManagedBean
@ViewScoped
public class ImpactoBean {

	private Impacto impacto;
	
	@EJB
	private ImpactoServico impactoServico;
	
	public ImpactoBean() {
		
		this.impacto = new Impacto();
		
	}
	
	public List<Impacto> listarImpacto() {
		
		return this.impactoServico.listarImpacto();
		
	}

	public Impacto getImpacto() {
		return impacto;
	}

	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}

}
