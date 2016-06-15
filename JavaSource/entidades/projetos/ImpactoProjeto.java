package entidades.projetos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import util.JSFUtil;

@Entity
@Table(name="pdg_Impacto_Projeto")
public class ImpactoProjeto {

	@Id
	@GeneratedValue
	private Integer id;

	@Lob
	private String descricao;
	
	private Date dataImpacto;
	
	@ManyToOne
	private Projeto projeto;
	
	@ManyToOne
	private Impacto impacto;	
	
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
	
	public String getDataImpactoFormatada() {
		
		return JSFUtil.formatarData(this.dataImpacto);
		
	}

	public void setDataImpacto(Date dataImpacto) {
		this.dataImpacto = dataImpacto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Impacto getImpacto() {
		return impacto;
	}

	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}	

}
