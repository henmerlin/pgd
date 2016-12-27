package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.Beneficio;
import models.pps.BeneficioServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class BeneficioBean {

	private Beneficio beneficio;

	private Beneficio beneficioModifica;

	@EJB
	private BeneficioServico beneficioServico;

	public BeneficioBean() {

		this.beneficio = new Beneficio();

		this.beneficioModifica = new Beneficio();

	}

	public void cadastrarBeneficio() {

		try {

			this.beneficioServico.cadastrarBeneficio(this.beneficio);			
			JSFUtil.addInfoMessage("Benef�cio cadastrado com sucesso.");			
			this.beneficio = new Beneficio();


		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificarBeneficio() {

		try {

			this.beneficioServico.modificarBeneficio(this.beneficioModifica);
			JSFUtil.addInfoMessage("Beneício modificado com sucesso.");
			this.beneficioModifica = new Beneficio();			

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<Beneficio> listarBeneficios() { 

		return this.beneficioServico.listarBeneficios();

	}

	public List<Beneficio> listarBeneficiosAtivos() { 

		return this.beneficioServico.listarBeneficiosAtivos();

	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public Beneficio getBeneficioModifica() {
		return beneficioModifica;
	}

	public void setBeneficioModifica(Beneficio beneficioModifica) {
		this.beneficioModifica = beneficioModifica;
	}

}
