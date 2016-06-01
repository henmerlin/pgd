package entidades.projetos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import util.JSFUtil;

@Entity
public class FaseProjeto {

	@Id
	@GeneratedValue
	private Integer id;

	private Date dataInicio;

	private Date dataFim;

	private Double porcentagemConclusao;

	@ManyToOne
	private Projeto projeto;
	
	@ManyToOne
	private Fase fase;	
	
	public FaseProjeto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public String getDataInicioFormatada() {

		return JSFUtil.formatarData(this.dataInicio);

	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public String getDataFimFormatada() {

		return JSFUtil.formatarData(this.dataFim);

	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Double getPorcentagemConclusao() {
		return porcentagemConclusao;
	}

	public void setPorcentagemConclusao(Double porcentagemConclusao) {
		this.porcentagemConclusao = porcentagemConclusao;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}	

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaseProjeto other = (FaseProjeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FaseProjeto [id=" + id + "]";
	}

}
