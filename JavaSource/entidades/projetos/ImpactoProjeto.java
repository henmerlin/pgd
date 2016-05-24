package entidades.projetos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ImpactoProjeto {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String descricao;
	
	private Date dataImpacto;
	
	@ManyToOne
	private Impacto impacto;

	@ManyToOne
	private Projeto projeto;
	
	public ImpactoProjeto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataImpacto() {
		return dataImpacto;
	}

	public void setDataImpacto(Date dataImpacto) {
		this.dataImpacto = dataImpacto;
	}

	public Impacto getImpacto() {
		return impacto;
	}

	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}	

}
