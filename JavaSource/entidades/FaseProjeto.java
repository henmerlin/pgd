package entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FaseProjeto {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Fase fase;
	
	private Projeto projeto;
	
	private Status status;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private Double perc_Conclusao;
	
	public FaseProjeto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Double getPerc_Conclusao() {
		return perc_Conclusao;
	}

	public void setPerc_Conclusao(Double perc_Conclusao) {
		this.perc_Conclusao = perc_Conclusao;
	}	
	
	

}
