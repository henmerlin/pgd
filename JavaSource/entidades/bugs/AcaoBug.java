package entidades.bugs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import util.JSFUtil;

@Entity
@Table(name="pgd_bugs_acao_bug")
public class AcaoBug {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	@Lob
	private String descricao;
	
	private Date dataAcao;
	
	@ManyToOne
	private Bug bug;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataAcao() {
		return dataAcao;
	}
	
	public String getDataAcaoFormatada() {
		
		return JSFUtil.formatarData(this.dataAcao);
		
	}

	public void setDataAcao(Date dataAcao) {
		this.dataAcao = dataAcao;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
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
		AcaoBug other = (AcaoBug) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AcaoBug [id=" + id + "]";
	}
	
}
