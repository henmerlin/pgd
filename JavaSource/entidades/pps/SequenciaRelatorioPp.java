package entidades.pps;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pdg_pps_Sequencia_Relatorio_Pp")
public class SequenciaRelatorioPp {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Boolean ativo;

	@ManyToOne
	private StatusFasePp statusFasePp;	
	
	public SequenciaRelatorioPp() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public StatusFasePp getStatusFasePp() {
		return statusFasePp;
	}

	public void setStatusFasePp(StatusFasePp statusFasePp) {
		this.statusFasePp = statusFasePp;
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
		SequenciaRelatorioPp other = (SequenciaRelatorioPp) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SequenciaRelatorioPp [id=" + id + "]";
	}
	
}
