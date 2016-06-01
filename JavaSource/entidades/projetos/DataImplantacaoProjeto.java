package entidades.projetos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import util.JSFUtil;

@Entity
public class DataImplantacaoProjeto {
	
	@Id
	@GeneratedValue
	private Integer id;

	private Date data;
	
	@Lob
	private String descricao;
	
	@ManyToOne
	private Projeto projeto;
	
	public DataImplantacaoProjeto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String getDataFormatada() {
		
		return JSFUtil.formatarData(this.data);
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}	

}
