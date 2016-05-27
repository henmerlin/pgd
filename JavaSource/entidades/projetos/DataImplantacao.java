package entidades.projetos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import util.JSFUtil;

@Entity
public class DataImplantacao {

	@Id
	@GeneratedValue
	private Integer id;

	private Date dataMod;

	private Date dataAlteracao;

	@Lob
	private String descricao;

	@ManyToOne
	private Projeto projeto;

	public DataImplantacao() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataMod() {
		return dataMod;
	}

	public void setDataMod(Date dataMod) {
		this.dataMod = dataMod;
	}

	public String getDataFormatada() {

		String formatada;

		if (this.dataMod == null){

			formatada = "";

		}else{

			formatada = JSFUtil.formatarData(this.dataMod);

		}

		return formatada;

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

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getDataFormatadaAlteracao() {

		String formatada;

		if (this.dataAlteracao == null){

			formatada = "";

		}else{

			formatada = JSFUtil.formatarData(this.dataAlteracao);

		}

		return formatada;

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
		DataImplantacao other = (DataImplantacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DataImplantacao [id=" + id + "]";
	}

}
