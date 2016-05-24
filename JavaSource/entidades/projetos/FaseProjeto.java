package entidades.projetos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
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

}
