package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.TipoProjeto;
import models.projetos.TipoProjetoServico;

@ManagedBean
@ViewScoped
public class TipoProjetoBean {

	private TipoProjeto tipoProjeto;
	
	@EJB
	private TipoProjetoServico tipoProjetoServico;
	
		
	public TipoProjetoBean() {
		
		this.tipoProjeto = new TipoProjeto();
		
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
	
}
