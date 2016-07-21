package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Impacto;
import models.projetos.ImpactoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ImpactoBean {
	
	private Impacto impacto;
	
	private Impacto impactoModifica;
	
	@EJB
	private ImpactoServico impactoServico;
	
	public ImpactoBean() {
		
		this.impacto = new Impacto();
		
		this.impactoModifica = new Impacto();

	}
	
	public void cadastrarImpacto() {
				
		try {
						
			this.impactoServico.cadastrarImpacto(this.impacto);
			JSFUtil.addInfoMessage("Impacto cadastrado com sucesso.");		
			this.impacto = new Impacto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());			
			
		}
		
	}
	
	public void modificaImpacto() {
		
		try {
			
			this.impactoServico.modificarImpacto(this.impactoModifica);
			JSFUtil.addInfoMessage("Impacto modificado com suceso");
			this.impactoModifica = new Impacto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Impacto> listarImpacto() {
		
		return this.impactoServico.listarImpacto();
		
	}
	
	public List<Impacto> listarImpactoAtivo() {
		
		return this.impactoServico.listarImpactoAtivo();
		
	}

	public Impacto getImpacto() {
		return impacto;
	}

	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}

	public Impacto getImpactoModifica() {
		return impactoModifica;
	}

	public void setImpactoModifica(Impacto impactoModifica) {
		this.impactoModifica = impactoModifica;
	}	

}
