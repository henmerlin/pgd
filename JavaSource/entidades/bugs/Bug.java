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
@Table(name="pgd_bugs_bug")
public class Bug {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String titulo;
	
	@Lob
	private String descricao;
	
	private String solicitante;
	
	private Date dataAbertura;
	
	private Date previsao;
	
	@ManyToOne
	private StatusBug statusBug;
	
	private String areaSolicitante;

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

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public String getDataAberturaFormatada() {
		
		return JSFUtil.formatarData(this.dataAbertura);
		
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getPrevisao() {
		return previsao;
	}
	
	public String getPrevisaoFormatada() {
		
		return JSFUtil.formatarData(this.previsao);
		
	}

	public void setPrevisao(Date previsao) {
		this.previsao = previsao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public StatusBug getStatusBug() {
		return statusBug;
	}

	public void setStatusBug(StatusBug statusBug) {
		this.statusBug = statusBug;
	}	

	public String getAreaSolicitante() {
		return areaSolicitante;
	}

	public void setAreaSolicitante(String areaSolicitante) {
		this.areaSolicitante = areaSolicitante;
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
		Bug other = (Bug) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bug [id=" + id + "]";
	}
	
}
