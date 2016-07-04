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

	@ManyToOne
	private StatusFasePp statusFasePpOne;
	
	@ManyToOne
	private StatusFasePp statusFasePpTwo;
	
	@ManyToOne
	private StatusFasePp statusFasePpThree;
	
	public SequenciaRelatorioPp() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusFasePp getStatusFasePpOne() {
		return statusFasePpOne;
	}

	public void setStatusFasePpOne(StatusFasePp statusFasePpOne) {
		this.statusFasePpOne = statusFasePpOne;
	}

	public StatusFasePp getStatusFasePpTwo() {
		return statusFasePpTwo;
	}

	public void setStatusFasePpTwo(StatusFasePp statusFasePpTwo) {
		this.statusFasePpTwo = statusFasePpTwo;
	}

	public StatusFasePp getStatusFasePpThree() {
		return statusFasePpThree;
	}

	public void setStatusFasePpThree(StatusFasePp statusFasePpThree) {
		this.statusFasePpThree = statusFasePpThree;
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
