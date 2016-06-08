package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.TipoProjeto;
import models.projetos.TipoProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class TipoProjetoBean {
	
	private TipoProjeto tipoProjeto;
	
	private TipoProjeto tipoProjetoCadastro;
	
	@EJB
	private TipoProjetoServico tipoProjetoServico;

	public TipoProjetoBean() {
		
		this.tipoProjeto = new TipoProjeto();
		
		this.tipoProjetoCadastro = new TipoProjeto();
		
	}
	
	public List<TipoProjeto> listarTipoProjeto() {
		
		return this.tipoProjetoServico.listarTipoProjeto();
		
	}
	
	public void modificarTipoProjeto() {
		
		try {
			
			this.tipoProjetoServico.modificarTipoProjeto(this.tipoProjeto);
			
			this.tipoProjeto = new TipoProjeto();
			
			JSFUtil.addInfoMessage("Tipo projeto modificado com sucesso");
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());			
			
		}		
		
	}
	
	public void cadastrarTipoProjeto() {
		
		try {
			
			this.tipoProjetoServico.cadastrarTipoProjeto(this.tipoProjetoCadastro);
			
			this.tipoProjetoCadastro = new TipoProjeto();
			
			JSFUtil.addInfoMessage("Tipo projeto cadastrado com sucesso");
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<TipoProjeto> listarTipoProjetoAtivo() {
		
		return this.tipoProjetoServico.listarTipoProjetoAtivo();
		
	}
	
	public TipoProjeto getTipoProjeto() {
		return tipoProjeto;
	}

	public void setTipoProjeto(TipoProjeto tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}

	public TipoProjeto getTipoProjetoCadastro() {
		return tipoProjetoCadastro;
	}

	public void setTipoProjetoCadastro(TipoProjeto tipoProjetoCadastro) {
		this.tipoProjetoCadastro = tipoProjetoCadastro;
	}

}
