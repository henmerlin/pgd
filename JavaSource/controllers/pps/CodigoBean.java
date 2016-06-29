package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.Codigo;
import models.pps.CodigoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class CodigoBean {

	private Codigo codigo;

	private Codigo codigoModifica;

	@EJB
	private CodigoServico codigoServico;

	public CodigoBean() {

		this.codigo = new Codigo();

		this.codigoModifica = new Codigo();

	}

	public void cadastrarCodigo() {

		try {

			this.codigoServico.cadastrarCodigo(this.codigo);			
			JSFUtil.addInfoMessage("Codigo cadastrado com sucesso.");
			this.codigo = new Codigo();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificarCodigo() {

		try {

			this.codigoServico.modificarCodigo(this.codigoModifica);			
			JSFUtil.addInfoMessage("Codigo modificado com sucesso.");
			this.codigo = new Codigo();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<Codigo> listarCodigos() {

		return this.codigoServico.listarCodigos();

	}

	public List<Codigo> listarCodigosAtivo() {

		return this.codigoServico.listarCodigosAtivo();

	}

	public Codigo getCodigo() {
		return codigo;
	}

	public void setCodigo(Codigo codigo) {
		this.codigo = codigo;
	}

	public Codigo getCodigoModifica() {
		return codigoModifica;
	}

	public void setCodigoModifica(Codigo codigoModifica) {
		this.codigoModifica = codigoModifica;
	}

}
