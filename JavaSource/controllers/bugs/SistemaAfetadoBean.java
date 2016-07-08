package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.SistemaAfetado;
import models.bugs.SistemaAfetadoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class SistemaAfetadoBean {
	
	private SistemaAfetado sistemaAfetado;
	
	private SistemaAfetado sistemaAfetadoModifica;
	
	@EJB
	private SistemaAfetadoServico sistemaAfetadoServico;

	public SistemaAfetadoBean() {
		
		this.sistemaAfetado = new SistemaAfetado();
		
		this.sistemaAfetadoModifica = new SistemaAfetado();
		
	}
	
	public void cadastrarSistema() {
		
		try {
			
			this.sistemaAfetadoServico.cadastrarSistemaAfetado(this.sistemaAfetado);
			JSFUtil.addInfoMessage("Sistema cadastrado com sucesso.");
			this.sistemaAfetado = new SistemaAfetado();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarSistemaAfetado() {
		
		try {
			
			this.sistemaAfetadoServico.modificarSistemaAfetado(this.sistemaAfetadoModifica);
			JSFUtil.addInfoMessage("Sistema modificado com sucesso.");
			this.sistemaAfetadoModifica = new SistemaAfetado();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<SistemaAfetado> listarSistema() {
		
		return this.sistemaAfetadoServico.listarSistema();
		
	}

	public SistemaAfetado getSistemaAfetado() {
		return sistemaAfetado;
	}

	public void setSistemaAfetado(SistemaAfetado sistemaAfetado) {
		this.sistemaAfetado = sistemaAfetado;
	}

	public SistemaAfetado getSistemaAfetadoModifica() {
		return sistemaAfetadoModifica;
	}

	public void setSistemaAfetadoModifica(SistemaAfetado sistemaAfetadoModifica) {
		this.sistemaAfetadoModifica = sistemaAfetadoModifica;
	}	

}
